package com.pitpat.pitterpatter.domain.user.repository;

import com.pitpat.pitterpatter.domain.user.model.dto.RefreshTokenDto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RefreshTokenRepository extends CrudRepository<RefreshTokenDto, String> {
}