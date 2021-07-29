package br.com.pdv.marketcontrol.model.dto;

import br.com.pdv.marketcontrol.model.Produto;
import org.springframework.data.domain.Page;

import java.time.LocalDate;
import java.util.Optional;

public class ProdutoDTO {

    private Long id;
    private String nome;
    private Float valor;
    private LocalDate vencimento;
    private String codBarras;
    private Integer quantidade;

    public ProdutoDTO(Produto produto){
        this.id = produto.getId();
        this.nome = produto.getNome();
        this.valor = produto.getValor();
        this.vencimento = produto.getVencimento();
        this.codBarras = produto.getCodBarras();
        this.quantidade = produto.getQuantidade();
    }

    public static Page<ProdutoDTO> converter(Page<Produto> produtos){
        return produtos.map(ProdutoDTO::new);
    }

    public static ProdutoDTO converter(Produto produto){
        return new ProdutoDTO(produto);
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
