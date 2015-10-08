package apispec;

import org.springframework.data.repository.Repository;

public interface ApiSpecRepository extends Repository<ApiSpec, Long> {
	public ApiSpec save(ApiSpec apispec);
}
