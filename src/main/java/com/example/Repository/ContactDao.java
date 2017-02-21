package com.example.Repository;

import com.example.Model.Contact;

import java.util.List;

/**
 * Created by jing on 2017/2/20.
 */
public interface ContactDao {
    public List<Contact> getAll();

    public void save(Contact contact);

}
