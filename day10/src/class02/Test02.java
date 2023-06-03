package class02;

class Point {
	int x;
	int y;
	
	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	void printInfo() {
		System.out.println("x 좌표 : " + this.x + ", y 좌표 : " + this.y);
	}

	@Override
	public boolean equals(Object obj) {
		
		Point point = (Point)obj;
		
		if (this.x == point.x && this.y == point.y) {
			return true;
		}
		return false;
	}
}

class ColorPoint extends Point {
	String color;
	
	ColorPoint(int x, int y, String color) {
		super(x, y);
		this.color = color;
	}
	
	void printInfo() {
		System.out.println("x 좌표 : " + this.x + ", y 좌표 : " + this.y + ", 색깔 : " + this.color);
	}

	@Override
	public boolean equals(Object obj) {
		
		ColorPoint cp = (ColorPoint)obj;
		
		if (this.x == cp.x && this.y == cp.y && this.color.equals(cp.color)) {
			return true;
		}
		return false;
	}
	
	
}

public class Test02 {

	public static void main(String[] args) {
		
		Point[] data1 = new Point[3];
		data1[0] = new Point(10, 20);
		data1[1] = new Point(123, 20);
		data1[2] = new Point(10, 20);
		ColorPoint[] data2 = new ColorPoint[3]; 
		data2[0] = new ColorPoint(10, 20, "파랑");
		data2[1] = new ColorPoint(10, 20, "파랑");
		data2[2] = new ColorPoint(10, 20, "빨강");
		for (int i = 0; i < 3; i++) {
			data1[i].printInfo();
			data2[i].printInfo();
		}
		
		for (int i = 1; i < 3; i++) {
			if (data1[0].equals(data1[i])) {
				System.out.println("일치");
			} else {
				System.out.println("불일치");
			}
		}
		
		for (int i = 1; i < 3; i++) {
			if (data2[0].equals(data2[i])) {
				System.out.println("일치");
			} else {
				System.out.println("불일치");
			}
		}
	}
}
