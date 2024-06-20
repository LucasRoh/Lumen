package controller.repositories;

import models.Blog;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface BlogRepository extends CrudRepository<Blog, String> {
}
