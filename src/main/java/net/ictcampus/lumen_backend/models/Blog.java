package net.ictcampus.lumen_backend.models;

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

@Entity
@Table(name = "blog")
public class Blog {

    @Setter
    @Getter
    @Id
    @ReadOnlyProperty
    @Column(name = "ID_Blog")
    private String id;

    @Setter
    @Getter
    @NotBlank(message = "title can't be blank")
    @NotNull(message = "title is required")
    @Length(max = 100)
    private String title;

    @Setter
    @Getter
    @NotBlank(message = "question can't be blank")
    @NotNull(message = "question is required")
    private String question;


    @Setter
    @Getter
    @ManyToOne
    @JoinColumn(name = "ID_Account")
    private Account accout;


    @OneToMany(mappedBy = "blog")
    @JsonBackReference(value="postsReference")
    private Set<Post> posts = new HashSet<>();


}
