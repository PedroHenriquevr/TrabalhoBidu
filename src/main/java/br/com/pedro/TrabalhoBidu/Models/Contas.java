package br.com.pedro.TrabalhoBidu.Models;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "Contas")
public class Contas {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)

  private Integer idContas;
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

  public Integer getIdContas() {
    return idContas;
  }

  public void setIdContas(Integer idContas) {
    this.idContas = idContas;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((idContas == null) ? 0 : idContas.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Contas other = (Contas) obj;
    if (idContas == null) {
      if (other.idContas != null)
        return false;
    } else if (!idContas.equals(other.idContas))
      return false;
    return true;
  }



  
  
}
