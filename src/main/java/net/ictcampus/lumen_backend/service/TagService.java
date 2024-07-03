package net.ictcampus.lumen_backend.service;

import lombok.RequiredArgsConstructor;
import net.ictcampus.lumen_backend.entities.Post;
import net.ictcampus.lumen_backend.entities.Tags;
import net.ictcampus.lumen_backend.repository.TagRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.swing.text.html.HTML;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class TagService {
    private final TagRepository tagRepository;

    public Iterable<Tags> findAll() {
        return tagRepository.findAll();
    }



    public Tags findById(Integer id) {
        Optional<Tags> subject = tagRepository.findById(id);
        return subject.orElseThrow(EntityNotFoundException::new);
    }

    public void create(Tags tags) {
        tagRepository.save(tags);
    }
    public Tags findByTitle(String title) {
        return tagRepository.findByTitle(title).orElse(null);
    }

    public void deleteById(Integer id) {
        tagRepository.deleteById(id);
    }
}
