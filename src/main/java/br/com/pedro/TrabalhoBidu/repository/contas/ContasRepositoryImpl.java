package br.com.pedro.TrabalhoBidu.repository.contas;

import br.com.pedro.TrabalhoBidu.models.Contas;
import br.com.pedro.TrabalhoBidu.repository.filter.ContasFilter;
import br.com.pedro.TrabalhoBidu.repository.projections.ContasDTO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class ContasRepositoryImpl implements ContasRepositoryQuery {
    
    @PersistenceContext
    private EntityManager manager;
    
    @Override
    public Page<ContasDTO> filtrar(ContasFilter contasFilter, Pageable pageable) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<ContasDTO> criteria = builder.createQuery(ContasDTO.class);
        Root<Contas> root = criteria.from(Contas.class);

        criteria.select(builder.construct(ContasDTO.class, root.get("idContas"), root.get("cliente").get("nomeCliente"), root.get("dateConta"), root.get("valorConta") ));

        Predicate[] predicates = criarRestricoes(contasFilter, builder , root);
        criteria.where(predicates);
        criteria.orderBy(builder.asc(root.get("cliente").get("nomeCliente")));

        TypedQuery<ContasDTO> query = manager.createQuery(criteria);

        adicionarRestricoesDePagina(query, pageable);

        return new PageImpl<>(query.getResultList(), pageable, total(contasFilter));
    }

    private Long total(ContasFilter contasFilter) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
        Root<Contas> root = criteria.from(Contas.class);

        Predicate[] predicates = criarRestricoes(contasFilter, builder , root);
        criteria.where(predicates);
        criteria.orderBy(builder.asc(root.get("cliente").get("nomeCliente")));

        criteria.select(builder.count(root));

        return manager.createQuery(criteria).getSingleResult();
    }

    private void adicionarRestricoesDePagina(TypedQuery<?> query, Pageable pageable) {
        int paginaAtual = pageable.getPageNumber();
        int totalDeRegistrosPorPagina = pageable.getPageSize();
        int primeiroRegistro = paginaAtual * totalDeRegistrosPorPagina;

        query.setFirstResult(primeiroRegistro);
        query.setMaxResults(totalDeRegistrosPorPagina);
    }

    private Predicate[] criarRestricoes(ContasFilter contasFilter, CriteriaBuilder builder, Root<Contas> root) {
        List<Predicate> predicates = new ArrayList<>();

        if(!StringUtils.isEmpty(contasFilter.getNomeCliente())){
            predicates.add(builder.like(builder.lower(root.get("cliente").get("nomeCliente")),
                    "%" + contasFilter.getNomeCliente().toLowerCase() + "%"));
        }
        if (contasFilter.getDateConta() != null) {
            predicates.add(builder.greaterThanOrEqualTo(root.get("dateConta"), contasFilter.getDateConta())
            );
        }

        if (contasFilter.getDateConta() != null) {
            predicates.add(builder.lessThanOrEqualTo(root.get("dateConta"), contasFilter.getDateConta())
            );
        }

        return predicates.toArray(new Predicate[predicates.size()]);

    }
}
