package com.dit.himachal.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private DataSource dataSource;


    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }




    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

     auth.jdbcAuthentication().dataSource(dataSource)
              .usersByUsernameQuery(
                "Select username ,password_,active  from users where username = ?")
                .authoritiesByUsernameQuery(
                        "SELECT urm.user_id,  roles.role_name,urm.role_id, users.username from user_role_mapping as urm\n" +
                                "INNER JOIN roles as roles ON roles.role_id = urm.role_id \n" +
                                "INNER JOIN users as users ON users.user_id = urm.user_id WHERE users.username = ?")
                .passwordEncoder(passwordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
        		//.anonymous()
        		//.and()
                .authorizeRequests()
                .antMatchers("/api/**").permitAll()
                .antMatchers("/api/getotp/**").permitAll()
                .antMatchers("/api/verifyotp/**").permitAll()
                .antMatchers("/downloadFile/**").permitAll()
                .antMatchers("/admin/**").hasAnyRole("ADMIN")
                //.anyRequest().hasAnyRole("USER")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/index")
                .permitAll();


    }
}
