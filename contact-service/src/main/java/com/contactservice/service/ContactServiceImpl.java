package com.contactservice.service;

import com.contactservice.entity.Contact;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class ContactServiceImpl implements ContactService{

    //fake list of contacts
    List<Contact> list = List.of(
            new Contact(1L,"Beast@gmail.com","Jack",13111L),
            new Contact(2L,"Yzee@gmail.com","ali",13111L),
            new Contact(3L,"Jacob@gmail.com","John",13011L),
            new Contact(4L,"Ab@gmail.com","John",13011L),
            new Contact(5L,"Adeli@gmail.com","John",13011L),
            new Contact(6L,"JFuast@gmail.com","John",13011L)
    );

    @Override
    public List<Contact> getUserContacts(Long userId) {
        return this.list.stream().filter(contact -> contact.getUserId().equals(userId)).collect(Collectors.toList());
    }
}
