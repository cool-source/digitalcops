package digitalcops.com.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import digitalcops.com.entities.Complaint;

@Repository
public interface ComplaintRepository extends JpaRepository<Complaint, Long> {

	public Complaint findById(long id);

	public Complaint findByCity(String city);
}
