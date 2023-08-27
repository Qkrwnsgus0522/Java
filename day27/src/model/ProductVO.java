package model;

public class ProductVO {
	private int num;
	private String name;
	private int cnt;
	private int price;
	// DB 테이블에는 없지만 개발 편의성때문에 JAVA VO에서 구현한 멤버변수
	private String tmp;
	private String tmpSearchCondition; // searchKeyword
	
	public ProductVO() {
		this(0, "", 0, 0);
	}
	public ProductVO(int num,String name,int cnt,int price) {
		this.num=num;
		this.name=name;
		this.cnt=cnt;
		this.price=price;
		this.tmpSearchCondition = "이름";
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
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	// 객체와 무관한 멤버변수
	
	public String getTmp() {
		return tmp;
	}
	public void setTmp(String tmp) {
		this.tmp = tmp;
	}
	public String getTmpSearchCondition() {
		return tmpSearchCondition;
	}
	public void setTmpSearchCondition(String tmpSearchCondition) {
		this.tmpSearchCondition = tmpSearchCondition;
	}
	@Override
	public String toString() {
		if (cnt <= 0) {
			return "품 절 상 품";
		}
		return num+"번 상품 "+name+" 재고 ["+cnt+"] 가격 ["+price+"]";
	}
}
