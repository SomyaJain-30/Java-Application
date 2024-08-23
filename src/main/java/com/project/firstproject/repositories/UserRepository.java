package com.project.firstproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.project.firstproject.entities.User;

@Repository
@Component
public interface UserRepository extends JpaRepository<User, Integer> {


}
