package com.yuri.archjava.repository;

import com.yuri.archjava.dto.AdminListItemDto;
import com.yuri.archjava.model.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by yuri on 19.03.2015.
 */
public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findByEmail(String email);

    @Query(value = "select new com.yuri.archjava.dto.AdminListItemDto(ai.user.email, ai.amount, 'fakedate') from AccoutItem ai", countQuery = "select count(ai) from AccoutItem ai")
    public List<AdminListItemDto> findUserRecords(Pageable pageable);
}
