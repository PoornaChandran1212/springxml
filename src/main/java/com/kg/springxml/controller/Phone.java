package com.kg.springxml.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

@Scope(value = WebApplicationContext.SCOPE_APPLICATION, proxyMode = ScopedProxyMode.TARGET_CLASS)
@Component
public class Phone {
    private String phone = "245698";

    public Phone() {
        System.out.println("Create new Phone: " + this.phone);
    }

    public String getPhone() {
        return phone;
    }

    public String setPhone(String phone) {
        return this.phone = phone;
    }

}