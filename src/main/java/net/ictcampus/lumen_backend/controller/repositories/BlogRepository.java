package net.ictcampus.lumen_backend.controller.repositories;

import net.ictcampus.lumen_backend.models.Blog;
import org.springframework.data.repository.CrudRepository;

public interface BlogRepository extends CrudRepository<Blog, String> {
}
