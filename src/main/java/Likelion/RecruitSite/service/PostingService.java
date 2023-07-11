package Likelion.RecruitSite.service;

import Likelion.RecruitSite.dto.ExceptionCode;
import Likelion.RecruitSite.dto.PostingDto;
import Likelion.RecruitSite.dto.PostingDto.PostResponse;
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

@Service
@RequiredArgsConstructor
public class PostingService {

    private final PostingRepository postingRepository;
    private final RecruitRepository recruitRepository;

    public Object findAll() {
        List<Posting> postingList = postingRepository.findAll();
        return new PostingDto.PostInfoResponse(ExceptionCode.SUCCESS, postingList);
    }

    public Object findOne(int id) {
        Optional<Posting> posting = postingRepository.findById(id);
        if (posting.isEmpty()) {
            return new ResponseType(ExceptionCode.FIND_NOT_POSTING);
        }

        List<Applicant> applicants = recruitRepository.findAllByPostingId(posting.get().getId());
        return new PostResponse(ExceptionCode.SUCCESS, posting.get(), applicants);
    }

    public Object savePosting(PostingDto.PostDto postDto, MultipartFile file) {
        Posting posting = Posting.builder().info(postDto.getInfo())
                .jobGroup(postDto.getJob_group()).salary(postDto.getSalary())
                .name(postDto.getName()).personnel(postDto.getPersonnel())
                .build();
        postingRepository.save(posting);
        return new ResponseType(ExceptionCode.SUCCESS);
    }
}
