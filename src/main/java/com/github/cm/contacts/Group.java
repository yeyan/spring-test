package com.github.cm.contacts;

import org.springframework.data.neo4j.annotation.Fetch;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedTo;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by Ye Yan on 6/03/15.
 */
@NodeEntity
public class Group {

    @GraphId
    private Long id;
    private String name;

    @RelatedTo(type = "HAS_CONTACT")
    @Fetch
    private Set<Contact> contacts = new LinkedHashSet<Contact>();

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(Set<Contact> contacts) {
        this.contacts = contacts;
    }
}
