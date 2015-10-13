package test.assignment;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import test.assignment.article.ArticleApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ArticleApplication.class)
public class ArticleApplicationTests {

	@Test
	public void contextLoads() {
	}

}
