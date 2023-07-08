package Likelion.RecruitSite.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Posting {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "info", length = 300)
    private String info;

    private String name;
    private String jobGroup; // 직군
    private int salary;
    private int personnel; // 인원

    private String image;

    @Builder
    public Posting(String info, String name, String jobGroup, int salary, int personnel) {
        this.info = info;
        this.name = name;
        this.jobGroup = jobGroup;
        this.salary = salary;
        this.personnel = personnel;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
