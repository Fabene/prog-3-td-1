package app.prog.controller;

import app.prog.controller.mapper.AuthorRestMapper;
import app.prog.controller.response.*;
import app.prog.model.AuthorsEntity;
import app.prog.model.BookEntity;
import app.prog.service.AuthorService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class AuthorController {
    private final AuthorService service;
    private final AuthorRestMapper mapper;

    @GetMapping("/authors")
    public List<AuthorsResponse> getBooks() {
        return service.getauthor().stream()
                .map(mapper::toRest)
                .toList();
    }

    @PostMapping("/authors")
    public List<AuthorsResponse> createAuthor(@RequestBody List<CreateAuthorsResponse> toCreate) {
        List<AuthorsEntity> domain = toCreate.stream()
                .map(mapper::toDomain)
                .toList();
        return service.createAuthor(domain).stream()
                .map(mapper::toRest)
                .toList();
    }

    @PutMapping("/authors")
    public List<AuthorsResponse> updateBooks(@RequestBody List<UpdateAuthorsResponse> toUpdate) {
        List<AuthorsEntity> domain = toUpdate.stream()
                .map(mapper::toDomain)
                .toList();
        return service.updateAuthor(domain).stream()
                .map(mapper::toRest)
                .toList();
    }

    @DeleteMapping("/authors/{authorId}")
    public AuthorsResponse deleteAuthor(@PathVariable Integer autorId) {
        return mapper.toRest(service.deleteAuthor(autorId));
    }
}
