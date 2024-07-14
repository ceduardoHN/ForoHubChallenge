package com.curso.alura.forohub.models;

import com.curso.alura.forohub.enums.Status;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import jakarta.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author Soriano
 */
@Entity
@Table(name="tbltopic")
public class Topic implements Serializable {
    public Topic() {
    }

    /**
     * @param idTopic
     * @param title
     * @param message
     * @param generationDate
     * @param status
     * @param idUser
     * @param idCourse
     */
    public Topic(long idTopic, String title, String message, Timestamp generationDate,
                 Status status, User idUser, Course idCourse) {
        this.idTopic = idTopic;
        this.title = title;
        this.message = message;
        this.generationDate = generationDate;
        this.status = status;
        this.idUser = idUser;
        this.idCourse = idCourse;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idtopic")
    private long idTopic;

    private String title;
    private String message;

    @Column(name="generationdate")
    private Timestamp generationDate;

    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne
    @JoinColumn(name="iduser", referencedColumnName="iduser")
    @JsonIncludeProperties({"idUser", "userName", "email"})
    private User idUser;

    @ManyToOne
    @JoinColumn(name = "idcourse", referencedColumnName = "idcourse")
    @JsonIncludeProperties({"idCourse", "courseName", "category"})
    private Course idCourse;

    public long getIdTopic() {
        return idTopic;
    }

    public void setIdTopic(long idTopic) {
        this.idTopic = idTopic;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Timestamp getGenerationDate() {
        return generationDate;
    }

    public void setGenerationDate(Timestamp generationDate) {
        this.generationDate = generationDate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public User getIdUser() {
        return idUser;
    }

    public void setIdUser(User idUser) {
        this.idUser = idUser;
    }

    public Course getIdCourse() {
        return idCourse;
    }

    public void setIdCourse(Course idCourse) {
        this.idCourse = idCourse;
    }
}
