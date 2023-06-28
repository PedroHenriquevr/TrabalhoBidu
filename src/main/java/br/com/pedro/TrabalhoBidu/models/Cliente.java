package br.com.pedro.TrabalhoBidu.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.*;

@Entity
@Table(name = "Cliente")
public class Cliente {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long idCliente;
  private String nomeCliente;

  @OneToMany(mappedBy = "cliente")
  private List<Contas> Contas = new ArrayList<>();
  
  
  public String getNomeCliente() {
    return nomeCliente;
  }
  public void setNomeCliente(String nomeCliente) {
    this.nomeCliente = nomeCliente;
  }


  public Long getIdCliente() {
    return idCliente;
  }

  public void setIdCliente(Long idCliente) {
    this.idCliente = idCliente;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Cliente cliente = (Cliente) o;
    return Objects.equals(idCliente, cliente.idCliente);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idCliente);
  }

}
