package br.com.pedro.TrabalhoBidu.repository.filter;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ContasFilter {

    private String nomeCliente;

    private LocalDate dateConta;

    private BigDecimal valorConta;


    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public LocalDate getDateConta() {
        return dateConta;
    }

    public void setDateConta(LocalDate dateConta) {
        this.dateConta = dateConta;
    }

    public BigDecimal getValorConta() {
        return valorConta;
    }

    public void setValorConta(BigDecimal valorConta) {
        this.valorConta = valorConta;
    }
}
