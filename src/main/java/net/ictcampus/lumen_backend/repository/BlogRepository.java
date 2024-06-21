package net.ictcampus.lumen_backend.repository;

import net.ictcampus.lumen_backend.entities.Blog;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepository extends CrudRepository<Blog, Integer> {
}
