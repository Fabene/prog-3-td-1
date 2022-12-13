package app.prog.repository;

import app.prog.model.AuthorsEntity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<AuthorsEntity, String> {
}
