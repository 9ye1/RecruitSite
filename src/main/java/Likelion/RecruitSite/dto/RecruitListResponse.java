package Likelion.RecruitSite.dto;


import Likelion.RecruitSite.entity.Applicant;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RecruitListResponse extends ResponseType {

    private List<Applicant> info;

    public RecruitListResponse(ExceptionCode exceptionCode, List<Applicant> info) {
        super(exceptionCode);
        this.info = info;
    }

}
