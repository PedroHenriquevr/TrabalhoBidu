package br.com.pedro.TrabalhoBidu.models;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.*;


@Entity
@Table(name = "Contas")
public class Contas {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)

  private Long idContas;
  private LocalDate dateConta;
  private BigDecimal valorConta;

  @ManyToOne
  @JoinColumn(name = "idCliente")
  private Cliente cliente;


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

  public Cliente getCliente() {
    return cliente;
  }

  public void setCliente(Cliente cliente) {
    this.cliente = cliente;
  }


  public Long getIdContas() {
    return idContas;
  }

  public void setIdContas(Long idContas) {
    this.idContas = idContas;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Contas contas = (Contas) o;
    return Objects.equals(idContas, contas.idContas);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idContas);
  }
}
