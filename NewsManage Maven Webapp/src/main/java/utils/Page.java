package utils;

/**
* The Page Count Class
* @author group5
* @version 1.1
*/
public class Page { //获取当前页数
	/**
	* 获取当前页数
	* @param current string
	* @param total string
	* @return integer.
	*/
	public int countPage(String current,String total) {
		int currentPage;
		if (current!=null&&!current.equals("")) {//若可以得到页数信息，则将其转化为int类型 
			//System.out.println("current:"+current);
			String current1=current.trim();
			currentPage=Integer.parseInt(current1);
			int totalPage=Integer.parseInt(total);
			if(currentPage>totalPage){ //进行页数合理性的判断与制约
				currentPage=totalPage;
			}
			if(currentPage<1){
				currentPage=1;
			}
		}
		else{
			currentPage=1; //若没有得到页数信息，则默认为第一页
		}	
		return currentPage;
	}
}
