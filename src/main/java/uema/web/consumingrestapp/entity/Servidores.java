package uema.web.consumingrestapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.JsonNode;

import javax.persistence.*;


@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Servidores {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(name = "Id")
    private Integer id;

    @Column(name = "acumulos")
    private Integer acumulos;

    @Column(name = "ano")
    private Integer ano;

    @Column(name="cargo")
    private String cargo;

    @Column(name="cnpj")
    private String cnpj;

    @Column(name="cpf")
    private String cpf;

    @Column(name = "mes")
    private Integer mes;

    @Transient
    @Column(name = "naturezaCargo")
    private JsonNode naturezaCargo;

    @Column(name = "nome")
    private String nome;

    @Column(name="nomeUnidadeLotacao")
    private String nomeUnidadeLotacao;

    @Column(name = "servidorId")
    private Integer servidorId;

    @Transient
    @Column(name = "unidade")
    private JsonNode unidade;

    @Column(name = "valorBruto")
    private Double valorBruto;

    @Column(name = "valorBrutoTotal")
    private Double valorBrutoTotal;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "naturezaCargoId")
    private NaturezaCargo naturezaCargoId;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "unidadeId")
    private Unidade unidadeId;

    public Servidores() {
    }

    public Servidores(Integer servidorId, String nome, String cargo, String cnpj, String cpf, Integer mes, Integer ano, Double valorBruto,
                      NaturezaCargo naturezaCargoId, Unidade unidadeId, Integer acumulos, Double valorBrutoTotal, String nomeUnidadeLotacao) {

        this.acumulos = acumulos;
        this.ano = ano;
        this.cargo = cargo;
        this.cnpj = cnpj;
        this.cpf = cpf;
        this.mes = mes;
        this.naturezaCargo = naturezaCargo;
        this.nome = nome;
        this.nomeUnidadeLotacao = nomeUnidadeLotacao;
        this.servidorId = servidorId;
        this.unidade = unidade;
        this.valorBruto = valorBruto;
        this.valorBrutoTotal = valorBrutoTotal;

        this.naturezaCargoId = naturezaCargoId;
        this.unidadeId = unidadeId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAcumulos() {
        return acumulos;
    }

    public void setAcumulos(Integer acumulos) {
        this.acumulos = acumulos;
    }

    public Integer getAno() {
        return ano;
    }

    public void getAno(Integer ano) {
        this.ano = ano;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }


    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Integer getMes() {
        return mes;
    }

    public void setMes(Integer mes) {
        this.mes = mes;
    }

    public JsonNode getNaturezaCargo() {
        return naturezaCargo;
    }

    public void setNaturezaCargo(JsonNode naturezaCargo) {
        this.naturezaCargo = naturezaCargo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNomeUnidadeLotacao() {
        return nomeUnidadeLotacao;
    }

    public void setNomeUnidadeLotacao(String nomeUnidadeLotacao) {
        this.nomeUnidadeLotacao = nomeUnidadeLotacao;
    }

    public Integer getServidorId() {
        return servidorId;
    }

    public void setServidorId(Integer servidorId) {
        this.servidorId = servidorId;
    }

    public JsonNode getUnidade() {
        return unidade;
    }

    public void setUnidade(JsonNode unidade) {
        this.unidade = unidade;
    }

    public Double getValorBruto() {
        return valorBruto;
    }

    public void setValorBruto(Double valorBruto) {
        this.valorBruto = valorBruto;
    }


    public Double getValorBrutoTotal() {
        return valorBrutoTotal;
    }

    public void setValorBrutoTotal(Double valorBrutoTotal) {
        this.valorBrutoTotal = valorBrutoTotal;
    }
}
