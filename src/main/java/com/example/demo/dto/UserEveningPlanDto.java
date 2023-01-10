package com.example.demo.dto;

import com.example.demo.models.MoodValue;
import com.example.demo.models.PlansValue;
import lombok.Data;

@Data
public class UserEveningPlanDto {
    private String username;
    private String mood;
    private String plans;
}
