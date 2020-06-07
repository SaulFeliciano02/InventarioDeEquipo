package saulwebavanzada.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import saulwebavanzada.demo.entities.Role;

public interface RoleRepositorio extends JpaRepository<Role, String> {

}
