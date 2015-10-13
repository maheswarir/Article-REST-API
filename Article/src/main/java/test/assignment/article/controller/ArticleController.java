package test.assignment.article.controller;

import java.text.ParseException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import test.assignment.article.pojo.Article;
import test.assignment.article.repository.ArticleRepository;
import test.assignment.article.response.builder.ResponseBuilder;

/**
 * 
 * @author Maheswari Rajendran
 * @Date 12/10/2015 This class handles the request, process the message based on
 *       request and build response
 *
 */
@RestController
@RequestMapping("/v1/article")
public class ArticleController {

	private ArticleRepository repository;
	private ResponseBuilder response;

	public ArticleController() {
		// TODO Auto-generated constructor stub
		repository = ArticleRepository.getInstance();
		response = ResponseBuilder.getInstance();
	}

	/**
	 * The following method is used to create a new article
	 * 
	 * @param articleReq
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	public @ResponseBody Map<String, Object> createArticle(@RequestBody Map<String, Object> articleReq,
			HttpServletRequest request) {

		Article article = new Article(articleReq.get("author").toString(), articleReq.get("publishDate").toString(),
				articleReq.get("header").toString(), articleReq.get("description").toString(),
				articleReq.get("text").toString(), articleReq.get("keyword").toString(),
				articleReq.get("hints").toString());
		repository.addArticle(article);

		return response.createArticleResponse(articleReq);
	}

	/**
	 * display an article
	 * 
	 * @param articleId
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/{articleId}", produces = "application/json")
	public Map<String, Object> getArticleDetailByID(@PathVariable("articleId") String articleId) {
		System.out.println(repository.getArticles());

		return response.getArticleDetailByIDResponse(repository.getArticle(Integer.parseInt(articleId)));
	}

	/**
	 * list all articles for a given period
	 * 
	 * @param startDate
	 * @param endDate
	 * @return
	 * @throws ParseException
	 */
	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	public Map<String, Object> getArticleDetailsByPeriod(@RequestParam("startDate") String startDate,
			@RequestParam("endDate") String endDate) throws ParseException {

		return response.getArticleDetailsByPeriod(repository.listArticleByPeriod(startDate, endDate));

	}

	/**
	 * list all articles for a given author
	 * 
	 * @param name
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, value = "author/{name}", produces = "application/json")
	public Map<String, Object> getArticleDetailByAuthor(@PathVariable("name") String name) {
		System.out.println(repository.getArticles());

		return response.getArticleDetailByAuthor(repository.listByAuthor(name));
	}

	/**
	 * find all articles for a specific keyword
	 * 
	 * @param name
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, value = "keyword/{name}", produces = "application/json")
	public Map<String, Object> getArticleDetailByKeyword(@PathVariable("name") String name) {
		System.out.println(repository.getArticles());

		return response.getArticleDetailByKeyword(repository.listByKeyword(name));
	}

	/**
	 * update an article
	 * 
	 * @param articleReq
	 * @return
	 */
	@RequestMapping(method = RequestMethod.PUT, value = "/{articleId}", produces = "application/json", consumes = "application/json")
	public Map<String, Object> updateArticle(@RequestBody Article articleReq) {

		Article article = repository.updateArticle(articleReq);
		return response.updateArticleResponse(article);
	}

	/**
	 * delete an article
	 * 
	 * @param articleId
	 * @return
	 */

	@RequestMapping(method = RequestMethod.DELETE, value = "/{articleId}", produces = "application/json")
	public Map<String, Object> deleteArticle(@PathVariable("articleId") String articleId) {

		articleId = repository.deleteArticle(articleId);
		return response.deleteArticleResponse(articleId);
	}
}
