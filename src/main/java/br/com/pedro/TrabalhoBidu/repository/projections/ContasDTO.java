package br.com.pedro.TrabalhoBidu.repository.projections;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ContasDTO {
    private Long idContas;

    private String nomeCliente;

    private LocalDate dateConta;

    private BigDecimal valorConta;

    public ContasDTO(Long idContas, String nomeCliente, LocalDate dateConta, BigDecimal valorConta) {
        this.idContas = idContas;
        this.nomeCliente = nomeCliente;
        this.dateConta = dateConta;
        this.valorConta = valorConta;
    }

    public Long getIdContas() {
        return idContas;
    }

    public void setIdContas(Long idContas) {
        this.idContas = idContas;
    }

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
