package br.com.pdv.marketcontrol.model;

import br.com.pdv.marketcontrol.model.enums.TipoPagamento;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

@Entity
public class Venda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Float valor;
    @Column(name = "tipo_pagamento")
    private TipoPagamento tipoPagamento;
    @Column(name = "data_venda")
    private LocalDate dataVenda;

    public Set<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(Set<Produto> produtos) {
        this.produtos = produtos;
    }

    @ManyToMany
    private Set<Produto> produtos;

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }

    public TipoPagamento getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(TipoPagamento tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }

    public LocalDate getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(LocalDate dataVenda) {
        this.dataVenda = dataVenda;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Venda{" +
                "id=" + id +
                ", valor=" + valor +
                ", tipoPagamento='" + tipoPagamento + '\'' +
                ", dataVenda=" + dataVenda +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Venda venda = (Venda) o;
        return id.equals(venda.id) && valor.equals(venda.valor) && tipoPagamento.equals(venda.tipoPagamento) && dataVenda.equals(venda.dataVenda);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, valor, tipoPagamento, dataVenda);
    }
}
