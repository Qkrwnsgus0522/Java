package class04;

public class AirVO {
	private int num;
	private String airline;
	private String location;
	private String startTime;
	private String returnTime;
	private int price;
	private static int PK = 1000;
	
	public AirVO(String airline, String location, String startTime, String returnTime, int price) {
		this.num = PK++;
		this.airline = airline;
		this.location = location;
		this.startTime = startTime;
		this.returnTime = returnTime;
		this.price = price;
	}
	public AirVO(int num, String airline, String location, String startTime, String returnTime, int price) {
		this.num = num;
		this.airline = airline;
		this.location = location;
		this.startTime = startTime;
		this.returnTime = returnTime;
		this.price = price;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getAirline() {
		return airline;
	}
	public void setAirline(String airline) {
		this.airline = airline;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getReturnTime() {
		return returnTime;
	}
	public void setReturnTime(String returnTime) {
		this.returnTime = returnTime;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return num + ", airline=" + airline + ", location=" + location + ", startTime=" + startTime
				+ ", returnTime=" + returnTime + ", price=" + price + "]";
	}
	
}
