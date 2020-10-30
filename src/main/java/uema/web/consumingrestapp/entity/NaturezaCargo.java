package uema.web.consumingrestapp.entity;


import javax.persistence.*;

@Entity
public class NaturezaCargo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id")
    private Integer id;

    @Column(name = "naturezaCargoId")
    private Integer naturezaCargoId;

    @Column(name = "nome") //, nullable = false (obrigatório)
    private String nome;

    public NaturezaCargo() {
    }

    public NaturezaCargo(Integer naturezaCargoId, String nome) {
        this.naturezaCargoId = naturezaCargoId;
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNaturezaCargoId() {
        return naturezaCargoId;
    }

    public void setNaturezaCargoId(Integer naturezaCargoId) {
        this.naturezaCargoId = naturezaCargoId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
