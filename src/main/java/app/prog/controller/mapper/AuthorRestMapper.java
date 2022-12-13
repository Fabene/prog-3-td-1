package app.prog.controller.mapper;

import app.prog.controller.response.*;
import app.prog.model.AuthorsEntity;
import app.prog.model.BookEntity;
import org.springframework.stereotype.Component;

@Component
public class AuthorRestMapper {
    public AuthorsResponse toRest(AuthorsEntity domain) {
        return AuthorsResponse.builder()
                .id(domain.getId())
                .name(domain.getName())
                .particularity(domain.getParticularity())
                .hasParticularity(domain.hasParticularity())
                .build();
    }

    public AuthorsEntity toDomain(CreateAuthorsResponse rest) {
        return AuthorsEntity.builder()
                .name(rest.getName())
                .particularity(rest.getParticularity())
                .build();
    }

    public AuthorsEntity toDomain(UpdateAuthorsResponse rest) {
        return AuthorsEntity.builder()
                .id(rest.getId())
                .name(rest.getName())
                .particularity(rest.getParticularity())
                .build();
    }
}
