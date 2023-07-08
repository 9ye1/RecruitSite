package Likelion.RecruitSite.dto;

import Likelion.RecruitSite.entity.Posting;
import lombok.Data;

import java.util.List;

public class ResponseType {

    private ExceptionCode exceptionCode;

    public ResponseType(ExceptionCode exceptionCode) {
        this.exceptionCode = exceptionCode;
    }

}
