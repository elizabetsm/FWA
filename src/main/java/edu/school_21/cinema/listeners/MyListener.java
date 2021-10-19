package edu.school_21.cinema.listeners;

import edu.school_21.cinema.config.SpringConfig;
import edu.school_21.cinema.repositories.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyListener implements ServletContextListener {


    public MyListener(){}

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public MyListener(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        sce.getServletContext().setAttribute("userDAO", UserDAO.getInstance(SpringConfig.jdbcTemplate()));
    }
}
