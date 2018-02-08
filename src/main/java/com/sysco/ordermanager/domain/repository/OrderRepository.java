package com.sysco.ordermanager.domain.repository;

import com.sysco.ordermanager.domain.model.OrderData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by vibodhab on 2/8/18.
 */
@Repository
public interface OrderRepository extends JpaRepository<OrderData, String> {
}
