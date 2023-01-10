package com.example.demo.repositories;

import com.example.demo.models.EveningPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface EveningPlanRepository extends JpaRepository<EveningPlan, Long> {
    Optional<EveningPlan> findByUserUsername(String username);

    List<EveningPlan> findAllBySubmittedBetween(LocalDateTime startDate, LocalDateTime endDate);
}
