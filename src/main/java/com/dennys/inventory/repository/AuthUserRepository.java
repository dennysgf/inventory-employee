package com.dennys.inventory.repository;


import com.dennys.inventory.entity.AuthUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface AuthUserRepository extends PagingAndSortingRepository<AuthUser, Long> {
    Optional<AuthUser> findByUserName(String email);
    Page<AuthUser> findByUserNameContains(String email, Pageable pageable);
    Page<AuthUser> findAllByUserName(String email, Pageable pageable);
    Page<AuthUser> findAllByUserNameContainsAndUserName(String email, String auth, Pageable pageable);

    Boolean existsByUserName(String email);
}
