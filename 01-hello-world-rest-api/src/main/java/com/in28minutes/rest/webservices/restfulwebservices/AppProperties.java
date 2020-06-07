package com.in28minutes.rest.webservices.restfulwebservices;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

// By default, Spring boot it loads property from application.properties, we can use @PropertySource to load other .properties files.
//@PropertySource("classpath:custom.properties")
@Component
@ConfigurationProperties("app")
public class AppProperties {

    private List<Menu> menus = new ArrayList<>();

    
    public List<Menu> getMenus() {
        return menus;
    }

    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }

   
}
