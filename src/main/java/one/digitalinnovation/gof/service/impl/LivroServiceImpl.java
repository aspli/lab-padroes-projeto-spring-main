package one.digitalinnovation.gof.service.impl;

import one.digitalinnovation.gof.model.Endereco;
import one.digitalinnovation.gof.model.Livraria;
import one.digitalinnovation.gof.model.Livro;
import one.digitalinnovation.gof.repository.EnderecoRepository;
import one.digitalinnovation.gof.repository.LivrariaRepository;
import one.digitalinnovation.gof.repository.LivroRepository;
import one.digitalinnovation.gof.service.LivroService;
import one.digitalinnovation.gof.service.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivroServiceImpl implements LivroService {
    @Autowired
    private LivroRepository livroRepository;
    @Autowired
    private LivrariaRepository livrariaRepository;
    @Autowired
    private EnderecoRepository enderecoRepository;
    @Autowired
    private ViaCepService viaCepService;


    public Iterable<Livro> buscarTodos() {
        return livroRepository.findAll();
    }


    public Livro buscaPorId(Long id) {
        Optional<Livro> resultadoBusca = livroRepository.findById(id);
        return resultadoBusca.orElse(null);
    }


    public void inserir(Livro livro) {
        inserirLivroComLivraria(livro);
    }


    public void atualizar(Long id, Livro livro) {
        Optional<Livro> livroDB = livroRepository.findById(id);
        if(livroDB.isPresent()){
            inserirLivroComLivraria(livro);
        }
    }

    public void deletar(Long id) {
        livroRepository.deleteById(id);
    }

    private void inserirLivroComLivraria(Livro livro){
        List<Livraria> livrariaList = livro.getLivrarias();
        livrariaList.forEach(this::inserirLivrariaComCep);
        livroRepository.save(livro);
    }

    private void inserirLivrariaComCep(Livraria livraria){
        String cep = livraria.getEndereco().getCep();
        Endereco endereco = enderecoRepository.findById(cep).orElseGet(() -> {
            Endereco enderecoNovo = viaCepService.consultarCep(cep);
            enderecoRepository.save(enderecoNovo);
            return enderecoNovo;
        });
        livraria.setEndereco(endereco);
        livrariaRepository.save(livraria);
    }
}
