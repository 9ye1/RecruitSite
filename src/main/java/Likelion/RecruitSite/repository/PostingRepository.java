package Likelion.RecruitSite.repository;

import Likelion.RecruitSite.entity.Posting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostingRepository extends JpaRepository<Posting, Long> {

    Posting save(Posting posting);
    List<Posting> findAll();
    Optional<Posting> findById(int id);
}
