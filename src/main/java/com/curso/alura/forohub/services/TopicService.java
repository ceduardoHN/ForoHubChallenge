package com.curso.alura.forohub.services;

import com.curso.alura.forohub.models.Topic;
import com.curso.alura.forohub.repositories.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    public Page<Topic> getAllTopics(Pageable pagination){
        return this.topicRepository.findAll(pagination);
    }

    public Topic getTopicById(long idTopic){
        return this.topicRepository.findById(idTopic).orElse(null);
    }

    public boolean verifyTopicByTitle(String title){
        return this.topicRepository.existsByTitle(title);
    }

    public boolean verifyTopicByMessage(String message){
        return this.topicRepository.existsByMessage(message);
    }

    public boolean verifyTopicById(long idTopic){
        return this.topicRepository.existsByIdTopic(idTopic);
    }

    public List<Topic> getTop10TopicsByGenerationDate(){
        return this.topicRepository.findTop10ByOrderByGenerationDateAsc();
    }

    public Topic saveTopic(Topic topic){
        return this.topicRepository.save(topic);
    }

    public void deleteTopicById(long idTopic){
        this.topicRepository.deleteById(idTopic);
    }
}
