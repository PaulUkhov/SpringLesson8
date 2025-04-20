package org.example.soringlesson8homework.repository.task2;

import org.example.soringlesson8homework.model.task2.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByUserName(String userName);
}
