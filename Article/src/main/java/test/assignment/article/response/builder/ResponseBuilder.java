package test.assignment.article.response.builder;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import static test.assignment.article.uitility.Utility.isNotNull;
import test.assignment.article.pojo.Article;
import test.assignment.article.pojo.Links;
import test.assignment.article.repository.HATEOASLinks;

/**
 * 
 * @author Maheswari Rajendran
 * @Date 12/10/2015 build response for all request
 *
 */
public class ResponseBuilder {

	private static ResponseBuilder instance = null;
	private HATEOASLinks links = null;

	public ResponseBuilder() {
		links = new HATEOASLinks();
	}

	/**
	 * Singleton Pattern was used to create an object only one time
	 * 
	 * @return
	 */
	public static ResponseBuilder getInstance() {
		if (instance == null)
			instance = new ResponseBuilder();
		return instance;
	}

	/**
	 * create response during an article creation
	 * 
	 * @param articleReq
	 * @return
	 */
	public Map<String, Object> createArticleResponse(Map<String, Object> articleReq) {
		System.out.println("******* ResponseBuilder - createArticleResponse() *******");

		ArrayList<Links> linkslist = new ArrayList<>();
		linkslist.add(links.getArticleIdLinks());
		linkslist.add(links.getAuthorLinks());
		linkslist.add(links.getKeywordLinks());
		linkslist.add(links.getPeriodLinks());

		Map<String, Object> response = new LinkedHashMap<String, Object>();
		response.put("message", "Article created successfully");
		response.put("Article", articleReq);
		response.put("links", linkslist);
		return response;
	}

	/**
	 * create a response to list an article
	 * 
	 * @param article
	 * @return
	 */
	public Map<String, Object> getArticleDetailByIDResponse(Article article) {
		System.out.println("******* ResponseBuilder - getArticleDetailByIDResponse() *******");

		ArrayList<Links> linkslist = new ArrayList<>();
		linkslist.add(links.getAuthorLinks());
		linkslist.add(links.getKeywordLinks());
		linkslist.add(links.getPeriodLinks());

		Map<String, Object> response = new LinkedHashMap<String, Object>();
		if (article != null) {

			response.put("Article", article);
			response.put("links", linkslist);

			return response;
		} else {
			response.put("Article", article);
			return response;
		}
	}

	/**
	 * create a response to list all articles for a given period
	 * 
	 * @param articles
	 * @return
	 */
	public Map<String, Object> getArticleDetailsByPeriod(Map<String, Object> articles) {
		System.out.println("******* ResponseBuilder - getArticleDetailsByPeriod() *******");

		ArrayList<Links> linkslist = new ArrayList<>();
		linkslist.add(links.getArticleIdLinks());
		linkslist.add(links.getAuthorLinks());
		linkslist.add(links.getKeywordLinks());

		Map<String, Object> response = new LinkedHashMap<String, Object>();
		if (isNotNull(articles)) {

			response.put("Article", articles);
			response.put("links", linkslist);

			return response;
		} else {
			response.put("Article", articles);
			return response;
		}
	}

	/**
	 * create a response to list all articles for a given author
	 * 
	 * @param article
	 * @return
	 */
	public Map<String, Object> getArticleDetailByAuthor(Map<String, Object> articles) {
		System.out.println("******* ResponseBuilder - getArticleDetailByAuthor() *******");

		ArrayList<Links> linkslist = new ArrayList<>();
		linkslist.add(links.getArticleIdLinks());
		linkslist.add(links.getKeywordLinks());
		linkslist.add(links.getPeriodLinks());

		Map<String, Object> response = new LinkedHashMap<String, Object>();
		if (isNotNull(articles)) {
			response.put("Article", articles);
			response.put("links", linkslist);
			return response;
		} else {
			response.put("Article", articles);
			return response;
		}
	}

	/**
	 * create a response find all articles for a specific keyword
	 * 
	 * @param articles
	 * @return
	 */
	public Map<String, Object> getArticleDetailByKeyword(Map<String, Object> articles) {
		System.out.println("******* ResponseBuilder - getArticleDetailByKeyword() *******");

		ArrayList<Links> linkslist = new ArrayList<>();
		linkslist.add(links.getArticleIdLinks());
		linkslist.add(links.getAuthorLinks());
		linkslist.add(links.getPeriodLinks());

		Map<String, Object> response = new LinkedHashMap<String, Object>();
		if (isNotNull(articles)) {
			response.put("Article", articles);
			response.put("links", linkslist);
			return response;
		} else {
			response.put("Article", articles);
			return response;
		}
	}

	/**
	 * create a response to update an article
	 * 
	 * @param article
	 * @return
	 */
	public Map<String, Object> updateArticleResponse(Article article) {
		System.out.println("******* ResponseBuilder - updateArticleResponse() *******");

		Map<String, Object> response = new LinkedHashMap<String, Object>();

		if (article != null) {
			response.put("message", "Article updated successfully");
			response.put("Article", article);

		} else {
			response.put("message", "Please give correct article values");
		}
		return response;

	}

	/**
	 * create a response to delete an article
	 * 
	 * @param article
	 * @return
	 */
	public Map<String, Object> deleteArticleResponse(String articleId) {
		System.out.println("******* ResponseBuilder - deleteArticleResponse() *******");

		Map<String, Object> response = new LinkedHashMap<String, Object>();

		if (articleId != null) {
			response.put("message", "Article " + articleId + " deleted successfully");

		} else {
			response.put("message", "Please give correct article values");
		}
		return response;
	}
}
