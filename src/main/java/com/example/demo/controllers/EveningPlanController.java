package com.example.demo.controllers;

import com.example.demo.dto.UserEveningPlanDto;
import com.example.demo.models.EveningPlan;
import com.example.demo.services.EveningPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/v1/plans")
public class EveningPlanController {
    @Autowired
    private EveningPlanService eveningPlanService;

    @GetMapping
    public List<EveningPlan> getEveningPlansForToday() {
        LocalDate today = LocalDate.now();
        return eveningPlanService.getEveningPlansByDate(today);
    }

    @PostMapping
    @CrossOrigin
    public void submitPlans(@RequestBody UserEveningPlanDto userEveningPlanDto) {
        eveningPlanService.addEveningPlans(userEveningPlanDto);
    }

}
