package com.curso.alura.forohub.controllers;

import com.curso.alura.forohub.dtos.SaveTopicDTO;
import com.curso.alura.forohub.enums.Status;
import com.curso.alura.forohub.models.Course;
import com.curso.alura.forohub.models.Topic;
import com.curso.alura.forohub.models.User;
import com.curso.alura.forohub.services.CourseService;
import com.curso.alura.forohub.services.TopicService;
import com.curso.alura.forohub.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

/**
 * @author Soriano
 */
@RestController
@RequestMapping("/topicos")
public class TopicController {
    @Autowired
    private TopicService topicService;

    @Autowired
    private UserService userService;

    @Autowired
    private CourseService courseService;

    @GetMapping
    public List<Topic> getAllTopics(){
        return this.topicService.getAllTopics();
    }

    @GetMapping("/{idTopic}")
    public ResponseEntity<Topic> getTopicById(@PathVariable long idTopic){
        Topic topic =  this.topicService.getTopicById(idTopic);

        if(topic==null){
            return new ResponseEntity<>(new Topic(), HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(topic, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> saveTopic(@RequestBody @Valid SaveTopicDTO topicDTO){
        User user = this.userService.getUserById(topicDTO.idUser());
        Course course = this.courseService.getCourseById(topicDTO.idCourse());
        Timestamp genDate = Timestamp.from(Instant.now());

        if(user==null){
            return new ResponseEntity<>("{\"message\": \"El usuario no existe.\"}", HttpStatus.NOT_FOUND);
        }

        if(course==null){
            return new ResponseEntity<>("{\"message\": \"El curso no existe.\"}", HttpStatus.NOT_FOUND);
        }

        Topic topic = new Topic();
        topic.setIdTopic(0);
        topic.setTitle(topicDTO.title());
        topic.setMessage(topicDTO.message());
        topic.setGenerationDate(genDate);
        topic.setStatus(Status.ESTADO1);
        topic.setIdUser(user);
        topic.setIdCourse(course);

        this.topicService.saveTopic(topic);

        return new ResponseEntity<>("{\"message\": \"Datos guardados correctamente\"}", HttpStatus.OK);
    }

}
