package jp.daich.letter.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import jp.daich.letter.spring.entity.response.DispInfo;

@Controller
public class LetterInitController {

    @RequestMapping(path = "/letter", method = RequestMethod.POST)
    public DispInfo letterInit() {
        System.out.print("letterInit : start");
        return new DispInfo();
    }

}
