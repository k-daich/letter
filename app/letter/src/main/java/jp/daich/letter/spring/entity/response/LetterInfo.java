package jp.daich.letter.spring.entity.response;

import java.io.Serializable;

import org.springframework.stereotype.Component;

/***
 * LetterInfo
 *
 */
@Component
public class LetterInfo implements Serializable {

	/**	serialVersionUID */
	private static final long serialVersionUID = -29398226870834526L;

	/**
	 * constructor for Test
	 */
	public LetterInfo() {
		type = "test:type";
		image = "test:imgage";
		text = "test:text";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	/** type */
	private String type;

	/** image */
	private String image;

	/** text */
	private String text;

	/** id */
	private String id;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

}