package entity;

/**
* Comments Package
* @author group5
* @version 1.1
*/
public class Comments {
	/**
	* 定义私有化成员变量，防止随意被修改.
	*/
	private String UUID;
	private String comments;
	private String blog;
	private String commentor;
	private String comdate;
	private String user_name;
	private String imagePath;
	
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
	* This method returns comment date.
	* @return comment date.
	*/
	public String getComdate() {
		return comdate;
	}
	/**
	* This method sets comment date.
	* @param comdate the String
	*/
	public void setComdate(String comdate) {
		this.comdate = comdate;
	}
	/**
	* This method returns comments content.
	* @return comments content.
	*/
	public String getComments() {
		return comments;
	}
	/**
	* This method sets comments content.
	* @param comments content.
	*/
	public void setComments(String comments) {
		this.comments = comments;
	}

	/**
	* This method returns comment author.
	* @return comment author.
	*/
	public String getCommentor() {
		return commentor;
	}
	/**
	* This method sets comment author.
	* @param commentor the String.
	*/
	public void setCommentor(String commentor) {
		this.commentor = commentor;
	}
	/**
	* This method returns comment's UUID.
	* @return UUID.
	*/
	public String getUUID() {
		return UUID;
	}
	/**
	* This method sets comment's UUID.
	* @param uUID the String
	*/
	public void setUUID(String uUID) {
		UUID = uUID;
	}
	/**
	* This method returns blog which it comments.
	* @return blog.
	*/
	public String getBlog() {
		return blog;
	}
	/**
	* This method sets blog which it comments.
	* @param blog.
	*/
	public void setBlog(String blog) {
		this.blog = blog;
	}	
}
