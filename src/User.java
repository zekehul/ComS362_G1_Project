package src;

public class User implements UserObjectInterface {

	private String username;
	
	private String pwd;
	
	private int userType;
	
	//Returns true if the given password matches the one this object has stored
	@Override
	public boolean validate(String pwd) {
		return pwd.equals(this.pwd);
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public int getUserType() {
		return userType;
	}

	public void setUserType(int userType) {
		this.userType = userType;
	}

}
