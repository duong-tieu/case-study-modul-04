//package com.food.configuration;
//
//import com.food.repository.IUserRepository;
//import com.food.service.impl.UserDetailsServiceImpl;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.authentication.rememberme.InMemoryTokenRepositoryImpl;
//import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
//
//@EnableWebSecurity
//@EnableAutoConfiguration
//@ComponentScan(basePackageClasses =
//        {UserDetailsServiceImpl.class, IUserRepository.class})
//public class SecurityConfiguration {
//    private final UserDetailsServiceImpl userDetailsService;
//
//    public SecurityConfiguration(UserDetailsServiceImpl userDetailsService) {
//        this.userDetailsService = userDetailsService;
//    }
//
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
//        auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
//    }
//
//    @Bean
//    public WebSecurityCustomizer webSecurityCustomizer() {
//        return (web) -> web.ignoring().antMatchers("/static/**");
//    }
//
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http.cors().and().csrf().disable();
//
//        //Pages not require login
//        http.authorizeHttpRequests().antMatchers(
//                "/static/**", "/css/**", "/js/**", "/img/**",
//                "/login", "/logout"
//        ).permitAll();
//
//        // Pages require login with roles: ROLE_USER, ROLE_ADMIN.
//        // If not login yet, redirect to /login
//        http.authorizeHttpRequests()
//                .antMatchers("/", "/home/view","/dish/**")
//                .hasAnyRole("USER", "ADMIN");
//
//        // Pages require login with role: ROLE_ADMIN.
//        // If not login at admin role yet, redirect to /login
//        http.authorizeHttpRequests()
//                .antMatchers("/role/**")
//                .hasRole("ADMIN");
//
//        // When user login with ROLE_USER, but try to
//        // access pages require ROLE_ADMIN, redirect to /error-403
//        http.authorizeHttpRequests().and().exceptionHandling()
//                .accessDeniedPage("/access-denied");
//
//        // Configure login page (check login by spring security)
//        http.authorizeHttpRequests()
//                .anyRequest().authenticated()
//                .and()
//                .formLogin()
//                .loginProcessingUrl("/j_spring_security_check")
//                .loginPage("/login")
//                .defaultSuccessUrl("/home")
//                .failureUrl("/login?error=true")
//                .usernameParameter("username")
//                .passwordParameter("password")
//                .and()
//                .logout()
//                .logoutUrl("/logout")
//                .logoutSuccessUrl("/login?logout=true");
//
//        // Configure remember me (save token in database)
//        http.authorizeHttpRequests()
//                .and().rememberMe()
//                .tokenRepository(this.persistentTokenRepository())
//                .tokenValiditySeconds(24 * 60 * 60);//24 hours
//
//        return http.build();
//    }
//
//    // Token stored in memory (of web server)
//    public PersistentTokenRepository persistentTokenRepository() {
//        InMemoryTokenRepositoryImpl inMemoryTokenRepository = new InMemoryTokenRepositoryImpl();
//        return inMemoryTokenRepository;
//    }
//}

