package com.github.cm.web;

import com.github.cm.contacts.Contact;
import com.github.cm.contacts.Group;
import com.github.cm.contacts.db.ContactRepository;
import com.github.cm.contacts.db.GroupRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

/**
 * Created by Ye Yan on 6/03/15.
 */
@Controller
@RequestMapping("/api")
public class ContactsController {

    protected Logger logger = LoggerFactory.getLogger(this.getClass());
    protected Random rnd = new Random();

    @Autowired
    protected GroupRepository groupRepository;

    @Autowired
    protected ContactRepository contactRepository;

    private List<String> createTestPhone() {
        List<String> phones = new ArrayList<String>();

        for (int i = 0; i < rnd.nextInt(5); i++) {
            StringBuilder phone = new StringBuilder();

            for (int j = 0; j < 10; j++) {
                phone.append(rnd.nextInt(10));
            }

            phones.add(phone.toString());
        }

        return phones;
    }

    private List<String> createTestEmail() {
        List<String> emails = new ArrayList<String>();

        for (int i = 0; i < rnd.nextInt(5); i++) {
            emails.add(String.format("test%02d@gmail.com", rnd.nextInt(100)));
        }

        return emails;
    }

    private Contact createTestContact() {

        Contact contact = new Contact();
        contact.setName(String.format("Person %02d", rnd.nextInt(100)));
        contact.setPhone(createTestPhone());
        contact.setEmail(createTestEmail());

        return contact;
    }

    private Group createTestGroup() {
        Set<Contact> contacts = new HashSet<Contact>();

        for (int i = 0; i < rnd.nextInt(5); i++) {
            contacts.add(createTestContact());
        }

        Group group = new Group();
        group.setName(String.format("Group %02d", rnd.nextInt(100)));
        group.setContacts(contacts);

        return group;
    }

    @RequestMapping(value = "more")
    public
    @ResponseBody
    Group test() {
        Group group = createTestGroup();
        groupRepository.save(group);

        return group;
    }

    @RequestMapping(value = "group/{id}")
    public
    @ResponseBody
    Group listGroups(@PathVariable("id") Long id) {
        return groupRepository.findOne(id);
    }

}
