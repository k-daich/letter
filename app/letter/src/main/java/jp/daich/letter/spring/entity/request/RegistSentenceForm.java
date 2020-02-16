package jp.daich.letter.spring.entity.request;

import org.springframework.stereotype.Component;

@Component
public class RegistSentenceForm {

    private String sentence_id;
    private String title;
    private String sender;
    private String destination;

    public String toString() {
        return "[sentence_id : " + sentence_id
         + "][title : " + title
          + "][sender : " + sender
           + "][destination : " + destination
           + "]";
    }
   
    public String getSentence_id() {
        return sentence_id;
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

    public void setSentence_id(String sentence_id) {
        this.sentence_id = sentence_id;
    }

}