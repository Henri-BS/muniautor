package com.pasifcode.muniautor.domain.repository;

import com.pasifcode.muniautor.domain.entity.Character;
import com.pasifcode.muniautor.domain.entity.Section;
import com.pasifcode.muniautor.domain.entity.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpecificationRepository extends JpaRepository<Specification, Long> {

    List<Specification> findByCharacter(Character character);
}