package net.ictcampus.lumen_backend.models;

import lombok.Data;
import org.springframework.data.annotation.ReadOnlyProperty;

import javax.naming.Name;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="account")
@Data
public class Account {

    @Id
    @ReadOnlyProperty
    @Column(name = "id_account")
    private int id_account;

    @NotNull(message = "Name cannot be null")
    @NotBlank(message = "Name is required")
    private String name;

    @NotNull(message = "Password is cannot be null")
    @NotBlank(message = "Password is required")
    private String password;


    // -------------------- GET & SET --------------------------------


    public int getId_account() {
        return id_account;
    }

    public void setId_account(int id_account) {
        this.id_account = id_account;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

