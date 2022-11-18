package com.ttn.EcommerceProject.EcommerceProject.Repository;

import com.ttn.EcommerceProject.EcommerceProject.model.ConfirmationToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface ConfirmationTokenRepository extends JpaRepository<ConfirmationToken, Long> {

    Optional<ConfirmationToken> findByToken(String token);

    @Transactional
    @Modifying
    @Query("UPDATE ConfirmationToken c " +
            "SET c.confirmedAt = ?2 " +
            "WHERE c.token = ?1")
    int updateConfirmedAt(String token, LocalDateTime confirmedAt);

    @Transactional
    @Modifying
    @Query(value = "UPDATE confirmation_token c set created_at =:createdAt , expires_at =:expiresAt, token =:token where c.id = :id", nativeQuery = true)
    int updateUser(@Param("token") String token, @Param("createdAt") LocalDateTime createdAt,@Param("expiresAt")
    LocalDateTime expiresAt,@Param("id") Long id);

    @Query(value = "SELECT * FROM confirmation_token a WHERE a.user_id = ?1", nativeQuery = true)
    Optional<ConfirmationToken> findByUserId(Long UserId);
}