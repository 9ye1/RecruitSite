package Likelion.RecruitSite.entity;

import Likelion.RecruitSite.dto.ApplicantDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
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

    @Column(length = 300)
    private String introduce;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "posting_id")
    @JsonIgnore
    private Posting posting;

    @Builder
    public Applicant(ApplicantDto.ApplicantRequest dto, Posting posting) {
        this.name = dto.getName();
        this.phoneNumber = dto.getPhoneNumber();
        this.school = dto.getSchool();
        this.major = dto.getMajor();
        this.job = dto.getJob();
        this.age = dto.getAge();
        this.gender = dto.getGender();
        this.introduce = dto.getIntroduce();
    }
}
