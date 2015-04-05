package com.yuri.archjava.repository;

import com.yuri.archjava.dto.AdminListItemDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuri on 04.04.2015.
 */
public class UserRepositoryImpl implements UserRepositoryCustom {

    @PersistenceContext
    EntityManager entityManager;

    private static final Logger LOGGER = LoggerFactory.getLogger(UserRepositoryImpl.class);


    @Override
    public List<AdminListItemDto> findUserRecords(int page, int size) {
        LOGGER.info("page=" + page + "; size=" + size);
        List<AdminListItemDto> list = new ArrayList<AdminListItemDto>();

        AdminListItemDto dto;
        dto = new AdminListItemDto("email1", "1", "2015-04-04");
        list.add(dto);

        dto = new AdminListItemDto("email2", "2", "2015-04-05");
        list.add(dto);

        dto = new AdminListItemDto("email2", "3", "2015-04-06");
        list.add(dto);

        return list;
    }
}
