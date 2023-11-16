package com.novProject.web.dto;

import com.novProject.domain.group.Groups;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class GroupsSaveRequestDto {
    private String category;
    private String startDate;
    private String endDate;
    private String name;
    private String leader;
    private String stack;
    private Long headcount;
    private Long headcountStatus;
    private String applyStatus;
    private String applicants;

    @Builder
    public GroupsSaveRequestDto(String category, String startDate, String endDate, String name, String leader, String stack, Long headcount, Long headcountStatus, String applyStatus, String applicants){
        this.category = category;
        this.startDate =startDate;
        this.endDate = endDate;
        this.name = name;
        this.leader = leader;
        this.stack = stack;
        this.headcount = headcount;
        this.headcountStatus = headcountStatus;
        this.applyStatus = applyStatus;
        this.applicants = applicants;
    }

    public Groups toEntity(){
        return Groups.builder()
                .category(category)
                .startDate(startDate)
                .endDate(endDate)
                .name(name)
                .leader(leader)
                .stack(stack)
                .headcount(headcount)
                .headcountStatus(headcountStatus)
                .applyStatus(applyStatus)
                .applicants(applicants)
                .build();
    }
}
