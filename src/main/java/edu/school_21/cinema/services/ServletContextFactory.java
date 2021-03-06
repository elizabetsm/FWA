package edu.school_21.cinema.services;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.web.context.ServletContextAware;

import javax.servlet.ServletContext;

public class ServletContextFactory implements FactoryBean<ServletContext>,
        ServletContextAware {

    private ServletContext servletContext;
    @Override
    public ServletContext getObject() throws Exception {
        return servletContext;
    }

    @Override
    public Class<?> getObjectType() {
        return ServletContext.class;
    }

    @Override
    public boolean isSingleton() {
        return FactoryBean.super.isSingleton();
    }

    @Override
    public void setServletContext(ServletContext servletContext) {
        this.servletContext = servletContext;
    }
}
