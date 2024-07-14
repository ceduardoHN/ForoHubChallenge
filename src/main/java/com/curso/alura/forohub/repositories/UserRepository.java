package com.curso.alura.forohub.repositories;

import com.curso.alura.forohub.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Soriano
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
