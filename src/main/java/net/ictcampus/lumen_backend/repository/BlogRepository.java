package net.ictcampus.lumen_backend.repository;

import net.ictcampus.lumen_backend.entities.Blog;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogRepository extends CrudRepository<Blog, Integer> {
    List<Blog> findByTag_Title(String tagTitle);
}
