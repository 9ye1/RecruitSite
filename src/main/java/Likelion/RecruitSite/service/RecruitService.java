package Likelion.RecruitSite.service;

import Likelion.RecruitSite.dto.ApplicantDto;
import Likelion.RecruitSite.dto.ExceptionCode;
import Likelion.RecruitSite.dto.ResponseType;
import Likelion.RecruitSite.entity.Applicant;
import Likelion.RecruitSite.entity.Posting;
import Likelion.RecruitSite.repository.PostingRepository;
import Likelion.RecruitSite.repository.RecruitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

import static Likelion.RecruitSite.dto.ExceptionCode.SUCCESS;

@RequiredArgsConstructor
@Service
public class RecruitService {

    private final RecruitRepository recruitRepository;
    private final PostingRepository postRepository;
    private final FileService fileService;

    public Object getApplicant(Long id) {
        Applicant applicant = recruitRepository.findById(id).orElse(null);
        if (applicant == null) {
            return new ResponseType(ExceptionCode.FIND_NOT_APPLICANT);
        }
        return new ApplicantDto.ApplicantResponse(ExceptionCode.SUCCESS, applicant);
    }

    @Transactional
    public Object saveApplicant(ApplicantDto.ApplicantRequest form, MultipartFile file) {
        Optional<Posting> post = postRepository.findById(form.getId());
        if (post.isEmpty()) {
            return new ResponseType(ExceptionCode.FIND_NOT_POSTING);
        }

        Applicant applicant = Applicant.builder()
                .dto(form)
                .posting(post.get())
                .build();
        recruitRepository.save(applicant);


        if (file != null) {
            applicant.setImage( fileService.saveFile(applicant.getId(), file, "applicant"));
        }
        return new ResponseType(ExceptionCode.SUCCESS);
    }

    public Object getAll() {
        List<Applicant> applicants = recruitRepository.findAll();
        System.out.println("applicants.size() = " + applicants.size());
        return new ApplicantDto.ApplicantsResponse(SUCCESS, applicants);
    }

}
