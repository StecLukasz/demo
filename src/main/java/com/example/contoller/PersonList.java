package com.example.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PersonList {

    @RequestMapping(value = {"/personList"}, method = RequestMethod.GET)
    public String getPersonList() {
        return "persons/personList";
    }

    @RequestMapping(value = {"/addNewPerson"}, method = RequestMethod.GET)
    public String getAddNewPerson() {
        return "persons/addNewPerson";
    }

    @RequestMapping(value = {"/editPerson"}, method = RequestMethod.GET)
    public String getEditPerson() {
        return "persons/editPerson";
    }

}
