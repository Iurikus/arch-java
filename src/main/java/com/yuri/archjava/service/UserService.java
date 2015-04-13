package com.yuri.archjava.service;

import com.yuri.archjava.dto.AdminListItemDto;
import com.yuri.archjava.model.User;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * Created by yuri on 19.03.2015.
 */
public interface UserService {

    boolean save(User register);

    User findOne(Long id);

    boolean exists(Long id);

    List<User> findByEmail(String email);

    Page<User> findAll(int page, int size);

    void deleteAll();

    long getCount();

    List<AdminListItemDto> getUserRecords(int start, int size);

    void prepareTestData(int count);

    User createTestUser(int id);

    long getAccountsCount();
}
