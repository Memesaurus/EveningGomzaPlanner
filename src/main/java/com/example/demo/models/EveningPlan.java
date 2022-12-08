package com.example.demo.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "eveningplans")
@Getter
@Setter
public class EveningPlan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @JoinColumn(name = "userid", referencedColumnName = "id")
    private MyUser user;
    private String mood;
    private String plans;
    private LocalDate submitted;

    public void setEveningPlans(MoodValue mood, PlansValue plans) {
        this.submitted = LocalDate.now();
        this.mood = mood.getMoodValue();
        this.plans = plans.getPlansValue();
    }

}
