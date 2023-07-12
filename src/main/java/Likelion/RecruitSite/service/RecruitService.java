package Likelion.RecruitSite.service;

import Likelion.RecruitSite.dto.ApplicantDto;
import Likelion.RecruitSite.entity.Applicant;
import Likelion.RecruitSite.entity.Posting;
import Likelion.RecruitSite.repository.PostingRepository;
import Likelion.RecruitSite.repository.RecruitRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class RecruitService {

    @Autowired
    RecruitRepository recruitRepository;

    @Autowired
    PostingRepository postRepository;

    public Applicant getApplicant(Long id) {
        return recruitRepository.findById(id).orElse(null);
    }

    public Applicant apply(ApplicantDto form) {
        Optional<Posting> post = postRepository.findById(form.getCompany_id());
        log.info("getCompany 값:"+ post);
        Applicant applicant = form.toEntity(post.get());
        if (applicant.getId() != null) {
            return null;
        }
        return recruitRepository.save(applicant);


    }

    public List<Applicant> getAll() {
        return recruitRepository.findAll();
    }

/*    private final RecruitRepository recruitRepository;
    private final PostingRepository postRepository;

    public Object getApplicant(Long id) {
        Applicant applicant = recruitRepository.findById(id).orElse(null);
        if (applicant == null) {
            return new ResponseType(ExceptionCode.FIND_NOT_APPLICANT);
        }
        return new ApplicantDto.ApplicantResponse(ExceptionCode.SUCCESS, applicant);
    }

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

        return new ResponseType(ExceptionCode.SUCCESS);
    }

    public Object getAll() {
        List<Applicant> applicants = recruitRepository.findAll();
        System.out.println("applicants.size() = " + applicants.size());
        return new ApplicantDto.ApplicantsResponse(SUCCESS, applicants);
    }*/

}
