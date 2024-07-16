package com.curso.alura.forohub.repositories;

import com.curso.alura.forohub.models.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * @author Soriano
 */
@Repository
public interface TopicRepository extends JpaRepository<Topic, Long> {
    boolean existsByTitle(String title);
    boolean existsByMessage(String message);
    boolean existsByIdTopic(long idTopic);
    List<Topic> findTop10ByOrderByGenerationDateAsc();
}
