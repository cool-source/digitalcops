package digitalcops.com.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import digitalcops.com.entities.PoliceStation;

@Repository
public interface PoliceStationRepository extends JpaRepository<PoliceStation, Long> {

	public PoliceStation findById(long id);

	public PoliceStation findByPoliceStationName(String policeStationName);
}
