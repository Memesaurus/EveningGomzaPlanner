package com.example.demo.services;

import com.example.demo.dto.UserEveningPlanDto;
import com.example.demo.models.EveningPlan;
import com.example.demo.models.MoodValue;
import com.example.demo.models.MyUser;
import com.example.demo.models.PlansValue;
import com.example.demo.repositories.EveningPlanRepository;
import com.example.demo.repositories.MyUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static com.example.demo.Constant.RESET_TIME;

@Service
public class EveningPlanService {
    @Autowired
    private MyUserRepository myUserRepository;
    @Autowired
    private EveningPlanRepository eveningPlanRepository;

    //Will be mapped to DTO
    public List<EveningPlan> getEveningPlansByDate(LocalDate date) {
        LocalDateTime startTime = LocalDateTime.of(date.minusDays(1), RESET_TIME);
        LocalDateTime endTime = LocalDateTime.of(date, RESET_TIME);
        return eveningPlanRepository.findAllBySubmittedBetween(startTime, endTime);
    }

    public void addEveningPlans(UserEveningPlanDto userEveningPlanDto) {
        String username = userEveningPlanDto.getUsername();
        MyUser currentUser = myUserRepository.findByUsername(username)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, username + " not found!"));
        EveningPlan eveningPlan = eveningPlanRepository.findByUserUsername(username).orElse(new EveningPlan());
        if (eveningPlan.getUser() == null) {
            eveningPlan.setUser(currentUser);
        }
        try {
            MoodValue mood = MoodValue.valueOf(userEveningPlanDto.getMood());
            PlansValue plans = PlansValue.valueOf(userEveningPlanDto.getPlans());
            eveningPlan.setEveningPlans(mood, plans);
        } catch (IllegalArgumentException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "One of the provided status values is not valid!");
        }
        eveningPlanRepository.save(eveningPlan);
    }
}
