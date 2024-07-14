package com.curso.alura.forohub.services;

import com.curso.alura.forohub.models.Topic;
import com.curso.alura.forohub.repositories.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Soriano
 */
@Service
public class TopicService {
    @Autowired
    private TopicRepository topicRepository;

    public List<Topic> getAllTopics(){
        return this.topicRepository.findAll();
    }

    public Topic getTopicById(long idTopic){
        return this.topicRepository.findById(idTopic).orElse(null);
    }

    public Topic saveTopic(Topic topic){
        return this.topicRepository.save(topic);
    }

    public void deleteTopicById(long idTopic){
        this.topicRepository.deleteById(idTopic);
    }
}
