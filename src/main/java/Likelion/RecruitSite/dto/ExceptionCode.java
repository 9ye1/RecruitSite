package Likelion.RecruitSite.dto;

public enum ExceptionCode {

    SUCCESS(200, "성공"),
    FIND_NOT_POSTING(404, "존재하지 않는 공고"),
    FIND_NOT_APPLICANT(404, "존재하지 않는 지원자"),;

    private int code;
    private String message;

    ExceptionCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }
}
