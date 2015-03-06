package com.github.cm.contacts.db;

import com.github.cm.contacts.Group;
import org.springframework.data.neo4j.repository.GraphRepository;

/**
 * Created by Ye Yan on 6/03/15.
 */
public interface GroupRepository extends GraphRepository<Group> {
}
