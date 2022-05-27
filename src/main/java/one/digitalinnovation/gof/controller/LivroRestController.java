package one.digitalinnovation.gof.controller;

import one.digitalinnovation.gof.model.Livro;
import one.digitalinnovation.gof.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/livro")
public class LivroRestController {
    @Autowired
    private LivroService livroService;

    @GetMapping
    public ResponseEntity<Iterable<Livro>> buscarTodos(){
        return ResponseEntity.ok(livroService.buscarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Livro> buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok(livroService.buscaPorId(id));
    }
    @PostMapping
    public ResponseEntity<Livro> inserir(@RequestBody Livro livro){
        livroService.inserir(livro);
        return ResponseEntity.ok(livro);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Livro> atualizar(@PathVariable Long id, @RequestBody Livro livro){
        livroService.atualizar(id, livro);
        return ResponseEntity.ok(livro);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        livroService.deletar(id);
        return ResponseEntity.ok().build();
    }
}
