package net.ictcampus.lumen_backend.controller.repositories;

import net.ictcampus.lumen_backend.models.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post, String>{
}
