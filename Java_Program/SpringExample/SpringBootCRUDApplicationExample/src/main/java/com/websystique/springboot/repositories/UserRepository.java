package com.websystique.springboot.repositories;

import com.websystique.springboot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.HashSet;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByName(String name);

}
