package one.digitalinnovation.gof.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Livro")
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String nome;
    private String isbn;
    @Column(nullable = false)
    private String autor;
    private String editora;
    private String anoLancamento;
    private Integer paginas;

    @OneToMany(cascade={CascadeType.MERGE}, fetch = FetchType.LAZY)
    List<Livraria> livrarias = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public String getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(String anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public Integer getPaginas() {
        return paginas;
    }

    public void setPaginas(Integer paginas) {
        this.paginas = paginas;
    }

    public List<Livraria> getLivrarias() {
        return livrarias;
    }

    public void setLivrarias(List<Livraria> livrarias) {
        this.livrarias = livrarias;
    }
}
