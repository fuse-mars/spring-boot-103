// repository for data storage
package apispec;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "apispec", path = "apispec")
public interface ApiSpecRepository extends PagingAndSortingRepository<ApiSpec, Long> {

	List<ApiSpec> findByApi(@Param("api") String api);

}
