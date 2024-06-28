package net.ictcampus.lumen_backend.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import org.springframework.data.annotation.ReadOnlyProperty;

import javax.naming.Name;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name="account")

public class Account {

    @Id
    @ReadOnlyProperty
    @Column(name = "id_account")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_account;

    @NotNull(message = "Name cannot be null")
    @NotBlank(message = "Name is required")
    private String name;

    @NotNull(message = "Password is cannot be null")
    @NotBlank(message = "Password is required")
    private String password;

    @OneToMany(mappedBy = "account")
    @JsonBackReference(value = "blogsReference")
    private Set<Blog> blogs = new HashSet<>();

    @Column(name = "imagepath")
    private String imagePath;

}

