package com.yuri.archjava.repository;

import com.yuri.archjava.dto.AdminListItemDto;

import java.util.List;

/**
 * Created by yuri on 04.04.2015.
 */
public interface UserRepositoryCustom {

    public List<AdminListItemDto> findUserRecords(int page, int size);
}
