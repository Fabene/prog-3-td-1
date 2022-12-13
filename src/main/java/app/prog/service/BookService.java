package app.prog.service;

import app.prog.model.BookEntity;
import app.prog.repository.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BookService {
    private final BookRepository repository;

    public List<BookEntity> getBooks() {
        return repository.findAll();
    }

    public List<BookEntity> createBooks(List<BookEntity> toCreate) {
        return repository.saveAll(toCreate);
    }

    public List<BookEntity> updateBooks(List<BookEntity> toUpdate) {
        return repository.saveAll(toUpdate);
    }

    //TODO-3: should I  use Integer here or int ? Why ?
    public BookEntity deleteBook(int id) {

        Optional<BookEntity> optional = repository.findById(Integer.valueOf(String.valueOf(id)));
        if (optional.isPresent()) {
            repository.delete(optional.get());
            return optional.get();
        } else {

            throw new RuntimeException("BookEntity." + id + " not found");
        }
    }
}
