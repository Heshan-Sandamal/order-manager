package com.sysco.ordermanager.domain.repository;

import com.sysco.ordermanager.domain.model.ItemData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<ItemData, Long> {
}
