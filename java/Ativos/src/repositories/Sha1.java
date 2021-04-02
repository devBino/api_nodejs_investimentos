package repositories;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Sha1 {

	private String param;
	
	public Sha1(String param) {
		this.param = param;
	}
	
	public String getHash() throws NoSuchAlgorithmException, UnsupportedEncodingException {
		
		String sha1 = "";
		
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-1");
			md.reset();
			md.update(param.getBytes("utf8"));
			sha1 = String.format("%040x", new BigInteger(1, md.digest()));
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return sha1;
	}
	
}
