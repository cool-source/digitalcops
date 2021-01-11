package digitalcops.com.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import digitalcops.com.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	public User findById(long id);

	public User findByUserName(String userName);

}