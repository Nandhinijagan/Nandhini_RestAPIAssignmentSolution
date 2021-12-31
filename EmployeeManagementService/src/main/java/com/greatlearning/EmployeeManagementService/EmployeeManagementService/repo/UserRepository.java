package com.greatlearning.EmployeeManagementService.EmployeeManagementService.repo;


import com.greatlearning.EmployeeManagementService.EmployeeManagementService.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query("FROM User u WHERE u.username = :username")
    User getByUsername(String username);
}
