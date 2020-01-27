package jp.daich.letter.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TestJsonController {

    @RequestMapping(path = "/testJson", method = RequestMethod.GET)
    public String testJson() {
        System.out.print("testJson : start");
        return "test/testJson.html";
    }

}
