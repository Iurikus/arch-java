package com.yuri.archjava.service;

import com.yuri.archjava.dto.AdminListItemDto;
import com.yuri.archjava.model.AccoutItem;
import com.yuri.archjava.model.User;
import com.yuri.archjava.repository.AccountItemRepository;
import com.yuri.archjava.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

import static com.yuri.archjava.utils.DateTimeUtils.getCurrentLocalDateTimeWithoutMillis;

/**
 * Created by yuri on 19.03.2015.
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    AccountItemRepository accountItemRepository;

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

        List<User> users = userRepository.findAll();
        for (User user : users) {
            user.setAccounts(Collections.EMPTY_LIST);
            save(user);
            userRepository.delete(user);
        }
    }

    @Override
    public long getCount() {
        return userRepository.count();
    }

    @Override
    public List<AdminListItemDto> getUserRecords(int start, int size) {
        Pageable pageable = new PageRequest(start, size);
        return userRepository.findUserRecords(pageable);
    }

    @Override
    public void prepareTestData(int count) {
        deleteAll();
        User user;
        for (int i = 0; i < count; i++) {
            user = createTestUser(i);
            save(user);
            AccoutItem accoutItem = new AccoutItem();
            accoutItem.setUser(user);
            accoutItem.setAmount(i*10+1);
            user.getAccounts().add(accoutItem);
            save(user);
        }
    }

    public User createTestUser(int id) {
        User user = new User();
        user.setPassword("passw"+id);
        user.setEmail(id+"sse@mail.com");
        user.setRegistrationDate(getCurrentLocalDateTimeWithoutMillis());
        return user;
    }

    @Override
    public long getAccountsCount() {
        return accountItemRepository.count();
    }
}
