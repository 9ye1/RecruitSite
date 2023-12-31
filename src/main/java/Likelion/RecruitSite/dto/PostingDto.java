package Likelion.RecruitSite.dto;

import Likelion.RecruitSite.entity.Applicant;
import Likelion.RecruitSite.entity.Posting;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class PostingDto {

    @Getter
    public static class PostDto {
        private String info;
        private String name;
        private String job_group;
        private int personnel;
        private int salary;

        public Posting toEntity() {
            return new Posting(null, info, name, job_group, personnel, salary);
        }
    }

    @Getter
    public static class PostInfo {
        private Long id;
        private String name;
        private String job_group;

        public PostInfo(Posting posting) {
            this.id = posting.getId();
            this.name = posting.getName();
            this.job_group = posting.getJobGroup();
        }
    }

    @Getter
    public static class PostInfoResponse extends ResponseType {
        private List<PostInfo> postingList;

        public PostInfoResponse(ExceptionCode exceptionCode, List<Posting> postingList) {
            super(exceptionCode);

            this.postingList = new ArrayList<>();
            for (Posting p : postingList) {
                this.postingList.add(new PostInfo(p));
            }
        }
    }

    @Getter
    public static class ApplicantResponse {
        private Long id;
        private String name;
        private String job;

        public ApplicantResponse(Applicant applicant) {
            this.id = applicant.getId();
            this.name = applicant.getName();
            this.job = applicant.getJob();
        }
    }

    @Getter
    public static class PostResponse extends ResponseType {
        private Posting posting;
        private List<ApplicantResponse> applicants;

        public PostResponse(ExceptionCode exceptionCode, Posting posting, List<Applicant> applicants) {
            super(exceptionCode);
            this.posting = posting;

            this.applicants = new ArrayList<>();
            for (Applicant a : applicants) {
                this.applicants.add(new ApplicantResponse(a));
            }

        }
    }
}
