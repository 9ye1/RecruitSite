package Likelion.RecruitSite.repository;

import Likelion.RecruitSite.entity.Applicant;
import Likelion.RecruitSite.entity.Posting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ApplicantRepository extends JpaRepository<Applicant, Long> {

    List<Applicant> findAllById(Long postingId);
}
