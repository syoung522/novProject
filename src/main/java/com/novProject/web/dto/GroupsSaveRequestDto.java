package com.novProject.web.dto;

import com.novProject.domain.group.Groups;
import com.novProject.domain.stack.Stack;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class GroupsSaveRequestDto {
    private String category;
    private List<Stack> stack;
    private String startDate;
    private String endDate;
    private String name;
    private String leader;

    @Builder
    public GroupsSaveRequestDto(String category, List<Stack> stack, String startDate, String endDate, String name, String leader){
        this.category = category;
        this.stack = stack;
        this.startDate =startDate;
        this.endDate = endDate;
        this.name = name;
        this.leader = leader;
    }

    public Groups toEntity(){
        return Groups.builder()
                .category(category)
                .stack(stack)
                .startDate(startDate)
                .endDate(endDate)
                .name(name)
                .leader(leader)
                .build();
    }
}
