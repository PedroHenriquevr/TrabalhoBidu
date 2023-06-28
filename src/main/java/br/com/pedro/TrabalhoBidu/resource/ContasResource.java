package br.com.pedro.TrabalhoBidu.resource;

import br.com.pedro.TrabalhoBidu.models.Cliente;
import br.com.pedro.TrabalhoBidu.models.Contas;
import br.com.pedro.TrabalhoBidu.repository.ContasRepository;
import br.com.pedro.TrabalhoBidu.repository.filter.ContasFilter;
import br.com.pedro.TrabalhoBidu.repository.projections.ContasDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/contas")
public class ContasResource {

    @Autowired
    private ContasRepository contasRepository;

    @GetMapping()
    public Page<ContasDTO> pesquisar(ContasFilter contasFilter, Pageable pageable) {
        return contasRepository.filtrar(contasFilter, pageable);
    }

    @GetMapping("/todos")
    public List<Contas> listarTodos() {
        return contasRepository.findAll();
    }

    @PostMapping("/criar")
    public ResponseEntity<Contas> criar(@RequestBody Contas contas, HttpServletResponse response) {
        Contas contasSalvas = contasRepository.save(contas);
        return ResponseEntity.status(HttpStatus.CREATED).body(contasSalvas);
    }
}
