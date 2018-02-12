package com.sysco.ordermanager.domain.repository;

import com.sysco.ordermanager.domain.model.RestaurantData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepository extends JpaRepository<RestaurantData,String> {
}
