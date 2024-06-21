package net.ictcampus.lumen_backend.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "comment")
public class Comment {

    @Setter
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_comment;

    @Setter
    @Getter
    @NotNull
    @NotBlank
    private String comment;

    @Setter
    @Getter
    @ManyToOne
    @JoinColumn(name = "post_id")
    @JsonBackReference
    private Post post;

    @Setter
    @Getter
    @ManyToOne
    @JoinColumn(name = "ID_Account")
    @JsonBackReference
    private Account account;

}
