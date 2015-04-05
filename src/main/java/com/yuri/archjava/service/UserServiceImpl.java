package com.yuri.archjava.service;

import com.yuri.archjava.dto.AdminListItemDto;
import com.yuri.archjava.model.User;
import com.yuri.archjava.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by yuri on 19.03.2015.
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User save(User user) {
        System.out.println("UserServiceImpl.save: register="+user.toString());
        return userRepository.save(user);
    }

    @Override
    public User findOne(Long id) {
        return userRepository.findOne(id);
    }

    @Override
    public boolean exists(Long id) {
        return userRepository.findOne(id)!=null;
    }

    @Override
    public List<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public Page<User> findAll(int page, int size) {
        return userRepository.findAll(new PageRequest(page, size));
    }

    @Override
    public void deleteAll() {
        userRepository.deleteAllInBatch();
    }

    @Override
    public long getCount() {
        return userRepository.count();
    }

    @Override
    public List<AdminListItemDto> getUserRecords(int start, int size) {
        return userRepository.findUserRecords(start, size);
    }
}
