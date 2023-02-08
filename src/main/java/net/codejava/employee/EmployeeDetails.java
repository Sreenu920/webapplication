package net.codejava.employee;

import java.sql.Date;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
 
public class EmployeeDetails implements UserDetails {
    private Employee employee;
 
    public EmployeeDetails(Employee employee) {
        this.employee = employee;
    }
 
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }
 
    @Override
    public String getPassword() {
        return employee.getPassword();
    }
 
    @Override
    public String getUsername() {
        return employee.getEmail();
    }
 
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
 
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
 
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
 
    @Override
    public boolean isEnabled() {
        return true;
    }
    public String getFullName() {
		return employee.getFirstName() + " " + employee.getLastName();
	}
    public String getFirstName() {
    	return employee.getFirstName();    }
    public String getLastName() {
    	return employee.getLastName();    }
    public Long getId() {
    	return employee.getId();    }
    public String getAddress() {
    	return employee.getAddress();    }
    public String getPhone() {
    	return employee.getPhone();    }
   
    public String getEmail() {
    	return employee.getEmail();    }
}
