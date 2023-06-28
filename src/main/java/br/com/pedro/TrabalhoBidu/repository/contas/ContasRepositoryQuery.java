package br.com.pedro.TrabalhoBidu.repository.contas;

import br.com.pedro.TrabalhoBidu.repository.filter.ContasFilter;
import br.com.pedro.TrabalhoBidu.repository.projections.ContasDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ContasRepositoryQuery {

    public Page<ContasDTO> filtrar(ContasFilter contasFilter, Pageable pageable);
}
