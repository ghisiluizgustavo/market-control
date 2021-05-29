package br.com.pdv.marketcontrol.model.dto;

import br.com.pdv.marketcontrol.model.Produto;
import br.com.pdv.marketcontrol.model.Venda;
import br.com.pdv.marketcontrol.model.enums.TipoPagamento;
import org.springframework.data.domain.Page;

import java.time.LocalDate;
import java.util.List;

public class VendaDTO {

    private Long id;
    private Float valor;
    private TipoPagamento tipoPagamento;
    private LocalDate dataVenda;
    private List<Produto> produtos;

    public VendaDTO(Venda venda) {
        this.id = venda.getId();
        this.valor = venda.getValor();
        this.tipoPagamento = venda.getTipoPagamento();
        this.dataVenda = venda.getDataVenda();
        this.produtos = venda.getProdutos();
    }

    public Long getId() {
        return id;
    }

    public Float getValor() {
        return valor;
    }

    public TipoPagamento getTipoPagamento() {
        return tipoPagamento;
    }

    public LocalDate getDataVenda() {
        return dataVenda;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public static Page<VendaDTO> converter(Page<Venda> vendas) {
        return vendas.map(VendaDTO::new);
    }

}
