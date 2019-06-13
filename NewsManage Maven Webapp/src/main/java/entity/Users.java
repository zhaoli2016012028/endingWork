package entity;

/**
* Users Package
* @author group5
* @version 1.1
*/
public class Users {
	/**
	* 定义私有化成员变量，防止随意被修改.
	*/
	private String user_name;
	private String password;
	private String grade;
	private String UUID;
	private String imagePath;
	private String email;//为了健壮性和可扩展性增加了该变量及对其存取的方法
	
	/**
	* This method returns email.
	* @return email.
	*/
	public String getEmail() {
		return email;
	}
	/**
	* This method sets email.
	* @param email.
	*/
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	* This method returns imagePath.
	* @return imagePath.
	*/
	public String getImagePath() {
		return imagePath;
	}
	/**
	* This method sets imagePath.
	* @param imagePath.
	*/
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	/**
	* This method returns user's grade.
	* @return grade.
	*/
	public String getGrade() {
		return grade;
	}
	/**
	* This method sets user's grade.
	* @param grade.
	*/
	public void setGrade(String grade) {
		this.grade = grade;
	}
	/**
	* This method returns user's UUID.
	* @return UUID.
	*/
	public String getUUID() {
		return UUID;
	}
	/**
	* This method sets user's UUID.
	* @param uUID the String
	*/
	public void setUUID(String uUID) {
		UUID = uUID;
	}
	/**
	* This method returns user_name.
	* @return user_name.
	*/
	public String getUser_name() {
		return user_name;
	}
	/**
	* This method sets user_name.
	* @param user_name.
	*/
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	/**
	* This method returns user's password.
	* @return password.
	*/
	public String getPassword() {
		return password;
	}
	/**
	* This method sets user's password.
	* @param password.
	*/
	public void setPassword(String password) {
		this.password = password;
	}
}
