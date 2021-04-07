package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.domain.Group;
import com.kodilla.ecommercee.repository.GroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.*;

@RequiredArgsConstructor
@Service
public class GroupDbService {
    private final GroupRepository repository;

    public List<Group> getAllGroups() {
        return repository.findAll();
    }

    public Optional<Group> getGroupById(final Long groupId) {
        return repository.findById(groupId);
    }

    public Group save(final Group group) {
        return repository.save(group);
    }

    public void deleteGroupById(final Long groupId) {
        repository.deleteById(groupId);
    }
}
