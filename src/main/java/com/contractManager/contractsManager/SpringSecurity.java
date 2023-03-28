package com.contractManager.contractsManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SpringSecurity {

//    @Autowired
//    private UserDetailsService userDetailsService;
    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public static PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    	System.out.println("Securoty Filter autho");
    	//http.csrf().disable()
                http.authorizeHttpRequests((authorize) ->
		                authorize.requestMatchers("/register/**").permitAll()
		                		.requestMatchers("/index").permitAll()
		                		//.requestMatchers("/contracts").permitAll()
		                		.requestMatchers("/users").hasRole("ADMIN")
		                		.requestMatchers("/contracts").hasRole("ADMIN")
		                		.requestMatchers("/addContract").hasRole("ADMIN")
                        /*requestMatchers("/register/**").permitAll()
                                .requestMatchers("/index").permitAll()
                                //.requestMatchers("/users").permitAll()
                                .requestMatchers("/users").hasRole("ROLE_ADMIN")
                                .requestMatchers("/users").hasRole("ADMIN")//*/
                ).formLogin(
                        form -> form
                                .loginPage("/login")
                                .loginProcessingUrl("/login")
                                .defaultSuccessUrl("/users", true)
                                .permitAll()
                ).logout(
                        logout -> logout
                                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                                .permitAll()
                );//*/
        return http.build();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    	System.out.println("Configure Global");
        auth
                .userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());
    }
}
