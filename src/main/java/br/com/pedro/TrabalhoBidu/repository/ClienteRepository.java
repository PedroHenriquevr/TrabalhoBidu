package br.com.pedro.TrabalhoBidu.repository;

import br.com.pedro.TrabalhoBidu.models.Cliente;
import br.com.pedro.TrabalhoBidu.repository.cliente.ClienteRepositoryQuery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long>, ClienteRepositoryQuery {
}
