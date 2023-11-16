package com.novProject.domain.group;

import com.novProject.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class Groups extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "groups_id")
    private Long id;

    @Column(name = "groups_name", nullable = false)
    private String name;

    @Column(name = "groups_leader", nullable = false, length = 500)
    private String leader;

    @Column(name = "groups_category")
    private String category;

    @Column(name = "groups_start_date")
    private String startDate;

    @Column(name = "groups_end_date")
    private String endDate;

    @Column(name = "groups_stack")
    private String stack;
    @Column(name = "groups_headcount")
    private Long headcount;
    @Column(name = "groups_headcount_status")
    private Long headcountStatus;
    @Column(name = "groups_apply_status")
    private String applyStatus;
    @Column(name = "groups_applicants")
    private String applicants;


    @Builder //lombok
    public Groups(String name, String leader, String category, String startDate, String endDate, String stack, Long headcount, Long headcountStatus, String applyStatus, String applicants){
        this.name = name;
        this.leader = leader;
        this.category = category;
        this.startDate = startDate;
        this.endDate = endDate;
        this.stack = stack;
        this.headcount = headcount;
        this.headcountStatus = headcountStatus;
        this.applyStatus = applyStatus;
        this.applicants = applicants;
    }
}
