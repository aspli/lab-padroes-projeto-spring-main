package one.digitalinnovation.gof.repository;

import one.digitalinnovation.gof.model.Livraria;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivrariaRepository extends CrudRepository<Livraria, Long> {
}
