package net.ictcampus.lumen_backend.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.ReadOnlyProperty;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@Entity
@Table(name = "post")
public class Post {

    @Id
    @ReadOnlyProperty
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Post")
    private Integer id;

    @NotBlank
    @NotNull
    private String answer;

    @Min(0)
    private int likes = 0;

    @ManyToOne
    @JoinColumn(name = "ID_Blog")
    private Blog blog;

    @ManyToOne
    @JoinColumn(name = "ID_Account")
    private Account account;

    @OneToMany(mappedBy = "post")
    @JsonBackReference(value = "commentsReference")
    private Set<Comment> comments = new HashSet<>();

}

