package com.example.geumsabba;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity //spring security 활성화
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
<<<<<<< HEAD
                .antMatchers("/h2-console/**").permitAll()
                .anyRequest().authenticated()
                .and().csrf().ignoringAntMatchers("/h2-console/**")
                .and().headers().frameOptions().sameOrigin(); // Enable H2 Console in an iframe
    }



=======
                .anyRequest().permitAll() // Allow access to all URLs without authentication
                .and()
                .csrf().disable() // Disable CSRF protection
                .headers().frameOptions().disable(); // Disable X-Frame-Options header, necessary for H2 Console
      }
>>>>>>> refs/remotes/origin/main
}