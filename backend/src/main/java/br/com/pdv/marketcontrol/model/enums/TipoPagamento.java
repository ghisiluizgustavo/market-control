package br.com.pdv.marketcontrol.model.enums;

public enum TipoPagamento {
    CREDITO ("Crédito"),
    DINHEIRO ("Dinheiro"),
    FIADO ("Fiado");

    private String desc;
    TipoPagamento(String desc) {
        this.desc = desc;
    }
}
