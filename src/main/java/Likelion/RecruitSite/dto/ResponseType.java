package Likelion.RecruitSite.dto;

import Likelion.RecruitSite.entity.Posting;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ResponseType {

    private ExceptionCode exceptionCode;
    private int status;

    public ResponseType(ExceptionCode exceptionCode) {
        this.exceptionCode = exceptionCode;
        this.status = exceptionCode.getCode();
    }

}
