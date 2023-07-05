package Likelion.RecruitSite.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class JobOpening {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "info", length = 300)
    private String info;

    private String name;
    private String jobGroup; // 직군
    private int salary;
    private int personnel; // 인원

    private String image;
}
