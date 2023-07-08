package Likelion.RecruitSite.controller;

import Likelion.RecruitSite.dto.PostingDto;
import Likelion.RecruitSite.service.PostingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RequestMapping("/companies")
@RequiredArgsConstructor
@RestController
public class CompanyController {

    private final PostingService postingService;

    // 공고 list 조회
    @GetMapping
    public ResponseEntity<Object> findAllPosting() {
        return new ResponseEntity<>(postingService.findAll(), HttpStatus.OK);
    }

    // 공고 작성
    @PostMapping("/posts")
    public ResponseEntity<Object> savePosting(
            @RequestPart(value = "post") PostingDto.PostDto postDto,
            @RequestPart(value = "file", required = false) MultipartFile file) {
        return new ResponseEntity<>(postingService.savePosting(postDto, file), HttpStatus.OK);
    }

    // 기업 세부 정보 조회
    @GetMapping("/{id}")
    public ResponseEntity<Object> findPostingInfo(@PathVariable int id) {
        return new ResponseEntity<>(postingService.findOne(id), HttpStatus.OK);
    }
}
