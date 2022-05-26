package one.digitalinnovation.gof.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nome;
    private String ean;

    @OneToMany(cascade={CascadeType.MERGE}, fetch = FetchType.LAZY)
    List<Distribuidora> distribuidoras = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEan() {
        return ean;
    }

    public List<Distribuidora> getDistribuidora() {
        return distribuidoras;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEan(String ean) {
        this.ean = ean;
    }

    public void setDistribuidoras(List<Distribuidora> distribuidoras) {
        this.distribuidoras = distribuidoras;
    }
}
