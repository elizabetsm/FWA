package edu.school_21.cinema.repositories;

import edu.school_21.cinema.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;


@Component
public class UserDAO {

    private final JdbcTemplate jdbcTemplate;

//    public UserDAO(){}

    @Autowired
    public UserDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void createUser(String firstname, String lastname, String phoneNum, String pass){
        jdbcTemplate.update("insert into users(first_name, last_name, phone_number, password)" +
                "values(?, ?, ?,?)", firstname, lastname, phoneNum, pass);
    }

    public User readUser(String phoneNum){
        return jdbcTemplate.query("select * from users where phone_number=?",
                new UserMapper(), phoneNum).stream().findAny().orElse(null);
    }
}
