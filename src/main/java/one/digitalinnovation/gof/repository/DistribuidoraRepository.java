package one.digitalinnovation.gof.repository;

import one.digitalinnovation.gof.model.Distribuidora;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DistribuidoraRepository extends CrudRepository<Distribuidora, Long> {
}
