package jp.daich.letter.spring.entity.response;


/***
 * ほげテーブルEntity
 *
 */
@Entity(name="LetterSentence")
public class LetterSentence extends BaseEntity {
 
	/** key*/
	@Id
	private String key;
 
	/** タイトル */
	@Column(nullable = false)
	private String title;
 
	/** ほげ日時 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date hogeDatetime;
 
	/** ステータスID */
	private Integer statusid;
	
	/** リモートIPアドレス */
	// json出力の対象外とする
	@JsonIgnore
	private String ip;
 
	// Getter/Setter
 
 
}