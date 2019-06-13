package entity;

/**
* Articles Package
* @author group5
* @version 1.1
*/
public class Articles {
	/**
	* 定义私有化成员变量，防止随意被修改.
	*/
	private String title;
	private String content;
	private String author;
	private String UUID;
	private String type;
	private String publishDate;
	private String modifyDate;
	private String sub;
	private String imagePath;
	private String viewNum;
	private String goodNum;
	
	/**
	* This method returns viewNum.
	* @return viewNum.
	*/
	public String getViewNum() {
		return viewNum;
	}
	/**
	* This method sets viewNum.
	* @param viewNum.
	*/
	public void setViewNum(String viewNum) {
		this.viewNum = viewNum;
	}
	/**
	* This method returns goodNum.
	* @return goodNum.
	*/
	public String getGoodNum() {
		return goodNum;
	}
	/**
	* This method sets goodNum.
	* @param goodNum.
	*/
	public void setGoodNum(String goodNum) {
		this.goodNum = goodNum;
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
	* This method returns sub content.
	* @return sub.
	*/
	public String getSub() {
		return sub;
	}
	/**
	* This method sets sub content.
	* @param sub.
	*/
	public void setSub(String sub) {
		this.sub = sub;
	}
	/**
	* This method returns type.
	* @return type.
	*/
	public String getType() {
		return type;
	}
	/**
	* This method sets type.
	* @param type.
	*/
	public void setType(String type) {
		this.type = type;
	}
	/**
	* This method returns publishDate.
	* @return publishDate.
	*/
	public String getPublishDate() {
		return publishDate;
	}
	/**
	* This method sets publishDate.
	* @param publishDate.
	*/
	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}
	/**
	* This method returns modifyDate.
	* @return modifyDate.
	*/
	public String getModifyDate() {
		return modifyDate;
	}
	/**
	* This method sets modifyDate.
	* @param modifyDate.
	*/
	public void setModifyDate(String modifyDate) {
		this.modifyDate = modifyDate;
	}
	/**
	* This method returns title.
	* @return title.
	*/
	public String getTitle() {
		return title;
	}
	/**
	* This method sets title.
	* @param title.
	*/
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	* This method returns content.
	* @return content.
	*/
	public String getContent() {
		return content;
	}
	/**
	* This method sets content.
	* @param content.
	*/
	public void setContent(String content) {
		this.content = content;
	}
	/**
	* This method returns author.
	* @return author.
	*/
	public String getAuthor() {
		return author;
	}
	/**
	* This method sets author.
	* @param author.
	*/
	public void setAuthor(String author) {
		this.author = author;
	}
	/**
	* This method returns article's UUID.
	* @return UUID.
	*/
	public String getUUID() {
		return UUID;
	}
	/**
	* This method sets article's UUID.
	* @param uUID the String
	*/
	public void setUUID(String uUID) {
		UUID = uUID;
	}	
}
