package br.com.pdv.marketcontrol.model.dto;

import br.com.pdv.marketcontrol.model.Produto;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

public class NovoProdutoDTO {

    @NotBlank
    private String nome;
    @NotBlank
    private Float valor;
    @NotBlank
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotBlank
    private LocalDate vencimento;
    @NotBlank
    private String codBarras;
    @NotBlank
    private Integer quantidade;

    public Produto convertToProduto(NovoProdutoDTO produto){
        Produto prod = new Produto();
        prod.setNome(produto.getNome());
        prod.setValor(produto.getValor());
        prod.setVencimento(produto.getVencimento());
        prod.setCodBarras(produto.getCodBarras());
        prod.setQuantidade(produto.getQuantidade());
        return prod;
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
}
