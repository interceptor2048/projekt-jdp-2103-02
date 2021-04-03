package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.GroupDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/v1/group")
public class GroupController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);

    @GetMapping(value = "getGroups")
    public List<GroupDto> getGroups() {
        LOGGER.info("Group list has been displayed");
        List<GroupDto> groupList = new ArrayList<>();

        GroupDto group1 = new GroupDto(1L, "Test group 1");
        GroupDto group2 = new GroupDto(2L, "Test group 2");

        groupList.add(group1);
        groupList.add(group2);

        return groupList;
    }

    @GetMapping(value = "getGroup")
    public GroupDto getGroup(Long groupId) {
        LOGGER.info("Group has been displayed");
        return new GroupDto(1L, "Test group 1");
    }

    @PutMapping(value = "updateGroup")
    public GroupDto updateGroup(GroupDto groupDto) {
        LOGGER.info("Group has been updated");
        return new GroupDto(1L, "Test update group 1");
    }

    @PostMapping(value = "createGroup")
    public void createGroup(GroupDto groupDto) {
        LOGGER.info("Group has been created");
    }
}
