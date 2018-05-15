package api;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

/**
 * Created by UdayN on 15-05-2018.
 */
public class BaseApi {
	String path;
	public enum RequestType{
		POST    ("post"),
		GET     ("get");
		private String _label;

		RequestType(String label) {
			_label = label;
		}

		public String toString() {
			return _label;
		}
	}
	RequestSpecification request = given();
	Response response;

	public void addHeaders(String headerName,String headerValue){
		request.header(headerName,headerValue);
	}

	public void addRequestBody(String jsonBody){
		request.body(jsonBody);
	}

	public BaseApi(String url){
		this.path =url;
	}

	public void hitRequest(RequestType type){
		switch (type){
			case POST:
				response = request.post("http://172.29.3.23:3000/api"+path);
				break;
			case GET:
				response = request.get("http://172.29.3.23:3000/api"+path);
				break;
		}
	}

	public String fetchValue(String path) {
		return response.body().jsonPath().getString(path);
	}
}
