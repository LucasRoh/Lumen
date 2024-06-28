package net.ictcampus.lumen_backend.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.ReadOnlyProperty;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

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

    @Column(name = "timestamp", updatable = false, insertable = false)
    private LocalDateTime erstellungsdatum;

}
