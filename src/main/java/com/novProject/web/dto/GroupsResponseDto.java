
package com.novProject.web.dto;

import com.novProject.domain.group.Groups;
import lombok.Getter;


@Getter
public class GroupsResponseDto {
    private Long id; //게시글 id
    private String name;
    private String leader;
    private String category;
    private String startDate;
    private String  endDate;
    private String stack;

    public GroupsResponseDto(Groups entity){ //엔티티 객체를 인자로 받아 DTO 객체로 변환하는 역할을 하는 생성자. 엔티티 객체에서 필요한 정보를 추출하여 DTO 객체의 필드에 설정함
        this.id = entity.getId();
        this.name = entity.getName();
        this.leader = entity.getLeader();
        this.category = entity.getCategory();
        this.startDate = entity.getStartDate();
        this.endDate = entity.getEndDate();
        this.stack = entity.getStack();

    }

}
