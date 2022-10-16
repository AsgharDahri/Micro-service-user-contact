package com.contactservice.service;

import com.contactservice.entity.Contact;

import java.util.List;

public interface ContactService {
    public List<Contact> getUserContacts(Long userId);
}
