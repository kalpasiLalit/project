package com.ttn.EcommerceProject.EcommerceProject.Repository;


import com.ttn.EcommerceProject.EcommerceProject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;

/*
                     USER_REPOSITORY
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {


  //  Optional<User> findByEmailAndPassword(String email,String password);

    Optional<User> findByEmail(String email);
    User findUserByEmail(String Email);

    @Transactional
    @Modifying
    @Query("UPDATE User a " +
            "SET a.isActive = TRUE WHERE a.email = ?1")
    int enableUser(String email);

    @Transactional
    @Modifying
    @Query("UPDATE User a " +
            "SET a.invalidAttemptCount = ?2 WHERE a.email = ?1")
    int invalidAttemptCount(String email,int invalidAttemptCount);

    @Transactional
    @Modifying
    @Query("UPDATE User a " +
            "SET a.isLocked = ?2 WHERE a.email = ?1")
    int updateIsLocked(String email,Boolean bool);

}