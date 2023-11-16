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

    @Builder
    public GroupsSaveRequestDto(String category, String startDate, String endDate, String name, String leader, String stack){
        this.category = category;
        this.startDate =startDate;
        this.endDate = endDate;
        this.name = name;
        this.leader = leader;
        this.stack = stack;
    }

    public Groups toEntity(){
        return Groups.builder()
                .category(category)
                .startDate(startDate)
                .endDate(endDate)
                .name(name)
                .leader(leader)
                .stack(stack)
                .build();
    }
}
