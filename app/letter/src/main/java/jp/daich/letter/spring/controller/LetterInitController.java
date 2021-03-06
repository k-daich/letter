package jp.daich.letter.spring.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

    private Logger logger = LogManager.getLogger();

    @RequestMapping(path = "/app/letter", method = RequestMethod.GET)
    public ResponseEntity<LetterInfo> execute(@RequestParam("sentence_id") String sentence_id) {

        System.out.println("LetterInitController : start");
        logger.error("[LetterInitController-execute] : start");

        return ResponseEntity.ok(
                // LetterInfoの生成
                createLetterInfoProcedure.execute(sentence_id));
    }

}
