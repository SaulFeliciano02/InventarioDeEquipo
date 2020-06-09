package saulwebavanzada.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

@SpringBootApplication
public class InventarioDeEquipoApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventarioDeEquipoApplication.class, args);

//        ApplicationContext applicationContext = SpringApplication.run(InventarioDeEquipoApplication.class, args);
//        RoleServicio roleServicio = (RoleServicio) applicationContext.getBean("roleServicio");
//        Role roleAdmin = new Role("ROLE_ADMIN");
//        //roleServicio.crearRole(roleAdmin);
//
//        UsuarioServicio usuarioServicio = (UsuarioServicio) applicationContext.getBean("usuarioServicio");
//        Usuario usuarioAdmin = new Usuario("admin", "admin", new HashSet<>(Arrays.asList(roleAdmin)));
//        //usuarioServicio.crearUsuario(usuarioAdmin);

    }

    @Bean
    public CookieLocaleResolver localeResolver() {
        return new CookieLocaleResolver();
    }

    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
        lci.setParamName("lang");
        return lci;
    }
}
