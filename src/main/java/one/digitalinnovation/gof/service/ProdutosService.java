package one.digitalinnovation.gof.service;

import one.digitalinnovation.gof.model.Produto;

public interface ProdutosService {

    Iterable<Produto> buscarTodos();

    Produto buscaPorId(Long id);

    void inserir(Produto produto);

    void atualizar(Long id, Produto produto);

    void deletar(Long id);


}
