package com.curso.alura.forohub.controllers;

import com.curso.alura.forohub.models.Course;
import com.curso.alura.forohub.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
 * @author Soriano
 */
@RestController
@RequestMapping("/cursos")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @GetMapping
    public List<Course> getAllCourses(){
        return this.courseService.getAllCourses();
    }
}
