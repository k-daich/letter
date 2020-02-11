package jp.daich.letter.spring.entity;

import java.util.Map;

public class TPage {

    /**
     * Invalidate Constructor
     */
    private TPage() {
    }

    public static TPage build(final Map<String, Object> tblRow) {
        final TPage instance = new TPage();
        instance.setPage_id((String) tblRow.get("page_id"));
        instance.setFk_sentence_id((String) tblRow.get("fk_sentence_id"));
        instance.setPage_of_sentence((int) tblRow.get("page_of_sentence"));
        instance.setText((String) tblRow.get("text"));
        instance.setImage((String) tblRow.get("image"));
        instance.setForm_id((int) tblRow.get("form_id"));
        instance.setForm_type((int) tblRow.get("form_type"));
        return instance;
    }

    private String page_id;
    private String fk_sentence_id;
    private int page_of_sentence;
    private String text;
    private String image;
    private int form_id;
    private int form_type;

    public String getPage_id() {
        return page_id;
    }

    public int getForm_type() {
        return form_type;
    }

    public void setForm_type(final int form_type) {
        this.form_type = form_type;
    }

    public int getForm_id() {
        return form_id;
    }

    public void setForm_id(final int form_id) {
        this.form_id = form_id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(final String image) {
        this.image = image;
    }

    public String getText() {
        return text;
    }

    public void setText(final String text) {
        this.text = text;
    }

    public int getPage_of_sentence() {
        return page_of_sentence;
    }

    public void setPage_of_sentence(final int page_of_sentence) {
        this.page_of_sentence = page_of_sentence;
    }

    public String getFk_sentence_id() {
        return fk_sentence_id;
    }

    public void setFk_sentence_id(final String fk_sentence_id) {
        this.fk_sentence_id = fk_sentence_id;
    }

    public void setPage_id(final String page_id) {
        this.page_id = page_id;
    }
    
}