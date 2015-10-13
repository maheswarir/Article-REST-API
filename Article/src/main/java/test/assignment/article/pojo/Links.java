package test.assignment.article.pojo;

/**
 * 
 * @author Maheswari Rajendran
 * @Date 12/10/2015 Bean class
 *
 */
public class Links {
	private String rel;
	private String href;
	private String type;

	private String parameter;
	private String method;

	public String getRel() {
		return rel;
	}

	public void setRel(String rel) {
		this.rel = rel;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getParameter() {
		return parameter;
	}

	public void setParameter(String parameter) {
		this.parameter = parameter;
	}

}
