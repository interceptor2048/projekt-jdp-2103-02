package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.Group;
import com.kodilla.ecommercee.dto.GroupDto;
import com.kodilla.ecommercee.exceptions.GroupNotFoundException;
import com.kodilla.ecommercee.mapper.GroupMapper;
import com.kodilla.ecommercee.repository.GroupRepository;
import com.kodilla.ecommercee.service.GroupDbService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/group")
public class GroupController {
    private final GroupMapper groupMapper;
    private final GroupDbService dbService;

    @GetMapping(value = "getGroups")
    public List<GroupDto> getGroups() {
        return groupMapper.mapToGroupDtoList(dbService.getAllGroups());
    }

    @GetMapping(value = "getGroup")
    public GroupDto getGroup(@RequestParam Long groupId) throws GroupNotFoundException {
        return groupMapper.mapToGroupDto(dbService.getGroupById(groupId).orElseThrow(GroupNotFoundException::new));
    }

    @PutMapping(value = "updateGroup", consumes = MediaType.APPLICATION_JSON_VALUE)
    public GroupDto updateGroup(@RequestBody GroupDto groupDto) {
        Group updatedGroup = groupMapper.mapToGroup(groupDto);
        Group saveGroup = dbService.save(updatedGroup);
        return groupMapper.mapToGroupDto(saveGroup);
    }

    @PostMapping(value = "createGroup", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createGroup(@RequestBody GroupDto groupDto) {
        dbService.save(groupMapper.mapToGroup(groupDto));
    }
}
