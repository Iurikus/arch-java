package com.yuri.archjava.repository;

import com.yuri.archjava.dto.AdminListItemDto;
import com.yuri.archjava.model.User;
import com.yuri.archjava.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import org.joda.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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

    @Test
    public void testSave() {

        String password = "fgsfghshfg";
        String email = "sss@sffff.com";
        LocalDateTime date = getCurrentLocalDateTimeWithoutMillis();

        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        user.setRegistrationDate(date);
        user = userService.save(user);

        assertTrue(userService.exists(user.getId()));
        assertTrue(user.getId()>0);

        user = userService.findOne(user.getId());
        assertEquals(email, user.getEmail());
        assertEquals(password, user.getPassword());
        assertEquals(date, user.getRegistrationDate());

    }

    @Test
    public void findByEmail() {

        String email = "dfadfs@fdfs.coom";
        String password = "dfasdfagf";
        LocalDateTime date = getCurrentLocalDateTimeWithoutMillis();

        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        user.setRegistrationDate(date);
        user = userService.save(user);

        user = userService.findByEmail(email).get(0);
        assertEquals(email, user.getEmail());
        assertEquals(password, user.getPassword());
        assertTrue(user.getRegistrationDate() != null);

    }

    @Test
    public void getLogsTest() {
        List<AdminListItemDto> list = userService.getUserRecords(0, 100);
        assertEquals(3, list.size());
    }
}
