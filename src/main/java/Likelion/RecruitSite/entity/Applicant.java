package Likelion.RecruitSite.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Applicant {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String phoneNumber; // 연락처
    private String school;
    private String major;
    private String job;
    private int age;
    private int gender;

    private String image;

    @Column(length = 300)
    private String introduce;

    @OneToOne
    private JobOpening company;
}
