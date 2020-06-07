package saulwebavanzada.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import javax.sql.DataSource;

@EnableGlobalMethodSecurity(securedEnabled = true)
public class ConfiguracionSeguridad extends WebSecurityConfigurerAdapter {
//    @Autowired
//    private DataSource dataSource;
//    @Value("${query.user-jdbc}")
//    private String queryUsuario;
//    @Value("${query.rol-jdbc}")
//    private String queryRol;

//    @Autowired
//    private UserDetailsService userDetailsService;

//    /**
//     * La autentificación de los usuarios.
//     * @param auth
//     * @throws Exception
//     */
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        //Clase para encriptar contraseña
//        BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder();
//
//        //Cargando los usuarios en memoria.
//        /*auth.inMemoryAuthentication().passwordEncoder(bCryptPasswordEncoder)
//                .withUser("admin")
//                .password(bCryptPasswordEncoder.encode("admin"))
//                .roles("ADMIN","USER")
//                .and()
//                .withUser("usuario")
//                .password(bCryptPasswordEncoder.encode("1234"))
//                .roles("USER")
//                .and()
//                .withUser("vendedor")
//                .password(bCryptPasswordEncoder.encode("1234"))
//                .roles("VENDEDOR");*/
//
//
//
//        //Configuración para acceso vía JDBC
//       /* auth.jdbcAuthentication()
//                .usersByUsernameQuery(queryUsuario)
//                .authoritiesByUsernameQuery(queryRol)
//                .dataSource(dataSource)
//                .passwordEncoder(bCryptPasswordEncoder);*/
//
//        //Configuración JPA.
//        auth
//                .userDetailsService(userDetailsService)
//                .passwordEncoder(bCryptPasswordEncoder);
//    }

    /*
     * Permite configurar las reglas de seguridad.
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //Marcando las reglas para permitir unicamente los usuarios
        http
                .authorizeRequests()
                .antMatchers("/","/java/resources/**", "/login", "/home", "/demo/**", "/css/**", "/js/**", "/images/**", "/webjars/**", "**/favicon.ico", "**/bootstrap/**").permitAll() //permitiendo llamadas a esas urls.
                .antMatchers("/dbconsole/**").permitAll()
                .anyRequest().permitAll();
//                .antMatchers("/admin/").hasAnyRole("ADMIN", "USER")
//                .antMatchers("/estudiantes").permitAll() //hasAnyRole("ADMIN", "USER")
//                .anyRequest().denyAll() //cualquier llamada debe ser validada
//                .and()
//                .formLogin()
//                .loginPage("/") //indicando la ruta que estaremos utilizando.
//                .failureUrl("/login?error") //en caso de fallar puedo indicar otra pagina.
//                .permitAll()
//                .and()
//                .logout()
//                .permitAll();

        //deshabilitando las seguridad contra los frame internos.
        //Necesario para H2.
        http.csrf().disable();
        http.headers().frameOptions().disable();
    }
}
