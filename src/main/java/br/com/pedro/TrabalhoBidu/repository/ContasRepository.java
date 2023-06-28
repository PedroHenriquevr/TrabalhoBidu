package br.com.pedro.TrabalhoBidu.repository;

import br.com.pedro.TrabalhoBidu.models.Contas;
import br.com.pedro.TrabalhoBidu.repository.contas.ContasRepositoryQuery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContasRepository extends JpaRepository<Contas, Long>, ContasRepositoryQuery {
}
