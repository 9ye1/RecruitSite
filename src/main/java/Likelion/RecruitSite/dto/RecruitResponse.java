package Likelion.RecruitSite.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RecruitResponse extends ResponseType {

    private Object applicant;

    public RecruitResponse(ExceptionCode exceptionCode) {
        super(exceptionCode);
    }

    public RecruitResponse(ExceptionCode exceptionCode, Object applicant) {
        super(exceptionCode);
        this.applicant = applicant;
    }

}
