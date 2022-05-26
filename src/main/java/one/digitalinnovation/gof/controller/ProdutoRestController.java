package one.digitalinnovation.gof.controller;

import one.digitalinnovation.gof.model.Produto;
import one.digitalinnovation.gof.service.ProdutosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/produto")
public class ProdutoRestController {

    @Autowired
    private ProdutosService produtosService;

    @GetMapping
    public ResponseEntity<Iterable<Produto>> buscarTodos(){
        return ResponseEntity.ok(produtosService.buscarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok(produtosService.buscaPorId(id));
    }
    @PostMapping
    public ResponseEntity<Produto> inserir(@RequestBody Produto produto){
        produtosService.inserir(produto);
        return ResponseEntity.ok(produto);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Produto> atualizar(@PathVariable Long id, @RequestBody Produto produto){
        produtosService.atualizar(id, produto);
        return ResponseEntity.ok(produto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        produtosService.deletar(id);
        return ResponseEntity.ok().build();
    }







}
