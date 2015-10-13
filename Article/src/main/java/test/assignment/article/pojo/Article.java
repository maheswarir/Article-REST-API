package test.assignment.article.pojo;


/**
 * 
 * @author Maheswari Rajendran
 * @Date 12/10/2015 Bean class
 */
public class Article {

	private int id = 0;
	private String header;
	private String description;
	private String text;
	private String publishDate;

	private String author;
	private String keyword;
	private String hints;

	public Article() {

	}

	public Article(String author, String publishDate, String header, String description, String text, String keywords,
			String hints) {
		this.author = author;
		this.publishDate = publishDate;
		this.header = header;
		this.description = description;
		this.text = text;
		this.keyword = keywords;
		this.hints = hints;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getHints() {
		return hints;
	}

	public void setHints(String hints) {
		this.hints = hints;
	}
}
