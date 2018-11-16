package pl.sokolx.spring5webapp.bootstrap;

import pl.sokolx.spring5webapp.model.Author;
import pl.sokolx.spring5webapp.model.Book;
import pl.sokolx.spring5webapp.model.Publisher;
import pl.sokolx.spring5webapp.repositories.AuthorRespository;
import pl.sokolx.spring5webapp.repositories.BookRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import pl.sokolx.spring5webapp.repositories.PublisherRepository;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRespository authorRespository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRespository authorRespository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRespository = authorRespository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {

        Publisher publisher = new Publisher();
        publisher.setName("foo");

        publisherRepository.save(publisher);

        Author eric = new Author("Erick", "Evans");
        Book dddd = new Book("Domain Driven Design", "1234", publisher);
        eric.getBooks().add(dddd);
        dddd.getAuthors().add(eric);

        authorRespository.save(eric);
        bookRepository.save(dddd);

        Author patric = new Author("Erick", "Evans");
        Book noEJB = new Book("J2EE", "1234", publisher);
        patric.getBooks().add(noEJB);

        authorRespository.save(patric);
        bookRepository.save(noEJB);

    }
}
