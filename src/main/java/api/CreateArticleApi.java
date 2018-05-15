package api;

import java.util.List;

/**
 * Created by UdayN on 15-05-2018.
 */
public class CreateArticleApi extends BaseApi {
	String title;
	String description;
	String articleBody;
	List<String> taglist;
	public CreateArticleApi(String authToken) {
		super("/articles");
		addHeaders("Authorization","Token "+authToken);
		addHeaders("Content-Type","application/json");
		addHeaders("X-Requested-With","XMLHttpRequest");
	}

	public void createArticleFor(String title,String description,String articleBody){
		addRequestBody("{\"article\":{\"title\":\""+title+"\", \"description\":\""+description+"\", \"body\":\""+articleBody+"\", \"tagList\":[\"demo\",\"ddemo\"]}}");
		hitRequest(RequestType.POST);
	}

	public void createArticleFor(String json){
		addRequestBody(json);
		hitRequest(RequestType.POST);
	}
}
