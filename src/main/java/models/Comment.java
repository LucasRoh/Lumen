package models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.w3c.dom.Text;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="Comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_comment;

    @NotNull
    @NotBlank
private String comment;
@ManyToOne
@JoinColumn(name = "post_id")
@JsonBackReference
private Post post;

    @ManyToOne
    @JoinColumn(name = "ID_Account")
    @JsonBackReference
    private Account account;


    public Integer getId_comment() {
        return id_comment;
    }

    public void setId_comment(Integer id_comment) {
        this.id_comment = id_comment;
    }

    public String getName() {
        return comment;
    }

    public void setName(String name) {
        this.comment = comment;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
