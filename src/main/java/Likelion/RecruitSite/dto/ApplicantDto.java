package Likelion.RecruitSite.dto;


import Likelion.RecruitSite.entity.Applicant;
import Likelion.RecruitSite.entity.Posting;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class ApplicantDto {

    @Getter
    @Setter
    public static class ApplicantRequest {
        private int id;

        private String name;
        private String phoneNumber; // 연락처
        private String school;
        private String major;
        private String job;
        private int age;
        private int gender;
        private String introduce;

        public Applicant toEntity (Posting company){
            return new Applicant(this, company);
        }
    }

    @Getter
    @Setter
    public static class ApplicantsResponse extends ResponseType {
        private List<Applicant> applicants;

        public ApplicantsResponse(ExceptionCode exceptionCode, List<Applicant> applicants) {
            super(exceptionCode);
            this.applicants = applicants;
        }
    }

    @Getter
    @Setter
    public static class ApplicantResponse extends ResponseType {
        private Applicant applicant;

        public ApplicantResponse(ExceptionCode exceptionCode, Applicant applicant) {
            super(exceptionCode);
            this.applicant = applicant;
        }
    }


}
