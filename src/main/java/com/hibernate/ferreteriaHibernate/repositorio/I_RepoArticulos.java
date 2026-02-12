package com.hibernate.ferreteriaHibernate.repositorio;

import com.hibernate.ferreteriaHibernate.entity.Articulos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface I_RepoArticulos extends JpaRepository<Articulos, Long> {
}
