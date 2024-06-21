package net.ictcampus.lumen_backend.service;

import net.ictcampus.lumen_backend.repository.CommentRepository;
import net.ictcampus.lumen_backend.domain.Comment;
import org.springframework.stereotype.Service;

@Service
public class CommentService {
    private final CommentRepository commentRepository;


    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }
    public Iterable<Comment> findAll(){
        return commentRepository.findAll();
    }

    public void insertAbility(Comment comment){
        commentRepository.save(comment);

    }
    public void updateAbility(Comment comment){
        commentRepository.save(comment);

    }
    public void deleteById(Integer id){
        commentRepository.deleteById(id);
    }
}


