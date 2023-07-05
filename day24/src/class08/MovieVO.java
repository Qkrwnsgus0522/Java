package class08;

public class MovieVO {
	
	private int num;
	private String name;
	private String odate;
	
	public MovieVO(int num,String name,String odate) {
		this.num=num;
		this.name=name;
		this.odate=odate;
	}
	
	public int getNum() {
		return num;
	}
	
	public void setNum(int num) {
		this.num = num;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getOdate() {
		return odate;
	}
	
	public void setOdate(String odate) {
		this.odate = odate;
	}
	
	@Override
	public String toString() {
		return this.name+" ["+this.odate+"]";
	}
}
