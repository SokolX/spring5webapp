package pl.sokolx.spring5webapp.repositories;

import pl.sokolx.spring5webapp.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRespository extends CrudRepository<Author, Long> {
}