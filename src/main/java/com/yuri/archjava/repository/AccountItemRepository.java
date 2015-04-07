package com.yuri.archjava.repository;

import com.yuri.archjava.model.AccoutItem;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by yuri on 07.04.2015.
 */
public interface AccountItemRepository extends JpaRepository<AccoutItem, Long> {
}
