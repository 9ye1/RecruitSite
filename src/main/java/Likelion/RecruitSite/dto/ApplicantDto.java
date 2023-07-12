package Likelion.RecruitSite.dto;

import Likelion.RecruitSite.entity.Applicant;
import Likelion.RecruitSite.entity.Posting;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(access= AccessLevel.PROTECTED)
public class ApplicantDto{
    private Long company_id;

    private String name;
    private String phoneNumber;
    private String school;
    private String major;
    private String job;
    private int age;
    private int gender;
    private String introduce;
    private Posting company;

    public Applicant toEntity(Posting company) {
        return new Applicant(null, name, phoneNumber, school, major, job, age, gender, introduce, company);
    }


}