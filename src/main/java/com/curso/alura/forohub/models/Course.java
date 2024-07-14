package com.curso.alura.forohub.models;

import com.curso.alura.forohub.enums.Category;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author Soriano
 */
@Entity
@Table(name = "tblcourse")
public class Course implements Serializable {
    public Course() {
    }

    /**
     * @param idCourse
     * @param courseName
     * @param category
     */
    public Course(long idCourse, String courseName, Category category) {
        this.idCourse = idCourse;
        this.courseName = courseName;
        this.category = category;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcourse")
    private long idCourse;

    @Column(name = "coursename")
    private String courseName;

    @Enumerated(EnumType.STRING)
    private Category category;

    @OneToMany(mappedBy = "idCourse", fetch = FetchType.LAZY)
    @JsonIgnoreProperties("idCourse")
    private List<Topic> topics;

    public long getIdCourse() {
        return idCourse;
    }

    public void setIdCourse(long idCourse) {
        this.idCourse = idCourse;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
