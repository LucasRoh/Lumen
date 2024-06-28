package net.ictcampus.lumen_backend.repository;

import net.ictcampus.lumen_backend.entities.Post;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends CrudRepository<Post, Integer>{
    @Query("SELECT SUM(p.likes) FROM Post p WHERE p.account.id_account = ?1")
    Integer findByUserId(Integer userId);
}
