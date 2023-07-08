package Likelion.RecruitSite.dto;

import Likelion.RecruitSite.entity.Posting;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

public class PostingDto {

    @Getter
    public static class PostDto {
        private String name;
        private String job_group;
        private String info;
        private int personnel;
        private int salary;
    }

    @Getter
    public static class PostInfo {
        private Long id;
        private String image;
        private String name;
        private String job_group;

        public PostInfo(Posting posting) {
            this.id = posting.getId();
            this.image = posting.getImage();
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
    public static class PostResponse extends ResponseType {
        private Posting posting;

        public PostResponse(ExceptionCode exceptionCode, Posting posting) {
            super(exceptionCode);
            this.posting = posting;
        }
    }
}
