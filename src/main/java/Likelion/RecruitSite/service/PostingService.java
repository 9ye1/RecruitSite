package Likelion.RecruitSite.service;

import Likelion.RecruitSite.dto.PostingDto;
import Likelion.RecruitSite.dto.PostingDto.PostResponse;
import Likelion.RecruitSite.entity.Posting;
import Likelion.RecruitSite.repository.PostingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

import static Likelion.RecruitSite.dto.ExceptionCode.FIND_NOT;
import static Likelion.RecruitSite.dto.ExceptionCode.SUCCESS;

@Service
@RequiredArgsConstructor
public class PostingService {

    private final PostingRepository postingRepository;
    private final FileService fileService;

    public Object findAll() {
        List<Posting> postingList = postingRepository.findAll();
        return new PostingDto.PostInfoResponse(SUCCESS, postingList);
    }

    public Object findOne(int id) {
        Posting postingList = postingRepository.findById(id)
                .orElseThrow(
                () -> {
                    throw new PostingDto.NoResponse(FIND_NOT);
                }
        );

        return new PostResponse(SUCCESS, postingList);
    }

    public Object savePosting(PostingDto.PostDto postDto, MultipartFile file) {
        Posting posting = Posting.builder().info(postDto.getInfo())
                .jobGroup(postDto.getJob_group()).salary(postDto.getSalary())
                .name(postDto.getName()).personnel(postDto.getPersonnel())
                .build();
        postingRepository.save(posting);

        posting.setImageUrl(fileService.saveFile(posting.getId(), file));
        postingRepository.save(posting);
        return new PostingDto.NoResponse(SUCCESS);
    }
}
