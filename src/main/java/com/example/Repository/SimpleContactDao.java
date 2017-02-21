package com.example.Repository;

import com.example.Model.Contact;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by jing on 2017/2/20.
 */
@Repository
public class SimpleContactDao implements ContactDao {


    @Override
    public List<Contact> getAll() {
        return null;
    }

    @Override
    public void save(Contact contact) {

    }
}
