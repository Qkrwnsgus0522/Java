package class03;

class Point {
	int x;
	int y;
	
	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	void printInfo() {
		System.out.println("(" + this.x + ", " + this.y + ")");
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
		System.out.println("(" + this.x + ", " + this.y + ", " + this.color + ")");
	}

	@Override
	public boolean equals(Object obj) {
		ColorPoint colorpoint = (ColorPoint)obj;
		if (this.x == colorpoint.x && this.y == colorpoint.y && this.color.equals(colorpoint.color)) {
			return true;
		}
		return false;
	}
}

public class Test01 {

	public static void main(String[] args) {
		
		Point[] data = new Point[3];
		data[0] = new Point(10, 30);
		data[1] = new Point(123, 30);
		data[2] = new Point(10, 30);
		ColorPoint[] data2 = new ColorPoint[3];
		data2[0] = new ColorPoint(10, 20, "파랑");
		data2[1] = new ColorPoint(10, 20, "파랑");
		data2[2] = new ColorPoint(10, 20, "빨강");
		
		for(int i = 1; i <= 2; i++) {
			if(data[0].equals(data[i])) {
				System.out.println("같아~");
			} else {
				System.out.println("달라~");
			}
		}
		
		for(int i = 1; i <= 2; i++) {
			if(data2[0].equals(data2[i])) {
				System.out.println("같아~");
			} else {
				System.out.println("달라~");
			}
		}

	}

}
