package digitalcops.com.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import digitalcops.com.entities.Criminal;

@Repository
public interface CriminalRepository extends JpaRepository<Criminal, Long>{

	public Criminal findById(Long id);

	

}
