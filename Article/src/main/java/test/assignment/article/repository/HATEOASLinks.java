package test.assignment.article.repository;

import test.assignment.article.pojo.Links;

/**
 * 
 * @author Masheswari Rajendran
 * @Date 12/10/2015 create HATEOAS links
 *
 */
public class HATEOASLinks {

	private Links links = null;

	/**
	 * create a link for getArticleById
	 * 
	 * @return
	 */
	public Links getArticleIdLinks() {
		links = new Links();
		links.setRel("self");
		links.setHref("v1/article/{articleId}");
		links.setType("Get a article using articleId");
		links.setParameter("articleId");
		links.setMethod("GET");
		return links;
	}

	/**
	 * create a link for getArtictleByAuthor
	 * 
	 * @return
	 */
	public Links getAuthorLinks() {
		links = new Links();
		links.setRel("self");
		links.setHref("v1/article/author/{authorName}");
		links.setParameter("author");
		links.setType("Get a list of articles by giving the authorName");
		links.setMethod("GET");
		return links;
	}

	/**
	 * create a link for getArtictleByKeyword
	 * 
	 * @return
	 */

	public Links getKeywordLinks() {
		links = new Links();
		links.setRel("self");
		links.setHref("v1/article/keyword/{keyword}");
		links.setType("Get a list of articles by giving the keyword");
		links.setParameter("keyword");
		links.setMethod("GET");
		return links;
	}

	/**
	 * create a link for getArtictleByPeriod
	 * 
	 * @return
	 */

	public Links getPeriodLinks() {
		links = new Links();
		links.setRel("self");
		links.setHref("v1/article?startDate={datevalue}&endDate={datevalue}");
		links.setType("Find a list of articles by giving the period");
		links.setParameter("startDate&endDate");
		links.setMethod("GET");
		return links;
	}
}
