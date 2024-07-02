package net.ictcampus.lumen_backend.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.ReadOnlyProperty;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name="Tags")

public class Tags {
    @Id
    @ReadOnlyProperty
    @Column(name = "id_tag")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_tag;

    @NotNull(message = "Title cannot be null")
    @NotBlank(message = "Title is required")
    private String title;
}
