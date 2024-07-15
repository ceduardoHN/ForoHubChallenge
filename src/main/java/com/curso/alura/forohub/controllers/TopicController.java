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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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

    @GetMapping("/paginated")
    public Page<Topic> getAllTopics(@PageableDefault(size = 15) Pageable pagination){
        return this.topicService.getAllTopics(pagination);
    }

    @GetMapping("/{idTopic}")
    public ResponseEntity<Topic> getTopicById(@PathVariable long idTopic){
        Topic topic =  this.topicService.getTopicById(idTopic);

        if(topic==null){
            return new ResponseEntity<>(new Topic(), HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(topic, HttpStatus.OK);
    }

    @GetMapping("/top10")
    public List<Topic> getTop10TopicsByGenDate(){
        return this.topicService.getTop10TopicsByGenerationDate();
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

        if(
            this.topicService.verifyTopicByTitle(topicDTO.title()) ||
            this.topicService.verifyTopicByMessage(topicDTO.message())
        )
        {
            return new ResponseEntity<>(
                    "{\"message\": \"No se permiten tópicos duplicados.\n\"}",
                    HttpStatus.BAD_REQUEST);
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

        return new ResponseEntity<>("{\"message\": \"Datos guardados correctamente.\"}", HttpStatus.OK);
    }

    @PutMapping("/{idTopic}")
    public ResponseEntity<String> updateTopic(
            @RequestBody @Valid SaveTopicDTO topicDTO,
            @PathVariable long idTopic
    ){
        if(this.topicService.verifyTopicById(idTopic)){
            User user = this.userService.getUserById(topicDTO.idUser());
            Course course = this.courseService.getCourseById(topicDTO.idCourse());
            Timestamp modificationDate = Timestamp.from(Instant.now());

            if(user==null){
                return new ResponseEntity<>("{\"message\": \"El usuario no existe.\"}", HttpStatus.NOT_FOUND);
            }

            if(course==null){
                return new ResponseEntity<>("{\"message\": \"El curso no existe.\"}", HttpStatus.NOT_FOUND);
            }

            if(
                this.topicService.verifyTopicByTitle(topicDTO.title()) ||
                this.topicService.verifyTopicByMessage(topicDTO.message())
            )
            {
                return new ResponseEntity<>(
                        "{\"message\": \"No se permiten tópicos duplicados.\n\"}",
                        HttpStatus.BAD_REQUEST);
            }


            Topic topic = this.topicService.getTopicById(idTopic);
            topic.setTitle(topicDTO.title());
            topic.setMessage(topicDTO.message());
            topic.setGenerationDate(modificationDate);
            topic.setIdUser(user);
            topic.setIdCourse(course);

            this.topicService.saveTopic(topic);

            return new ResponseEntity<>("{\"message\": \"Datos modificados correctamente.\"}", HttpStatus.OK);
        }

        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{idTopic}")
    public ResponseEntity deleteTopicById(@PathVariable long idTopic){
        if(this.topicService.verifyTopicById(idTopic)){
            this.topicService.deleteTopicById(idTopic);

            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

}
