package net.ictcampus.lumen_backend.repository;

import net.ictcampus.lumen_backend.entities.Tags;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface TagRepository extends CrudRepository<Tags, Integer>{

}
