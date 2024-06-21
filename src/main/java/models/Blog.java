package models;

import com.fasterxml.jackson.annotation.JsonBackReference;

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

    @Id
    @ReadOnlyProperty
    @Column(name = "ID_Blog")
    private String id;

    @NotBlank(message = "title can't be blank")
    @NotNull(message = "title is required")
    @Length(max = 100)
    private String title;

    @NotBlank(message = "question can't be blank")
    @NotNull(message = "question is required")
    private String question;


    @ManyToOne
    @JoinColumn(name = "ID_Benutzer")
    private User user;


    @OneToMany(mappedBy = "blog")
    @JsonBackReference(value="postsReference")
    private Set<Post> posts = new HashSet<>();


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Set<Post> getPosts() {
        return posts;
    }

    public void setPosts(Set<Post> posts) {
        this.posts = posts;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
