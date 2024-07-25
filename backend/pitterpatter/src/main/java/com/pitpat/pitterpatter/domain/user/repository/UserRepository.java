package com.pitpat.pitterpatter.domain.user.repository;

import com.pitpat.pitterpatter.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    // =================== 로그인 관련 ======================
    Optional<UserEntity> findByEmail(String email);

    // ================== 회원가입 관련 ====================
    boolean existsByEmail(String email);
    boolean existsByTeamName(String teamName);
}
