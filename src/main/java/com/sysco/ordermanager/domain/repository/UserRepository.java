package com.sysco.ordermanager.domain.repository;

import com.sysco.ordermanager.domain.model.UserData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserData, Long> {
<<<<<<< HEAD
    UserData findByName(String name);
=======
    UserData findByNameAndPassword(String name, String password);
>>>>>>> dev
}