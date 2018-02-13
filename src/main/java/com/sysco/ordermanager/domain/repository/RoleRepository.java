package com.sysco.ordermanager.domain.repository;

import com.sysco.ordermanager.domain.model.UserData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<UserData, Long> {

}
