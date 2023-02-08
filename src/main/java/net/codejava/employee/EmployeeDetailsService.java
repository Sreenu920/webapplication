package net.codejava.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
 
public class EmployeeDetailsService implements UserDetailsService {
 
    @Autowired private EmployeeRepository emprepo;
     
    @Override
    public EmployeeDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Employee employee = emprepo.findByEmail(email);
        if (employee == null) {
            throw new UsernameNotFoundException("No customer found with the given email.");
        }
         
        return new EmployeeDetails(employee);
    }
 
}