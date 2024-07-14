package com.curso.alura.forohub.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author Soriano
 */
@Entity
@Table(name = "tbluser")
public class User implements Serializable {
    public User() {
    }

    /**
     * @param idUser
     * @param userName
     * @param email
     * @param password
     */
    public User(long idUser, String userName, String email, String password) {
        this.idUser = idUser;
        this.userName = userName;
        this.email = email;
        this.password = password;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "iduser")
    private long idUser;

    @Column(name = "username")
    private String userName;

    private String email;

    private String password;

    @OneToMany(mappedBy = "idUser", fetch = FetchType.LAZY)
    @JsonIgnoreProperties("idUser")
    private List<Topic> topics;

    public long getIdUser() {
        return idUser;
    }

    public void setIdUser(long idUser) {
        this.idUser = idUser;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
