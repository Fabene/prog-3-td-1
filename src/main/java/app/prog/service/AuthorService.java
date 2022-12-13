package app.prog.service;

import app.prog.model.AuthorsEntity;
import app.prog.model.BookEntity;
import app.prog.repository.AuthorRepository;
import app.prog.repository.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AuthorService {
    private final AuthorRepository repository;

    public List<AuthorsEntity> getauthor() {
        return repository.findAll();
    }

    public List<AuthorsEntity> createAuthor(List<AuthorsEntity> toCreate) {
        return repository.saveAll(toCreate);
    }

    public List<AuthorsEntity> updateAuthor(List<AuthorsEntity> toUpdate) {
        return repository.saveAll(toUpdate);
    }

    public AuthorsEntity getByName(String name){
        return repository.findAuthorsEntityByName(name);
    }
    public AuthorsEntity deleteAuthor(int id) {

        Optional<AuthorsEntity> optional = repository.findById(String.valueOf(id));
        if (optional.isPresent()) {
            repository.delete(optional.get());
            return optional.get();
        } else {

            throw new RuntimeException("AuthorsEntity." + id + " not found");
        }
    }
}
