package com.github.cm.contacts;

import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.NodeEntity;

import java.util.List;

/**
 * Created by Ye Yan on 6/03/15.
 */

@NodeEntity
public class Contact {

    @GraphId
    private Long id;
    private String name;

    private List<String> email;
    private List<String> phone;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getEmail() {
        return email;
    }

    public void setEmail(List<String> email) {
        this.email = email;
    }

    public List<String> getPhone() {
        return phone;
    }

    public void setPhone(List<String> phone) {
        this.phone = phone;
    }
}
