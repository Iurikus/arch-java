package com.yuri.archjava.service;

import com.yuri.archjava.model.User;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * Created by yuri on 19.03.2015.
 */
public interface UserService {

    User save(User register);

    User findOne(Long id);

    boolean exists(Long id);

    List<User> findByEmail(String email);

    Page<User> findAll(int page, int size);

    void deleteAll();

}