// /*package com.cts.examportal.config;

// import com.exam.service.impl.UserDetailsServiceImpl;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.http.HttpMethod;
// import org.springframework.security.authentication.AuthenticationManager;
// import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
// import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.annotation.web.builders.WebSecurity;
// import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
// import org.springframework.security.config.http.SessionCreationPolicy;
// import org.springframework.security.core.userdetails.UserDetailsService;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.security.crypto.password.NoOpPasswordEncoder;
// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

// import java.nio.file.Path;
// import java.nio.file.Paths;

// @EnableWebSecurity
// @Configuration
// @EnableGlobalMethodSecurity(prePostEnabled = true)
// public class MySecurityConfig extends WebSecurityConfigurerAdapter {

//     @Autowired
//     private JwtAuthenticationEntryPoint unauthorizedHandler;

//     @Autowired
//     private JwtAuthenticationFilter jwtAuthenticationFilter;


//     @Autowired
//     private UserDetailsServiceImpl userDetailsServiceImpl;

//     @Override
//     @Bean
//     public AuthenticationManager authenticationManagerBean() throws Exception {
//         return super.authenticationManagerBean();
//     }

//     @Bean
//     public BCryptPasswordEncoder passwordEncoder() {
//         return new BCryptPasswordEncoder();
//     }


//     @Override
//     protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//         auth.userDetailsService(this.userDetailsServiceImpl).passwordEncoder(passwordEncoder());
//     }

//     @Override
//     protected void configure(HttpSecurity http) throws Exception {


//         http
//                 .csrf()
//                 .disable()
//                 .cors()
//                 .disable()
//                 .authorizeRequests()
//                 .antMatchers("/generate-token", "/user").permitAll()
//                 .antMatchers(HttpMethod.OPTIONS).permitAll()
//                 .anyRequest().authenticated()
//                 .and()
//                 .exceptionHandling().authenticationEntryPoint(unauthorizedHandler)
//                 .and()
//                 .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

//         http.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

//     }


// }*/

// package com.cts.examportal.config;

// import com.cts.examportal.service.impl.UserDetailsServiceImpl;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.http.HttpMethod;
// import org.springframework.security.authentication.AuthenticationManager;
// import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
// import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
// import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

// import org.springframework.security.config.http.SessionCreationPolicy;
// import org.springframework.security.core.userdetails.UserDetailsService;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.security.web.SecurityFilterChain;
// import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

// @Configuration
// @EnableWebSecurity
// @EnableMethodSecurity(prePostEnabled=true) 
// public class MySecurityConfig {

//     @Autowired
//     private JwtAuthenticationEntryPoint unauthorizedHandler;

//     @Autowired
//     private JwtAuthenticationFilter jwtAuthenticationFilter;

//     @Autowired
//     private UserDetailsServiceImpl userDetailsServiceImpl;
    
//    // @Autowired
//     //private PasswordEncoder passwordEncoder;
    

//     @Bean
//     public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//         http
//                 .csrf(csrf -> csrf.disable()) // Disable CSRF
//                 .cors(cors -> cors.disable()) // Disable CORS
//                 .authorizeHttpRequests((requests) -> requests
//                         .requestMatchers("/generate-token", "/user").permitAll() 
//                         .requestMatchers(HttpMethod.OPTIONS).permitAll()
//                         .anyRequest().authenticated()
//                     )              
//                 .exceptionHandling(exceptionHandling -> exceptionHandling 
//                         .authenticationEntryPoint(unauthorizedHandler)) // Configure exception handling
//                 .sessionManagement(sessionManagement -> sessionManagement 
//                         .sessionCreationPolicy(SessionCreationPolicy.STATELESS)); // Configure session management

//         http.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

//         return http.build();
//     }

//     /*@Bean
//     public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
//         return http.getSharedObject(AuthenticationManager.class);
//     }*/
//     @Bean
//     public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
//         return authenticationConfiguration.getAuthenticationManager();
//     }

//     @Bean
//     public BCryptPasswordEncoder passwordEncoder() {
//         return new BCryptPasswordEncoder();
//     }

//    @Autowired
//     public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//         auth.userDetailsService(userDetailsServiceImpl).passwordEncoder(passwordEncoder());
//     }
// }