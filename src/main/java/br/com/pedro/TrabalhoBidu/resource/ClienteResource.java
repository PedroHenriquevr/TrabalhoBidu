package br.com.pedro.TrabalhoBidu.resource;

import br.com.pedro.TrabalhoBidu.models.Cliente;
import br.com.pedro.TrabalhoBidu.repository.ClienteRepository;
import br.com.pedro.TrabalhoBidu.repository.filter.ClienteFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteResource {

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping()
    public Page<Cliente> pesquisar(ClienteFilter clienteFilter, Pageable pageable){
        return clienteRepository.filtrar(clienteFilter, pageable);
    }

    @GetMapping("/todos")
    public List<Cliente> listarTodos() {
        return clienteRepository.findAll();
    }

    @PostMapping("/criar")
    public ResponseEntity<Cliente> criar(@RequestBody Cliente cliente, HttpServletResponse response) {
        Cliente clienteSalvo = clienteRepository.save(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteSalvo);
    }

}
