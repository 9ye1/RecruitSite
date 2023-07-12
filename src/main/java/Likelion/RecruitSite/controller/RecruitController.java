package Likelion.RecruitSite.controller;

import Likelion.RecruitSite.dto.ApplicantDto;
import Likelion.RecruitSite.dto.PostingDto;
import Likelion.RecruitSite.dto.RecruitListResponse;
import Likelion.RecruitSite.dto.RecruitResponse;
import Likelion.RecruitSite.entity.Applicant;
import Likelion.RecruitSite.service.RecruitService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static Likelion.RecruitSite.dto.ExceptionCode.SUCCESS;

@CrossOrigin
@Slf4j
@RestController
public class RecruitController {
    @Autowired
    RecruitService recruitService;

    @GetMapping("/users/{id}")   //사람 세부 정보 조회
    public ResponseEntity<RecruitResponse> getApplicant(@PathVariable Long id){
        Applicant applicant = recruitService.getApplicant(id);
        return new ResponseEntity<>(new RecruitResponse(SUCCESS, applicant), HttpStatus.OK);
    }


    @PostMapping("/users/apply")    //지원하기
    public ResponseEntity<RecruitResponse> apply(@RequestBody ApplicantDto form){
        Applicant applicant = recruitService.apply(form);
        ResponseEntity<Applicant> response = (applicant != null) ?
                ResponseEntity.status(HttpStatus.OK).build() :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

        return new ResponseEntity<>(new RecruitResponse(SUCCESS, response), HttpStatus.OK);

    }

    @GetMapping("/users")
    public ResponseEntity<RecruitListResponse> getApplicant() {
        List<Applicant> all = recruitService.getAll();
        return new ResponseEntity<>(new RecruitListResponse(SUCCESS, all), HttpStatus.OK);

    }

}
