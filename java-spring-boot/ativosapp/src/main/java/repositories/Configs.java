package repositories;

public class Configs {

	private static String baseUrl = "http://localhost:3000/";
	
	private Configs() {}
	
	public static String getBaseUrl() {
		return baseUrl;
	}
	
}
