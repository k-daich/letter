package jp.daich.letter.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import jp.daich.letter.spring.entity.response.LetterInfo;
import jp.daich.letter.spring.model.procedure.CreateLetterInfoProcedure;

@Controller
@ResponseBody
public class LetterInitController {

    @Autowired
    CreateLetterInfoProcedure createLetterInfoProcedure;

    @RequestMapping(path = "/letter", method = RequestMethod.GET)
    public ResponseEntity<LetterInfo> letterInit(@RequestParam("id") String id) {
        System.out.print("letterInit : start");

        return ResponseEntity.ok(
                // LetterInfoの生成
                createLetterInfoProcedure.create(id));
    }

}
