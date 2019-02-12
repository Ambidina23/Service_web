package org.sid;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled=true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired //permet d'injecter AuthenticationManagerBuilder auth, DataSource dataSource
	private void globalConfig(AuthenticationManagerBuilder auth, DataSource dataSource) throws Exception {
	
	auth.inMemoryAuthentication().withUser("moussa").password("{noop}123").roles("ADMIN");
	auth.inMemoryAuthentication().withUser("sema").password("{noop}123").roles("USER");}
	
		/* auth.jdbcAuthentication()
		 .dataSource(dataSource)
		.usersByUsernameQuery("select login as principal, mdp as credentials, true from users where login = ?")
		.authoritiesByUsernameQuery("select user_login as principal, roles_role as role from users_roles where user_login = ?")
		.rolePrefix("ROLE_");	
	}*/
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.csrf().disable()
			.authorizeRequests()
				.anyRequest()
					.authenticated()
						.and()
				.formLogin()
					.loginPage("/login")
						.permitAll()
						.defaultSuccessUrl("/index.html");
					
	}
}

/*@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    DataSource dataSource;

    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth)
        throws Exception {

        auth.jdbcAuthentication().dataSource(dataSource)
            .passwordEncoder(passwordEncoder())
            .usersByUsernameQuery("{SQL}") //SQL query
            .authoritiesByUsernameQuery("{SQL}"); //SQL query
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder;
    }
}
*/
