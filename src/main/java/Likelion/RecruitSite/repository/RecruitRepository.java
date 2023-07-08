package Likelion.RecruitSite.repository;

import Likelion.RecruitSite.entity.Applicant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecruitRepository extends JpaRepository<Applicant, Long> {

    List<Applicant> findAll();
    List<Applicant> findAllByPostingId(Long postingId);

}
