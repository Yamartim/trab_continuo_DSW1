package br.ufscar.dc.dsw.config;

import org.springframework.context.annotation.*;
import org.springframework.security.authentication.dao.*;
import org.springframework.security.config.annotation.authentication.builders.*;
import org.springframework.security.config.annotation.web.builders.*;
import org.springframework.security.config.annotation.web.configuration.*;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import br.ufscar.dc.dsw.security.UsuarioDetailsServiceImpl;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

@Bean
public UserDetailsService userDetailsService() {
   return new UsuarioDetailsServiceImpl();
}

@Bean
public BCryptPasswordEncoder passwordEncoder() {
   return new BCryptPasswordEncoder();
}

@Bean
public DaoAuthenticationProvider authenticationProvider() {
   DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
   authProvider.setUserDetailsService(userDetailsService());
   authProvider.setPasswordEncoder(passwordEncoder());

   return authProvider;
}

@Override
protected void configure(AuthenticationManagerBuilder auth) throws Exception {
   auth.authenticationProvider(authenticationProvider());
}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests()
				// Controladores REST
				.antMatchers("/clientes/listar", "/clientes/editar").permitAll()
				.antMatchers("/clientes", "/profissionais", "/consultas").permitAll()
				.antMatchers("/profissionais/listar", "/clientes/salvar").permitAll()
				.antMatchers("/clientes/excluir/{\\d+}", "/profissionais/editar").permitAll()
				.antMatchers("/clientes/listar/{\\d+}", "/profissionais/listar/{\\d+}").permitAll()
				.antMatchers("/consultas/listar", "/profissionais/salvar").permitAll()
				.antMatchers("/profissionais/listar/especialidades/{\\w+}", "/profissionais/excluir/{\\d+}").permitAll()
				.antMatchers("/consultas/salvar", "/consulta/agendamento").permitAll()
				.antMatchers("/consultas/profissionais/{\\d+}").permitAll()
				// Demais linhas
				.anyRequest().authenticated()
				.and()
				.formLogin().loginPage("/login").permitAll()
				.and()
				.logout().logoutSuccessUrl("/").permitAll();
	}
}