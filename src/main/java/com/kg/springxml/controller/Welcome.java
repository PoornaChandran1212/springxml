package com.kg.springxml.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
// import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Welcome
 */
@Controller
@RequestMapping("/")
public class Welcome {
    @Autowired
    private Customer customer;
    ArrayList<Object> list1 = new ArrayList<Object>();
    String list2;
    public Welcome() throws SQLException {
        list1 = MysqlConnect.getDbCon().resultSetToArrayList("select * from contacts ");
        Gson gson = new Gson();
         list2 = gson.toJson(list1);
        System.out.println("DB values" + list1);

    }

    @RequestMapping("/name")
    public String name(ModelMap map) {

        customer.getscopes();
        String result = customer.getCustomerName();
        customer.setCustomerName("Adam", "Johnson");
        return "init Data: " + result + "|-----| modified Data: " + customer.getCustomerName();
    }

    @GetMapping
    public String volts1(Model mod2) {
        // mod2.addAttribute("list", mod2);
        System.out.println("Main db mod2" + mod2);
        return "index";
    }


    @ModelAttribute
    public void volts(Model mod1) {
        mod1.addAttribute("list", list1);
        System.out.println("Modal attribute mod1" + mod1);
        // return "index";
    }

    @RequestMapping("/namecheck")
    public String namecheck() {
        return "check Data: " + customer.getCustomerName();
    }

    @RequestMapping("/language")
    public String language() {
        String result = customer.getCustomerLanguage();
        // customer.setCustomerLanguage("French") //this command creates new instance of
        // Language
        return "init Data: " + result + "|-----| modified Data: " + customer.setCustomerLanguage("French");
    }

    @RequestMapping("/languagecheck")
    public String languagecheck() {
        return "check Data: " + customer.getCustomerLanguage();
    }

    @RequestMapping("/address")
    public String address() {
        String result = customer.getCustomerAddress();
        customer.setCustomerAddress("EU");
        return "init Data: " + result + "|-----| modified Data: " + customer.getCustomerAddress();
    }

    @RequestMapping("/addresscheck")
    public String addresscheck() {
        return "check Data: " + customer.getCustomerAddress();
    }

    @RequestMapping("/age")
    public String age() {
        String result = customer.getCustomerAge();
        customer.setCustomerAge("25");
        return "init Data: " + result + "|-----| modified Data: " + customer.getCustomerAge();
    }

    @RequestMapping("/agecheck")
    public String agecheck() {
        return "check Data: " + customer.getCustomerAge();
    }

    @RequestMapping("/phone")
    public String getApplicationScopeMessage() {
        String result = customer.getCustomerPhone();
        customer.setCustomerPhone("123456");
        return "init Data: " + result + "|-----| modified Data: " + customer.getCustomerPhone();

    }

    @RequestMapping("/phonecheck")
    public String phonecheck() {
        return "check Data: " + customer.getCustomerPhone();
    }

    // @RequestMapping("/country")
    // public String country() {
    // String result = customer.getCustomerCountry();
    // customer.setCustomerCountry("Switzerland");
    // return "init Data: " + result + "|-----| modified Data: " +
    // customer.getCustomerCountry();
    // }

    // @RequestMapping("/countrycheck")
    // public String countrycheck() {
    // return "check Data: " + customer.getCustomerCountry();
    // }
}