package com.fred.MultLib.models.dao;

import com.fred.MultLib.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User, Long>{
    User findByUsername(String username);
}
