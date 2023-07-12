package Likelion.RecruitSite.entity;

import Likelion.RecruitSite.dto.ApplicantDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
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

    @ManyToOne //(fetch = FetchType.LAZY) // 지연 로딩
    @JoinColumn(name = "posting_id")
    private Posting posting;

}
