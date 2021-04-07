package com.kodilla.ecommercee.repository;

import com.kodilla.ecommercee.domain.Group;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import java.util.*;

@Transactional
@Repository
public interface GroupRepository extends CrudRepository<Group, Long> {
    @Override
    public List<Group> findAll();

    @Override
    public Optional<Group> findById(Long groupId);

    @Override
    public Group save(Group group);

    @Override
    public void deleteById(Long groupId);
}
