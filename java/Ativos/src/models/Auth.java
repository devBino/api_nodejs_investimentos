package models;

public class Auth {

	public boolean auth;
	public String token;
	
	@Override
	public String toString() {
		return "Auth{auth="+this.auth+", token="+this.token+"}";
	}
	
}
