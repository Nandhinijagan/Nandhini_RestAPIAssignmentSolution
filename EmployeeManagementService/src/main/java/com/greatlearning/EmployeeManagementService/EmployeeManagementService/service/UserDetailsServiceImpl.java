package com.greatlearning.EmployeeManagementService.EmployeeManagementService.service;
import com.greatlearning.EmployeeManagementService.EmployeeManagementService.config.MyUserDetails;
import com.greatlearning.EmployeeManagementService.EmployeeManagementService.entity.User;
import com.greatlearning.EmployeeManagementService.EmployeeManagementService.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.getByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("Could not find user");
        }

        return new MyUserDetails(user);
    }
}
