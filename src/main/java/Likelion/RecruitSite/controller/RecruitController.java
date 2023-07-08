package Likelion.RecruitSite.controller;

import Likelion.RecruitSite.dto.ApplicantDto;
import Likelion.RecruitSite.service.RecruitService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RequestMapping("/users")
@RequiredArgsConstructor
@RestController
public class RecruitController {

    private final RecruitService recruitService;

    @GetMapping("/{id}") // 사람 세부 정보 조회
    public ResponseEntity<Object> getApplicant(@PathVariable Long id){
        //return new ResponseEntity<>(id, HttpStatus.OK);
        return new ResponseEntity<>(recruitService.getApplicant(id), HttpStatus.OK);
    }

    @PostMapping("/apply") // 지원하기
    public ResponseEntity<Object> apply(
            @RequestPart(value = "applicant") ApplicantDto.ApplicantRequest form,
            @RequestPart(value = "file", required = false) MultipartFile file) {
        return new ResponseEntity<>(recruitService.saveApplicant(form, file), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Object> getApplicant() {
        //return new ResponseEntity<>("all", HttpStatus.OK);
        return new ResponseEntity<>(recruitService.getAll(), HttpStatus.OK);
    }

}
