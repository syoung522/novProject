package com.novProject.service.groups;

import com.novProject.domain.group.GroupsRepository;
import com.novProject.web.dto.GroupsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class GroupsService {

    private final GroupsRepository groupsRepository;

    @Transactional
    public Long save(GroupsSaveRequestDto requestDto){
        return groupsRepository.save(requestDto.toEntity()).getId();
    }
}
