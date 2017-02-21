package com.example.Repository;

import com.example.Model.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by jing on 2017/2/20.
 */
@Repository
public class SimpleContactDao implements ContactDao {
    private JdbcTemplate jdbcTemplate;

//    @Autowired
    public SimpleContactDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Contact> getAll() {
        String sql = "select id, firstName, lastName, phoneNumber, emailAddress" +
                "from contacts order by lastName";
        return jdbcTemplate.query(sql, new ContactMapper());
    }

    @Override
    public void save(Contact contact) {
        String sql = "insert into contacts" +
                "(firstName, lastName, phoneNumber, emailAddress)" +
                "value(?, ?, ?, ?)";
        jdbcTemplate.update(sql, contact.getFirstName(), contact.getLastName(),
                contact.getPhoneNumber(), contact.getEmailAddress());

    }

    private class ContactMapper implements RowMapper<Contact> {

        @Override
        public Contact mapRow(ResultSet resultSet, int i) throws SQLException {
            Contact contact = new Contact();
            contact.setId(resultSet.getLong("id"));
            contact.setFirstName(resultSet.getString("firstName"));
            contact.setLastName(resultSet.getString("lastName"));
            contact.setPhoneNumber(resultSet.getString("phoneNumber"));
            contact.setEmailAddress(resultSet.getString("emailAddress"));
            return contact;
        }
    }
}
