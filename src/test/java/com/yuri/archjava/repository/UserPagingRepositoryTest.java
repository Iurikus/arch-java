package com.yuri.archjava.repository;

import com.yuri.archjava.model.User;
import com.yuri.archjava.service.UserService;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

import static com.yuri.archjava.utils.DateTimeUtils.getCurrentLocalDateTimeWithoutMillis;
import static org.junit.Assert.assertEquals;

/**
 * Created by yuri on 19.03.2015.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:jpaContext.xml")
public class UserPagingRepositoryTest {

    @Autowired
    UserService userService;

    List<User> users;

    @Before
    public void setUp() {
        final int count = 10;

        userService.deleteAll();

        users = new ArrayList<User>(count);
        User user;

        for (int i = 0; i < 10; i++) {
            user = userService.createTestUser(i);
            userService.save(user);
            users.add(user);
        }
    }

    @Test
    @Transactional
    public void pagingTest0() {
        Page<User> page;
        page = userService.findAll(0, 2);
        assertEquals(users.get(0) , page.getContent().get(0));
        assertEquals(users.get(1) , page.getContent().get(1));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    @Transactional
    public void pagingTest0Exc() {
        Page<User> page;
        page = userService.findAll(0, 2);
        page.getContent().get(2);
    }

    @Test
    @Transactional
    public void pagingTest1() {
        Page<User> page;
        page = userService.findAll(1, 2);
        assertEquals(users.get(2) , page.getContent().get(0));
        assertEquals(users.get(3) , page.getContent().get(1));
        assertEquals(2, page.getNumberOfElements());
    }

    @Test
    @Transactional
    public void pagingTest2() {
        Page<User> page;
        page = userService.findAll(3, 3);
        assertEquals(users.get(9) , page.getContent().get(0));
        assertEquals(1, page.getNumberOfElements());
    }
}
