package com.mdmytriaha.repository;

import com.mdmytriaha.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
