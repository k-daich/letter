package jp.daich.letter.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import jp.daich.letter.spring.entity.request.RegistSentenceForm;
import jp.daich.util.StringUtil;

@Controller
@ResponseBody
public class RegistSentenceController {

    @Autowired
    RegistSentenceForm form;

    @RequestMapping(path = "/app/letter/regist", method = RequestMethod.POST)
    public ModelAndView execute(@ModelAttribute RegistSentenceForm form) {
        System.out.println("RegistSentenceController : start");
        System.out.println("form values : " + form.toString());

        // リクエストフォーム情報のチェック
        assertRequestForm(form);

        // レスポンスビューの生成
        ModelAndView mv = new ModelAndView();

        // テンプレートを指定
        mv.setViewName("letter/regist");

        // レスポンスビューにフォームを持たせる
        mv.addObject("requestForm", form);
        return mv;
    }

    /**
     * リクエストフォーム情報のチェック
     * 
     * @param form
     */
    private void assertRequestForm(RegistSentenceForm form) {
        required(form);

        assertLength(form.getTitle(), 0 , 16);
        assertLength(form.getSender(), 0 , 16);
        assertLength(form.getDestination(), 0 , 16);
    }

    /**
     * 必須チェック
     */
    private void required(RegistSentenceForm form) {
        if (StringUtil.isEmpty(form.getTitle())) throw new RuntimeException("Form必須エラー : title");
        if (StringUtil.isEmpty(form.getSender())) throw new RuntimeException("Form必須エラー : sender");
        if (StringUtil.isEmpty(form.getDestination())) throw new RuntimeException("Form必須エラー : destination");
    }

    /**
     * 長さチェック
     * @param str
     */
    private void assertLength(String str, int min , int max){
        if (str.length() < min ||
        str.length() > max) {
            throw new RuntimeException("Form長さエラー : " + str);
        }
    }
}