package test.assignment.article.repository;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import test.assignment.article.pojo.Article;

import static test.assignment.article.uitility.Utility.isNotNull;

/**
 * 
 * @author Maheswari Rajendran
 * @Date 12/10/2015 It acts as a database to store articles information
 *       temporarily It also contains CRUD(create, read, update and delete)
 *       operation and list the article by searching
 */
public class ArticleRepository {

	private static ArticleRepository instance = null;

	/**
	 * Singleton Pattern was used to create an object only one time
	 * 
	 * @return
	 */
	public static ArticleRepository getInstance() {
		if (instance == null)
			instance = new ArticleRepository();
		return instance;
	}

	private static HashMap<Integer, Article> articles;
	private static Integer latestId = 0;

	private static Integer getNewId() {
		latestId = latestId + 1;
		return latestId;
	}

	/**
	 * intialize a variable
	 */
	private ArticleRepository() {
		latestId = 0;
		articles = new HashMap<Integer, Article>();
	};

	/**
	 * return list of articles
	 * 
	 * @return
	 */
	public Collection<Article> getArticles() {
		return articles.values();
	}

	/**
	 * return an article
	 */
	public Article getArticle(Integer id) {
		return articles.get(id);
	}

	/**
	 * update an article
	 * 
	 * @param articleReq
	 * @return
	 */
	public Article updateArticle(Article articleReq) {
		System.out.println("******* ArticleRepository - updateArticle() *******");

		int id = articleReq.getId();
		Article article = getArticle(id);

		if (article != null) {
			Article oldArticle = articles.get(article.getId());
			oldArticle.setAuthor(article.getAuthor());
			oldArticle.setDescription(article.getDescription());
			oldArticle.setHeader(article.getHeader());
			oldArticle.setHints(article.getHints());
			oldArticle.setKeyword(article.getKeyword());
			oldArticle.setPublishDate(article.getPublishDate());
			oldArticle.setText(article.getText());
			return oldArticle;
		} else {
			return null;
		}

	}

	/**
	 * create and save an article
	 * 
	 * @param article
	 * @return
	 */
	public Integer addArticle(Article article) {
		System.out.println("******* ArticleRepository - addArticle() *******");

		Integer newId = getNewId();
		article.setId(newId);
		articles.put(newId, article);
		return newId;
	}

	/**
	 * delete an article
	 * 
	 * @param articleId
	 * @return
	 */
	public String deleteArticle(String articleId) {
		System.out.println("******* ArticleRepository - deleteArticle() *******");

		int id = Integer.parseInt(articleId);
		Article article = getArticle(id);

		if (article != null) {
			articles.remove(article.getId());
			return articleId;
		} else {
			return null;
		}
	}

	/**
	 * list articles for a given author
	 * 
	 * @param author
	 * @return
	 */
	public Map<String, Object> listByAuthor(String author) {
		System.out.println("******* ArticleRepository - listByAuthor() *******");
		Map<String, Object> response = new LinkedHashMap<String, Object>();
		ArrayList<Article> list = new ArrayList<Article>();
		Iterator<Article> itr = getArticles().iterator();

		while (itr.hasNext()) {
			Article article = (Article) itr.next();
			String s = article.getAuthor().toLowerCase();
			int index = s.indexOf(author);
			if (index == -1) {
				response.put("message", "There is no article in the given author");
			} else {
				list.add(article);

			}
		}

		if (!list.isEmpty())
			response.put("Article", list);

		return response;
	}

	/**
	 * find articles for a specific keyword
	 * 
	 * @param keyword
	 * @return
	 */
	public Map<String, Object> listByKeyword(String keyword) {
		System.out.println("******* ArticleRepository - listByKeyword() *******");
		Map<String, Object> response = new LinkedHashMap<String, Object>();
		ArrayList<Article> list = new ArrayList<Article>();
		Iterator<Article> itr = getArticles().iterator();

		while (itr.hasNext()) {
			Article article = (Article) itr.next();
			String s = article.getKeyword().toLowerCase();
			int index = s.indexOf(keyword);
			if (index == -1) {
				response.put("message", "There is no article in the given keyword");
			} else {
				list.add(article);

			}
		}

		if (!list.isEmpty())
			response.put("Article", list);

		return response;
	}

	/**
	 * list articles for a given period
	 * 
	 * @param startDateReq
	 * @param endDateReq
	 * @return
	 * @throws ParseException
	 */
	public Map<String, Object> listArticleByPeriod(String startDateReq, String endDateReq) throws ParseException {
		System.out.println("******* ArticleRepository - listArticleByPeriod() *******");

		Map<String, Object> response = new LinkedHashMap<String, Object>();
		ArrayList<Article> list = new ArrayList<>();
		Date startDate = null;
		Date endDate = null;
		long startTime = 0l;
		long endTime = 0l;
		DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		if (isNotNull(startDateReq)) {
			startDate = (Date) formatter.parse(startDateReq);
			startTime = startDate.getTime();
		}
		if (isNotNull(endDateReq)) {
			endDate = (Date) formatter.parse(endDateReq);
			endTime = endDate.getTime();
		}
		Iterator<Article> itr = getArticles().iterator();
		while (itr.hasNext()) {
			Article article = (Article) itr.next();
			Date publishDate = (Date) formatter.parse(article.getPublishDate());
			long publishTime = publishDate.getTime();

			if (isNotNull(startDateReq) && isNotNull(endDateReq)) {
				if (publishTime >= startTime & publishTime <= endTime) {
					response.remove("message");
					list.add(article);

				} else {

					response.put("message", "There is no article in the given period");
				}
			} else if (isNotNull(startDateReq)) {

				if (publishTime == startTime) {

					list.add(article);
				} else {

					response.put("message", "There is no article in the given period");
				}
			} else {

				response.put("message", "Please enter valid value");
			}
		}

		if (!list.isEmpty())
			response.put("Article", list);

		return response;
	}

}
