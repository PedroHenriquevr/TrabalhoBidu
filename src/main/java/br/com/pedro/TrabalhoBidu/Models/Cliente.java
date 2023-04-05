package br.com.pedro.TrabalhoBidu.Models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Cliente")
public class Cliente {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)

  private Integer idCliente;
  private String nomeCliente;

  @OneToMany(mappedBy = "cliente")
  private List<Contas> Contas = new ArrayList<>();
  
  
  public String getNomeCliente() {
    return nomeCliente;
  }
  public void setNomeCliente(String nomeCliente) {
    this.nomeCliente = nomeCliente;
  }
  public Integer getIdCliente() {
    return idCliente;
  }
  public void setIdCliente(Integer idCliente) {
    this.idCliente = idCliente;
  }
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((idCliente == null) ? 0 : idCliente.hashCode());
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
    Cliente other = (Cliente) obj;
    if (idCliente == null) {
      if (other.idCliente != null)
        return false;
    } else if (!idCliente.equals(other.idCliente))
      return false;
    return true;
  }

  

  
}
