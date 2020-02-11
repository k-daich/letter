package jp.daich.letter.spring.entity;

import java.util.Date;
import java.util.Map;

public class TSentence {

    private String sentence_id;
    private String title;
    private String sender;
    private String destination;
    private Date create_date;

    /**
     * Invalidate Constructor
     */
    private TSentence() {
    }

    public static TSentence build(Map<String, Object> entity) {
        TSentence instance = new TSentence();
        instance.setSentence_id((String) entity.get("sentence_id"));
        instance.setTitle((String) entity.get("title"));
        instance.setSender((String) entity.get("sender"));
        instance.setDestination((String) entity.get("destination"));
        instance.setCreate_date((Date) entity.get("create_date"));
        return instance;
    }

    public Date getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSentence_id() {
        return sentence_id;
    }

    public void setSentence_id(String sentence_id) {
        this.sentence_id = sentence_id;
    }

}