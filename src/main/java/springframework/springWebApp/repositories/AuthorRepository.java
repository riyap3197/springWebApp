package springframework.springWebApp.repositories;

import org.springframework.data.repository.CrudRepository;
import springframework.springWebApp.domain.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
