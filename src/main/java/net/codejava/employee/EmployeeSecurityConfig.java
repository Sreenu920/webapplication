package net.codejava.employee;

import org.springframework.context.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.*;
 
@Configuration
@Order(2)
public class EmployeeSecurityConfig extends WebSecurityConfigurerAdapter {
 
    @Bean
    public UserDetailsService employeeDetailsService() {
        return new EmployeeDetailsService();
    }


    @Bean
	public BCryptPasswordEncoder passwordEncoder2() {
		return new BCryptPasswordEncoder();
	}    
    
    @Bean
    public DaoAuthenticationProvider authenticationProvider2() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(employeeDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder2());
 
        return authProvider;
    }
 
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authenticationProvider(authenticationProvider2());
 
        http.antMatcher("/employee/**")
            .authorizeRequests().anyRequest().authenticated()
            .and()
                .formLogin()
                    .loginPage("/employee/login")
                    .usernameParameter("email")
                    .loginProcessingUrl("/employee/login")
                    .defaultSuccessUrl("/employee/home")
                .permitAll()
            .and()
                .logout()
                    .logoutUrl("/employee/logout")
                    .logoutSuccessUrl("/");
    }
}