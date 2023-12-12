package poly.dn.hyundai;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import poly.dn.hyundai.service.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Autowired
	CustomUserDetailsService customUserDetailsService;



	@Bean
	public static PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(customUserDetailsService);
		provider.setPasswordEncoder(passwordEncoder());
		return provider;
	}

   @Bean
   public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
	  http.csrf().disable();
	   http.authorizeHttpRequests()
       .requestMatchers("/ThanhToan/**").authenticated()
	   .requestMatchers("/order/**").authenticated()
	   .requestMatchers("/admin/**").hasAnyAuthority("STAF","DIRE")
	   .requestMatchers("/rest/authorities").hasAuthority("DIRE")
	   .requestMatchers("/reset-password","/password-request").permitAll()
	   .anyRequest().permitAll();


	   http.formLogin()
	   .loginPage("/security/login/form")
	   .loginProcessingUrl("/security/login")
	   .defaultSuccessUrl("/security/login/success", false)
	   .failureUrl("/security/login/error");

	   http.rememberMe()
	   .tokenValiditySeconds(86400);

	   http.exceptionHandling()
	   .accessDeniedPage("/security/unauthoried");


	   http.logout()
              .logoutUrl("/security/logoff/success");



	   return http.build();
   }

   @Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws  Exception{
          auth.userDetailsService(customUserDetailsService).passwordEncoder(passwordEncoder());

   }

}