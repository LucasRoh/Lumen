package net.ictcampus.lumen_backend.repository;

import net.ictcampus.lumen_backend.entities.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends CrudRepository<Post, Integer>{
}
