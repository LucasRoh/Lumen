package net.ictcampus.lumen_backend.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.ReadOnlyProperty;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "post")
public class Post {

    @Setter
    @Getter
    @Id
    @ReadOnlyProperty
    @Column(name = "ID_Post")
    private String id_post;

    @Setter
    @Getter
    @NotBlank
    @NotNull
    private String answer;

    @Setter
    @Getter
    @ManyToOne
    @JoinColumn(name = "ID_Blog")
    private Blog blog;

    @Setter
    @Getter
    @ManyToOne
    @JoinColumn(name = "ID_Account")
    private Account account;


    @Setter
    @Getter
    @OneToMany(mappedBy = "post")
    @JsonBackReference(value = "commentsReference")
    private Set<Comment> comments = new HashSet<>();


}
