package com.novProject.service.groups;

import com.novProject.domain.group.Groups;
import com.novProject.domain.group.GroupsRepository;
import com.novProject.domain.posts.Posts;
import com.novProject.web.dto.GroupsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class GroupsService {

    private final GroupsRepository groupsRepository;

    @Transactional
    public Long save(GroupsSaveRequestDto requestDto){
        return groupsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional(readOnly = true)
    public List<Groups> findAllDesc() {
        return groupsRepository.findAllDesc();
    }
}
