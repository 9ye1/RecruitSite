package Likelion.RecruitSite.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RecruitResponse extends ResponseType {

    private Object info;

    public RecruitResponse(ExceptionCode exceptionCode) {
        super(exceptionCode);
    }

    public RecruitResponse(ExceptionCode exceptionCode, Object info) {
        super(exceptionCode);
        this.info = info;
    }

}
