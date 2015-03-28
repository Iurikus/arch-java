package com.yuri.archjava.model;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import javax.transaction.Transactional;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;

/**
 * Created by yuri on 19.03.2015.
 */
public class UserValidatorTest {

    private static Validator validator;

    @BeforeClass
    public static void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Ignore
    @Test
    @Transactional
    public void fieldsIsNull() {
        User user = new User();

        Set<ConstraintViolation<User>> constraintViolations = validator.validate(user);

        assertEquals( 3, constraintViolations.size() );
        assertEquals("may not be null",constraintViolations.iterator().next().getMessage()
        );
    }

    @Test
    public void notValidEmailPattern() {
        User user = new User();

        user.setPassword("passss");
        user.setRegistrationDate(org.joda.time.LocalDateTime.now());
        user.setEmail("ssss.ffff");

        Set<ConstraintViolation<User>> constraintViolations = validator.validate(user);

        assertEquals( 1, constraintViolations.size() );
        assertEquals("not a well-formed email address",constraintViolations.iterator().next().getMessage());
    }

    @Test
    public void validEmailPattern() {
        User user = new User();

        user.setPassword("passss");
        user.setRegistrationDate(org.joda.time.LocalDateTime.now());
        user.setEmail("ssss@ffff.com");

        Set<ConstraintViolation<User>> constraintViolations = validator.validate(user);
        assertEquals( 0, constraintViolations.size() );
    }

}
