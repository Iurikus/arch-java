package com.yuri.archjava.repository;

import com.yuri.archjava.model.AccoutItem;
import com.yuri.archjava.model.User;
import com.yuri.archjava.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import javax.transaction.Transactional;
import java.util.Collections;

/**
 * Created by yuri on 21.03.2015.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:jpaContext.xml")
//@TransactionConfiguration
public class UserAccountsTest {
    @Autowired
    UserService userService;

    @Test
//    @Transactional
    public void testAddAccount() {

        userService.deleteAll();

        User user = UserPagingRepositoryTest.createUser(1);

//        userService.save(user);

        AccoutItem accoutItem = new AccoutItem();
        accoutItem.setAmount(10);
        accoutItem.setUser(user);

        user.getAccounts().add(accoutItem);
        userService.save(user);

        System.out.println("delete accounts");
        user.setAccounts(Collections.<AccoutItem>emptyList());
        userService.save(user);
        System.out.println("delete user");
        userService.deleteAll();
    }

}
