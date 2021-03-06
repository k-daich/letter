package jp.daich.letter.spring.entity.response;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import jp.daich.letter.spring.model.db.entity.T_Page;
import jp.daich.letter.spring.model.db.entity.T_Sentence;

/***
 * LetterInfo
 *
 */
@Component
public class LetterInfo implements Serializable {

	/** serialVersionUID */
	private static final long serialVersionUID = -29398226870834526L;

	private String sentence_id;
	private String title;
	private String sender;
	private String destination;
	private Date create_date;
	private List<T_Page> tPageList;

	/**
	 * constructor for Test
	 */
	private LetterInfo() {
	}

	/**
	 * set T_Sentence values to LetterInfo
	 * 
	 * @param entity
	 */
	public void setTSentenceValues(T_Sentence entity) {
		setSentence_id(entity.getSentence_id());
		setTitle(entity.getTitle());
		setSentence_id(entity.getSentence_id());
		setSender(entity.getSender());
		setDestination(entity.getDestination());
		setCreate_date(entity.getCreate_date());
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

	public List<T_Page> gettPageList() {
		return tPageList;
	}

	public void settPageList(List<T_Page> tPageList) {
		this.tPageList = tPageList;
	}
}