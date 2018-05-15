package api;

/**
 * Created by UdayN on 15-05-2018.
 */
public class LoginApi extends BaseApi{
	String username;
	String password;

	public LoginApi() {
		super("/users/login");
		addHeaders("Content-Type","application/json");
		addHeaders("X-Requested-With","XMLHttpRequest");
	}

	public void loginWith(String username,String password){
		addRequestBody("{\"user\":{\"email\":\""+username+"\", \"password\":\""+password+"\"}}");
	}

	public void hitRequest(){
		hitRequest(RequestType.POST);
	}
}
