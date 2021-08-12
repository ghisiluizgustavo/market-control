package br.com.pdv.marketcontrol.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private Long id;
    @NotNull
    private String nome;
    private Float valor;
    @Column(name = "data_vencimento")
    private LocalDate vencimento;
    @Column(name = "cod_barras")
    private String codBarras;
    private Integer quantidade;

    @JsonIgnore
    @ManyToMany(mappedBy = "produtos")
    private List<Venda> vendas;

    public Produto(){
    }

    public Produto(Produto produto){
        this.codBarras = produto.getCodBarras();
        this.nome = produto.getNome();
        this.quantidade = produto.getQuantidade();
        this.valor = produto.getValor();
        this.vencimento = produto.getVencimento();
    }

    public List<Venda> getVendas() {
        return vendas;
    }

    public void setVendas(List<Venda> vendas) {
        this.vendas = vendas;
    }

    public String getCodBarras() {
        return codBarras;
    }

    public void setCodBarras(String codBarras) {
        this.codBarras = codBarras;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }

    public LocalDate getVencimento() {
        return vencimento;
    }

    public void setVencimento(LocalDate vencimento) {
        this.vencimento = vencimento;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", valor=" + valor +
                ", vencimento=" + vencimento +
                ", codBarras='" + codBarras + '\'' +
                ", quantidade=" + quantidade +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return id.equals(produto.id) && nome.equals(produto.nome) && valor.equals(produto.valor) && Objects.equals(vencimento, produto.vencimento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, valor, vencimento);
    }

}
