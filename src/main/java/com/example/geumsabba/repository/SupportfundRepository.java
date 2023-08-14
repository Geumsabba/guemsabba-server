package com.example.geumsabba.repository;

import com.example.geumsabba.entity.Supportfund;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupportfundRepository extends JpaRepository<Supportfund,Long> {
}
