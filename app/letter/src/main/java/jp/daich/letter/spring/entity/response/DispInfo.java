package jp.daich.letter.spring.entity.response;

import java.io.Serializable;


/***
 * dispInfo
 *
 */
public class DispInfo implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = -29398226870834526L;

	/** 
	 * constructor for Test
	 */
	public DispInfo() {
		type = "test:type";
		image = "test:imgage";
		text = "test:text";
	}

	/** type */
	private String type;

	/** image */
	private String image;

	/** text */
	private String text;

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