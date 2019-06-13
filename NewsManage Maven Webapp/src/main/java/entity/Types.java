package entity;

/**
* Types Package
* @author group5
* @version 1.1
*/
public class Types {
	/**
	* 定义私有化成员变量，防止随意被修改.
	*/
	private String UUID;
	private String type;
	
	/**
	* This method returns type's UUID.
	* @return UUID.
	*/
	public String getUUID() {
		return UUID;
	}
	/**
	* This method sets type's UUID.
	* @param uUID the String
	*/
	public void setUUID(String uUID) {
		UUID = uUID;
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
}
