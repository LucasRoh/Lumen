package net.ictcampus.lumen_backend.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.ReadOnlyProperty;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "comment")
public class Comment {

    @Setter
    @Getter
    @Id
    @ReadOnlyProperty
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Comment")
    private Integer id;

    @Setter
    @Getter
    @NotNull
    @NotBlank
    private String comment;

    @Setter
    @Getter
    @ManyToOne
    @JoinColumn(name = "ID_Post")
    private Post post;

    @Setter
    @Getter
    @ManyToOne
    @JoinColumn(name = "ID_Account")
    private Account account;

}
