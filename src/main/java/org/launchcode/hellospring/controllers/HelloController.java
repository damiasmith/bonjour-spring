package org.launchcode.hellospring.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HelloController {

    @RequestMapping(value = "")
    @ResponseBody
    public String index(HttpServletRequest request) {

        String name = request.getParameter("name");
        if (name == null) {
            name = "World";
        }

        return "Hello " + name;
    }

    @RequestMapping(value = "hello", method = RequestMethod.GET)
    @ResponseBody
    public String helloForm() {
        String html = "<form method='post'>" +
                "<input type='text' name='name' />" +
                "<select name='language' id='language-select'>" +
                "<option value='english'>English</option>" +
                "<option value='french'>French</option>" +
                "<option value='spanish'>Spanish</option>" +
                "<option value='italian'>Italian</option>" +
                "<option value='german'>German</option>" +
                "</select>" +
                "<input type='submit' value='Greet me!'/>" +
                "</form>";

        return html;
    }

//    @RequestMapping(value = "hello", method = RequestMethod.POST)
//    @ResponseBody
//    public String helloPost(HttpServletRequest request) {
//        String name = request.getParameter("name");
//        return "Hello " + name;
//
//    }

    @RequestMapping(value = "hello", method = RequestMethod.POST)
    @ResponseBody
    public String createMessage(HttpServletRequest request) {
        String name = request.getParameter("name");
        String language = request.getParameter("language");
        String greeting = "Hello";
        switch (language) {
            case "english":
                break;
            case "french":
                greeting = "Bonjour";
                break;
            case "spanish":
                greeting = "Hola";
                break;
            case "italian":
                greeting = "Ciao";
                break;
            case "german":
                greeting = "Hallo";
                break;

        }

        return "<h3 style=\"font-family:verdana; color:blue\">" + greeting + ", " + name + "!" + "</h3>";


    }

    @RequestMapping(value = "hello/{name}")
    @ResponseBody
    public String helloUrlSegment(@PathVariable String name) {

        return "Hello " + name;
    }

    @RequestMapping(value = "goodbye")
    public String goodbye() {
        return "redirect:/";
    }
}
