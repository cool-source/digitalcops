package digitalcops.com.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import digitalcops.com.entities.Witness;

@Repository
public interface WitnessRepository extends JpaRepository<Witness, Long>{

	public Witness findById(Long id);

}
