package com.curso.alura.forohub.services;

import com.curso.alura.forohub.models.Course;
import com.curso.alura.forohub.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * @author Soriano
 */
@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    public List<Course> getAllCourses(){
        return this.courseRepository.findAll();
    }

    public Course getCourseById(long idCourse) {
        return this.courseRepository.findById(idCourse).orElse(null);
    }
}
