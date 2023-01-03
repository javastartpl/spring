package pl.javastart.library;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class LibraryApplicationTests {
    @Autowired
    private BookRepository bookRepository;

    @Test
    void contextLoads() {
        assertNotNull(bookRepository);
    }

    @Test
    void shouldGenerateId() {
        Book book1 = new Book("W pustyni i w puszczy", "Henryk Sienkiewicz", "Greg", 2002, 312);
        Book savedBook = bookRepository.save(book1);
        assertNotNull(savedBook.getId());
    }

}
