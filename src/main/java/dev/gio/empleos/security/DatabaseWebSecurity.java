package dev.gio.empleos.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class DatabaseWebSecurity extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource dataSource;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource)
		.usersByUsernameQuery("select username, password, estatus from usuarios where username=?")
		.authoritiesByUsernameQuery("select u.username, p.perfil from usuarioperfil up " +
				"inner join usuarios u on u.id = up.idUsuario " +
				"inner join perfiles p on p.id = up.idPerfil " +
				"where u.username =?");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.authorizeRequests()
		.antMatchers(
		//Los recuersos estaticos no requieren autenticación
				"/bootstrap/**",
				"/images/**",
				"/tinymce/**",
				"/logos/**").permitAll()
		
		//Las vistas públicas no requieren Autorización
		.antMatchers("/",
				"/signup",
				"/search",
				"/vacantes/view/**").permitAll()
		
		//Asignar permisos a URLs por roles
		.antMatchers("/vacantes/**").hasAnyAuthority("SUPERVISOR","ADMINISTRADOR")
		.antMatchers("/categorias/**").hasAnyAuthority("SUPERVISOR","ADMINISTRADOR")
		.antMatchers("/usuarios/**").hasAnyAuthority("ADMINISTRADOR")
		
		//Todas las demas URLs de la Aplicación requieren autenticación
		.anyRequest().authenticated()
		
		//El formulario de Login no requiere autenticación
		.and().formLogin().permitAll();
		
	}
}
