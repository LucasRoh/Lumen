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
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User user;


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
}
