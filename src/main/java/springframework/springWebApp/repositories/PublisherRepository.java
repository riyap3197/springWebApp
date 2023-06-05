package springframework.springWebApp.repositories;

import org.springframework.data.repository.CrudRepository;
import springframework.springWebApp.domain.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {

}
