package com.ozgur.kutuphane.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.ozgur.kutuphane.service.KullaniciService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private KullaniciService kullaniciService;

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
		auth.setUserDetailsService(kullaniciService);
		auth.setPasswordEncoder(passwordEncoder());
		return auth;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.antMatchers("/registration**", 
						"/js/**", 
						"/css/**",
						"/img/**", 
						"/picture/**",
						"/", 
						"/login",
						"/registration").permitAll()
				.antMatchers("/yayineviForYonetici", 
						"/saveYazar",
						"/newSaveYazar", 
						"/yazarForYonetici",
						"/saveYayinEvi", 
						"/newSaveYayinEvi", 
						"/saveKitapNew", 
						"/showNewKitapForm",
						"/showFormForDeleteKitap", 
						"/showYoneticiPage", 
						"/deleteKitap/{id}", 
						"/saveKitap",
						"/showFormForKitapUpdate/{id}", 
						"/showFormForKitapUpdate", 
						"/kitapSearchFormForYonetici",
						"/kitapSearchForYonetici", 
						"/kitapForYonetici")
				.hasRole("ADMIN")
				.antMatchers("/kitapForUye", 
						"/kitapSearchFormForUye",
						"/kitapSearchForUye", 
						"/yazarForUye",
						"/showUyePage",
						"/yayineviForUye")
				.hasRole("USER")
				.anyRequest()
				.authenticated()
				.and()
				.formLogin()
				.loginPage("/login")
				.defaultSuccessUrl("/default")
				.permitAll()
				.and()
				.logout()
				.invalidateHttpSession(true)
				.clearAuthentication(true)
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
				.logoutSuccessUrl("/login?logout")
				.permitAll();
	}

}