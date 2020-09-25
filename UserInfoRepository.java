package com.promptous.repository;

import com.promptous.entity.UserInfoEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserInfoRepository extends CrudRepository<UserInfoEntity, String> {

    Optional<UserInfoEntity> findByUserName(String userName);

    Optional<UserInfoEntity> findByUserId(String userId);

    Optional<UserInfoEntity> findByAccountEmail(String accountEmail);

    // Returns 50 as a hack, because Hibernate can't handle JDBC type 1111
    @Query(value = "SELECT promptous.disable_inactive_accounts();", nativeQuery = true)
    Integer disableInactiveAccounts();

    List<UserInfoEntity> findByAccountEmailIn(List<String> emails);

}
