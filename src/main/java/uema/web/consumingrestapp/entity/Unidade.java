package uema.web.consumingrestapp.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.JsonNode;

import javax.persistence.*;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Unidade {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id")
    private Integer id;

    @Column(name = "unidadeId")
    private Integer unidadeId;

    @Column(name = "nome") //, nullable = false (obrigatório)
    private String nome;

    @Transient
    @Column(name = "ente")
    private JsonNode ente;

    public Unidade() {
    }

    public Unidade(Integer unidadeId, String nome, JsonNode ente) {
        this.unidadeId = unidadeId;
        this.nome = nome;
        this.ente = ente;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUnidadeId() {
        return unidadeId;
    }

    public void setUnidadeId(Integer unidadeId) {
        this.unidadeId = unidadeId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public JsonNode getEntes() {
        return ente;
    }

    public void setEntes(JsonNode ente) {
        this.ente = ente;
    }
}
