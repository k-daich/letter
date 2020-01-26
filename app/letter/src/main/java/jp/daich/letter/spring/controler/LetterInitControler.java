package jp.daich.letter.spring.controler;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import jp.daich.letter.spring.entity.response.LetterSentence;

@Controller
public class LetterInitControler {

    @RequestMapping(path = "/letter", method = RequestMethod.GET)
    public ResponseEntity<LetterSentence> letterInit() {

        return ResponseEntity.ok(new LetterSentence());
    }

}
