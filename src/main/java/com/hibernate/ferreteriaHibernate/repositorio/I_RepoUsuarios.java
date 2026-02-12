package com.hibernate.ferreteriaHibernate.repositorio;

import com.hibernate.ferreteriaHibernate.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface I_RepoUsuarios extends JpaRepository<Usuario,Long> {
    Optional<Usuario> findByUsuario(String usuario);
}
