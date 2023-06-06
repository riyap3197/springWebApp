package springframework.springWebApp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import springframework.springWebApp.domain.Author;
import springframework.springWebApp.domain.Book;
import springframework.springWebApp.domain.Publisher;
import springframework.springWebApp.repositories.AuthorRepository;
import springframework.springWebApp.repositories.BookRepository;
import springframework.springWebApp.repositories.PublisherRepository;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Publisher publisher = new Publisher();
        publisher.setName("ABC Publishing");
        publisher.setCity("Toronto");
        publisher.setProvince("ON");

        publisherRepository.save(publisher);

        System.out.println("Number of Publishers: " + publisherRepository.count());

        Author steve = new Author("Steve", "Murphy");
        Book life = new Book("Hello World!","728949");
        steve.getBooks().add(life);
        life.getAuthors().add(steve);

        life.setPublisher(publisher);
        publisher.getBooks().add(life);

        authorRepository.save(steve);
        bookRepository.save(life);
        publisherRepository.save(publisher);

        Author herbert = new Author("Herbert", "Sch");
        Book java = new Book("Java: The Complete Guide","763906");
        herbert.getBooks().add(java);
        java.getAuthors().add(herbert);

        java.setPublisher(publisher);
        publisher.getBooks().add(java);

        authorRepository.save(herbert);
        bookRepository.save(java);
        publisherRepository.save(publisher);

        System.out.println("Number of Books: " + bookRepository.count());
        System.out.println("Publisher Number of Books: " + publisher.getBooks().size());
    }
}
