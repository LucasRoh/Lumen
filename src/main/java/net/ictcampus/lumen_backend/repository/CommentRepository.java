package net.ictcampus.lumen_backend.repository;

import net.ictcampus.lumen_backend.entities.Comment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends CrudRepository<Comment, Integer> {
}
