package com.novProject.web;

import com.novProject.domain.group.GroupsRepository;
import com.novProject.service.groups.GroupsService;
import com.novProject.web.dto.GroupsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class GroupsApiController {
    private GroupsService groupsService;

    @PostMapping("/api/v1/groups") //등록
    public Long save(@RequestBody GroupsSaveRequestDto requestDto){
        return groupsService.save(requestDto);
    }
}
