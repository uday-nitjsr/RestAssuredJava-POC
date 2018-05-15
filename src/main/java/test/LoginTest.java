package test;

import api.BaseApi;
import api.CreateArticleApi;
import api.LoginApi;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by UdayN on 15-05-2018.
 */
public class LoginTest {
	String authToken;
	LoginApi loginApi;

	@Test(priority = 1)
	public void verifyLogin(){
		loginApi = new LoginApi();
		loginApi.loginWith("jake@jake.jake","jakejake");
		loginApi.hitRequest();
		Assert.assertEquals(loginApi.fetchValue("user.token").isEmpty(),false);
		Assert.assertEquals(loginApi.fetchValue("user.username"),"johnjacob");
		Assert.assertEquals(loginApi.fetchValue("user.email"),"jake@jake.jake");
		authToken = loginApi.fetchValue("user.token");
	}

	@Test(priority = 2)
	public void verify(){
		String articleBody = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer ultricies lacus a iaculis" +
				" laoreet. Nullam imperdiet enim luctus, efficitur risus eget, lobortis nulla. Cras tristique est nisl," +
				" quis euismod neque vulputate a. Quisque ac maximus est. Phasellus faucibus lacus metus. Vestibulum " +
				"pharetra aliquet convallis. Vestibulum id iaculis arcu, ut tempor tellus. Integer venenatis venenatis " +
				"risus, non congue nisl pellentesque et. Vestibulum interdum ex quis maximus porta. Cras feugiat " +
				"placerat nisl. Nullam mollis vitae eros quis laoreet.";
		CreateArticleApi createArticleApi = new CreateArticleApi(authToken);
		createArticleApi.createArticleFor("Lorem ipsum","This article",articleBody);
		Assert.assertEquals(createArticleApi.fetchValue("article.slug").isEmpty(),false);
		Assert.assertEquals(createArticleApi.fetchValue("article.title"),"Lorem ipsum");
		Assert.assertEquals(createArticleApi.fetchValue("article.favorited"),"false");
		Assert.assertEquals(createArticleApi.fetchValue("article.author.username"),"johnjacob");
	}
}
