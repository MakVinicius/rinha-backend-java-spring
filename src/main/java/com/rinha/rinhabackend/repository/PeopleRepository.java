package com.rinha.rinhabackend.repository;

import com.rinha.rinhabackend.entity.People;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PeopleRepository extends JpaRepository<People, UUID> {
    Optional<People> findByNickname(String nickname);

    @Query("SELECT p FROM People p WHERE p.concatenated LIKE %:term%")
    Optional<List<People>> findByConcatenatedContaining(@Param("term") String term);
}
