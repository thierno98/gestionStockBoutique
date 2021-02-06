package com.gestionboutiqueinformatique.myapp.repository;

import com.gestionboutiqueinformatique.myapp.domain.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Spring Data JPA repository for the {@link Authority} entity.
 */
public interface AuthorityRepository extends JpaRepository<Authority, String> {}
