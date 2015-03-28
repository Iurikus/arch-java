package com.yuri.archjava.repository;

import com.yuri.archjava.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by yuri on 19.03.2015.
 */
public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findByEmail(String email);


}
