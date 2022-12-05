package br.unitins.abamanager;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

	@Bean
	public PasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();    
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests().requestMatchers("/img/**").permitAll();
		http.authorizeHttpRequests().anyRequest().authenticated().and()
				.formLogin(
						form -> form.loginPage("/login")
						.usernameParameter("email")
						.defaultSuccessUrl("/home", true)
						.permitAll())
				.logout(logout -> logout.logoutUrl("/logout")).csrf().disable();
		return http.build();
	}
	
	@Bean
	public UserDetailsManager users(DataSource dataSource) {
//		UserDetails user = User.builder()
//			.username("root@gmail.com")
//			.password(passwordEncoder().encode("root"))
//			.roles("ADM")
//			.build();
		
//		UserDetails user2 = User.builder()
//			.username("profissional@gmail.com")
//			.password(passwordEncoder().encode("123"))
//			.roles("ADM")
//			.build();
		
		JdbcUserDetailsManager users = new JdbcUserDetailsManager(dataSource);
//		users.createUser(user);
//		users.createUser(user2);
		return users;
	}

}
