package br.com.pdv.marketcontrol.model;

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
    private String tipoPagamento;
    @Column(name = "data_venda")
    private LocalDate dataVenda;
    @ManyToMany
    private Set<Produto> produtos;

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }

    public String getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(String tipoPagamento) {
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
