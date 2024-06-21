package models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.springframework.data.annotation.ReadOnlyProperty;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "post")
public class Post {

    @Id
    @ReadOnlyProperty
    @Column(name = "ID_Post")
    private String id_post;

    @NotBlank
    @NotNull
    private String answer;

    @ManyToOne
    @JoinColumn(name = "ID_Blog")
    private Blog blog;

    @ManyToOne
    @JoinColumn(name = "ID_Account")
    private Account account;


    @OneToMany(mappedBy = "post")
    @JsonBackReference(value = "commentsReference")
    private Set<Comment> comments = new HashSet<>();


    public String getId_post() {
        return id_post;
    }

    public void setId_post(String id_post) {
        this.id_post = id_post;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Blog getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }
}
