package com.yuri.archjava.repository;

import com.yuri.archjava.model.User;
import com.yuri.archjava.service.UserService;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import org.joda.time.LocalDateTime;

import javax.transaction.Transactional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import static com.yuri.archjava.utils.DateTimeUtils.getCurrentLocalDateTimeWithoutMillis;

/**
 * Created by yuri on 19.03.2015.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:jpaContext.xml")
public class UserRepositoryTest {
    @Autowired
    UserService userService;

    @Test
    public void testSpring() {
        assertNotNull(userService);
    }

    /*@After
    public void cleanup() {
        System.out.println("cleanup");
        userService.deleteAll();
    }*/

    @Test
    @Transactional
    public void testSave() {
        System.out.println("testsave");
        String password = "fgsfghshfg";
        String email = "sss@sffff.com";
        LocalDateTime date = getCurrentLocalDateTimeWithoutMillis();

        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        user.setRegistrationDate(date);
        userService.save(user);

        assertTrue(userService.exists(user.getId()));
        assertTrue(user.getId()>0);

        user = userService.findOne(user.getId());
        assertEquals(email, user.getEmail());
        assertEquals(password, user.getPassword());
        assertEquals(date, user.getRegistrationDate());

    }

    @Test
    @Transactional
    public void testDuplicateSave() {
        System.out.println("testDuplicateSave");
        String password = "fgsfghshfg";
        String email = "sss@sffff.com";
        LocalDateTime date = getCurrentLocalDateTimeWithoutMillis();
        User user;

        user = new User();
        user.setEmail(email);
        user.setPassword(password);
        user.setRegistrationDate(date);
        assertTrue(userService.save(user));

        user = new User();
        user.setEmail(email);
        user.setPassword(password);
        user.setRegistrationDate(date);
        assertTrue(!userService.save(user));
    }


    @Test
    @Transactional
    public void findByEmail() {
        String email = "df3adfs@fdfs.coom";
        String password = "dfasdfagf";
        LocalDateTime date = getCurrentLocalDateTimeWithoutMillis();

        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        user.setRegistrationDate(date);
        userService.save(user);

        user = userService.findByEmail(email).get(0);
        assertEquals(email, user.getEmail());
        assertEquals(password, user.getPassword());
        assertTrue(user.getRegistrationDate() != null);
    }

    @Test
    @Transactional
    public void findCountOfAccounts() {
        final int count = 7;
        userService.prepareTestData(count);
        assertEquals(count, userService.getAccountsCount());
    }
}
