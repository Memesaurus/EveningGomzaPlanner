package com.example.demo.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name = "authorities")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Authority implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "USERID")
    private Long userId;
    @Column(name = "authority")
    private String givenAuthority;

    public Authority(Long userId, String givenAuthority) {
        this.userId = userId;
        this.givenAuthority = givenAuthority;
    }

    @Override
    public String getAuthority() {
        return givenAuthority;
    }
}
