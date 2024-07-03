package net.ictcampus.lumen_backend.repository;

import net.ictcampus.lumen_backend.entities.Tags;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface TagRepository extends JpaRepository<Tags, Integer> {
    Optional<Tags> findByTitle(String title);
}
