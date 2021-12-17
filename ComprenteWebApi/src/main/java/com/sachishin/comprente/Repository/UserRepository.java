package com.sachishin.comprente.Repository;

import com.sachishin.comprente.Repository.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByName(String name);
    User existsByEmail(String email);
}