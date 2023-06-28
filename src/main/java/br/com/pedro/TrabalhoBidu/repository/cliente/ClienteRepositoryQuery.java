package br.com.pedro.TrabalhoBidu.repository.cliente;

import br.com.pedro.TrabalhoBidu.models.Cliente;
import br.com.pedro.TrabalhoBidu.repository.filter.ClienteFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ClienteRepositoryQuery {

    public Page<Cliente> filtrar(ClienteFilter clienteFilter, Pageable pageable);
}
