package com.kodilla.collectionmanagerbackend.repository;

import com.kodilla.collectionmanagerbackend.domain.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    @Query
    User getUserByEmail(@Param("EMAIL") String email);
}
