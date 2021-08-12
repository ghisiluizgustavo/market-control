package br.com.pdv.marketcontrol.model.dto;

import br.com.pdv.marketcontrol.model.Produto;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class NovoProdutoDTO {

    @NotBlank(message = "O nome é obrigatório")
    private String nome;
    @NotNull(message = "O valor é obrigatório")
    private Float valor;
    @NotNull(message = "")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate vencimento;
    @NotBlank(message = "O codigo de barras é obrigatório")
    private String codBarras;
    @NotNull(message = "")
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
