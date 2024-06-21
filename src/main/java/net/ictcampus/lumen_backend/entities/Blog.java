package net.ictcampus.lumen_backend.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.ReadOnlyProperty;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "blog")
public class Blog {


    @Id
    @ReadOnlyProperty
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Blog")
    private Integer id;


    @NotBlank(message = "title can't be blank")
    @NotNull(message = "title is required")
    @Length(max = 100)
    private String title;

    @NotBlank(message = "question can't be blank")
    @NotNull(message = "question is required")
    private String question;


    @ManyToOne
    @JoinColumn(name = "ID_Account")
    private Account account;


    @OneToMany(mappedBy = "blog")
    @JsonBackReference(value="postsReference")
    private Set<Post> posts = new HashSet<>();

}
