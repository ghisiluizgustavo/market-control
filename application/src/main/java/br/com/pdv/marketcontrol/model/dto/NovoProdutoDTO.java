package br.com.pdv.marketcontrol.model.dto;

import br.com.pdv.marketcontrol.model.Produto;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class NovoProdutoDTO {

    @NotBlank(message = "o nome é um campo obrigatório")
    private String nome;
    @NotNull(message = "o valor é um campo obrigatório")
    private Float valor;
    @NotNull(message = "a data de vencimento é um campo obrigatório")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate vencimento;
    @NotEmpty(message = "o código de barras é um campo obrigatório")
    private String codBarras;
    @NotNull(message = "a quantidade é um campo obrigatório")
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
