package apispec;

import org.springframework.data.repository.Repository;

public interface UserRepository extends Repository<User, Long> {
	public User save(User user);
}
