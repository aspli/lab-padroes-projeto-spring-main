package one.digitalinnovation.gof.service.impl;

import one.digitalinnovation.gof.model.Distribuidora;
import one.digitalinnovation.gof.model.Endereco;
import one.digitalinnovation.gof.model.Produto;
import one.digitalinnovation.gof.repository.DistribuidoraRepository;
import one.digitalinnovation.gof.repository.EnderecoRepository;
import one.digitalinnovation.gof.repository.ProdutoRepository;
import one.digitalinnovation.gof.service.ProdutosService;
import one.digitalinnovation.gof.service.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoServiceImpl implements ProdutosService {

    @Autowired
    private ProdutoRepository produtoRepository;
    @Autowired
    private DistribuidoraRepository distribuidoraRepository;
    @Autowired
    private EnderecoRepository enderecoRepository;
    @Autowired
    private ViaCepService viaCepService;


    public Iterable<Produto> buscarTodos() {
        return produtoRepository.findAll();
    }


    public Produto buscaPorId(Long id) {
        Optional<Produto> resultadoBusca = produtoRepository.findById(id);
        return resultadoBusca.orElse(null);
    }


    public void inserir(Produto produto) {
        inserirProdutoComDistribuidora(produto);
    }


    public void atualizar(Long id, Produto produto) {
        Optional<Produto> produtoDB = produtoRepository.findById(id);
        if(produtoDB.isPresent()){
            inserirProdutoComDistribuidora(produto);
        }
    }

    public void deletar(Long id) {
        produtoRepository.deleteById(id);
    }

    private void inserirProdutoComDistribuidora(Produto produto){
        List<Distribuidora> distribuidoraList = produto.getDistribuidora();
        distribuidoraList.forEach(this::inserirDistribuidoraComCep);
        produtoRepository.save(produto);
    }

    private void inserirDistribuidoraComCep(Distribuidora distribuidora){
        String cep = distribuidora.getEndereco().getCep();
        Endereco endereco = enderecoRepository.findById(cep).orElseGet(() -> {
            Endereco enderecoNovo = viaCepService.consultarCep(cep);
            enderecoRepository.save(enderecoNovo);
            return enderecoNovo;
        });

        distribuidora.setEndereco(endereco);
        distribuidoraRepository.save(distribuidora);
    }



}
