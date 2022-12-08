package com.example.demo.dto;

import com.example.demo.models.MoodValue;
import com.example.demo.models.PlansValue;
import lombok.Data;

@Data
public class UserEveningPlanDto {
    String username;
    String mood;
    String plans;
}
