package com.sysco.ordermanager.domain.repository;

import com.sysco.ordermanager.domain.model.OrderData;
import com.sysco.ordermanager.util.enums.OrderType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vibodhab on 2/8/18.
 */
@Repository
public interface OrderRepository extends JpaRepository<OrderData, Long> {
    public List<OrderData> findByUserDataId(Long id);
    public List<OrderData> findByType(OrderType type);
}
