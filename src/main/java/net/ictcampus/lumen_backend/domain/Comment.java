package net.ictcampus.lumen_backend.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.ReadOnlyProperty;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Setter
@Getter
@Entity
@Table(name = "comment")
public class Comment {

    @Id
    @ReadOnlyProperty
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Comment")
    private Integer id;

    @NotNull
    @NotBlank
    private String comment;

    @ManyToOne
    @JoinColumn(name = "ID_Post")
    private Post post;

    @ManyToOne
    @JoinColumn(name = "ID_Account")
    private Account account;

}
