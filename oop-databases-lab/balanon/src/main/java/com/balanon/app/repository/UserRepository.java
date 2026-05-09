
package com.balanon.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.balanon.app.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

    // Spring Data generates these queries automatically from method names
    boolean existsByEmail(String email);
    User findByEmail(String email);
}