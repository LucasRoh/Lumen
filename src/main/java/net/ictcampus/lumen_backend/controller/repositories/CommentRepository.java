package net.ictcampus.lumen_backend.controller.repositories;

import net.ictcampus.lumen_backend.models.Comment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
    public interface CommentRepository extends CrudRepository<Comment, Integer>{
}
