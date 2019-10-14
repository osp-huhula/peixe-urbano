package br.com.jbrasileiro.peixeurbano.deal;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.jbrasileiro.peixeurbano.deal.to.DealReadAllTO;

@Repository
public interface DealRepository
	extends
	JpaRepository<Deal, Long> {

	@Query("SELECT new br.com.jbrasileiro.peixeurbano.deal.to.DealReadAllTO( deal.id, deal.title) FROM Deal deal ORDER BY deal.id")
	Collection<DealReadAllTO> readAll();
}
