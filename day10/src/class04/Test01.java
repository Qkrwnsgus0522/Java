package class04;

import java.util.Scanner;

class Point {
	String color;
	int x;
	int y;

	Point() {
		this(0, 0);
	}
	
	Point(int x, int y) {
		this.color = "점";
		this.x = x;
		this.y = y;
	}
	
	void move() {
		move(1, 1);
	}
	
	void move(int x) {
		move(x, x);
	}
	
	void move(int x, int y) {
		this.x += x;
		this.y += y;
	}
	
	void printInfo() {
		System.out.println(this.color + "(" + this.x + ", " + this.y + ")");
	}

	@Override
	public String toString() {
		
		return "점(" + this.x + ", " + this.y + ")";
	}
	
	
	
}

class ColorPoint extends Point {
	
	ColorPoint() {
		this("검정", 0, 0);
	}
	
	ColorPoint(int x, int y) {
		this("검정", x, y);
	}
	
	ColorPoint(String color, int x, int y) {
		super(x, y);
		this.color = color;
	}
	
	void changeColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
	
		return this.color + "(" + this.x + ", " + this.y + ")";
	}
}

public class Test01 {

	// INPUT : 점 2개를 받아서
	// OUTPUT : 출력하고 끝! void
	public static void addPoint(Point point1, Point point2) {
		Point resPoint = new Point();
		resPoint.x = point1.x + point2.x;
		resPoint.y = point1.y + point2.y;
		
		System.out.println(point1);
		System.out.println("더하기");
		System.out.println(point2);
		System.out.println("결과) " + resPoint);
	}
	
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		
		String menu = "===== 메뉴 =====\n"
					+ "1. 점 생성\n"
					+ "2. 점 목록 출력\n"
					+ "3. 점 1개 출력\n"
					+ "4. 점 이동\n"
					+ "5. 색 변경\n"
					+ "6. 점 합치기 (+)\n"
					+ "7. 프로그램 종료\n"
					+ "===============";
		final int N = 3;
		
		Point[] data = new Point[N];
		int dataCnt = 0;
		
		int action;
		int point;
		int x = 0;
		int y = 0;
		String color;
		boolean flag = false;
		boolean flagPoint = false;
		
		while (true) {
			System.out.println(menu);
			action = sc.nextInt();
			
			if (action == 7) {
				break;
			}
			else if (action == 1) {
				if (dataCnt >= N) {
					System.out.println("생성할 공간이 없습니다!");
					continue;
				}
				while (true) {
					System.out.println("색깔을 입력하시겠습니까?");
					System.out.println("yes) 1 no) 2");
					action = sc.nextInt();
					if (action == 2) {
						color = null;
						break;
					} else if (action == 1) {
						while (true) {
							System.out.println("색깔을 입력해주세요. ※입력하지 않으면 검정");
							sc.nextLine();
							color = sc.nextLine();
							System.out.println("'" + color + "' 이(가) 맞습니까?");
							while (true) {
								System.out.println("yes) 1 no) 2");
								action = sc.nextInt();
								if (action == 2) {
									System.out.println("색깔을 다시 입력해주세요\n");												
								} else if (action == 1) {
									flag = true;
								} else {
									System.out.println("잘못 입력하셨습니다.");
									continue;
								}
								break;
							}
							if (flag) {
								break;
							}
						}
					} else {
						System.out.println("잘못 입력하셨습니다.");
						continue;
					}
					break;
				}
				flag = false;
				
				while (true) {
					System.out.println("점을 입력하시겠습니까?");
					System.out.println("yes) 1 no) 2");
					action = sc.nextInt();
					if (action == 2) {
						flagPoint = true;
						break;
					} else if (action == 1) {
						while (true) {
							System.out.println("x 좌표를 입력해주세요.");
							x = sc.nextInt();
							System.out.println("'" + x + "' 이(가) 맞습니까?");
							while (true) {
								System.out.println("yes) 1 no) 2");
								action = sc.nextInt();
								if (action == 2) {
									System.out.println("x 좌표를 다시 입력해주세요\n");													
								} else if (action == 1) {
									flag = true;
								} else {
									System.out.println("잘못 입력하셨습니다.");
									continue;
								}
								break;
							}
							if (flag) {
								break;
							}
						}
						flag = false;
						
						while (true) {
							System.out.println("y 좌표를 입력해주세요.");
							y = sc.nextInt();
							System.out.println("'" + y + "' 이(가) 맞습니까?");
							while (true) {
								System.out.println("yes) 1 no) 2");
								action = sc.nextInt();
								if (action == 2) {
									System.out.println("y 좌표를 다시 입력해주세요\n");													
								} else if (action == 1) {
									flag = true;
								} else {
									System.out.println("잘못 입력하셨습니다.");
									continue;
								}
								break;
							}
							if (flag) {
								break;
							}
						}
						flag = false;
					} else {
						System.out.println("잘못 입력하셨습니다.");
						continue;
					}
					break;
				}
				
				if (flagPoint && color == null) {
					data[dataCnt++] = new Point();
				} else if (!flagPoint && color == null) {
					data[dataCnt++] = new Point(x, y);
				} else if (flagPoint && "".equals(color)) {
					data[dataCnt++] = new ColorPoint();
				} else if (!flagPoint && "".equals(color)) {
					data[dataCnt++] = new ColorPoint(x, y);
				} else {
					data[dataCnt++] = new ColorPoint(color, x, y);
				}
				
			} else if (action == 2) {
				if (dataCnt == 0) {
					System.out.println("생성된 점이 없습니다.");
					continue;
				}
				for (int i = 0; i < dataCnt; i++) {
					System.out.print(i + 1 + ") ");
					data[i].printInfo();
				}
			} else if (action == 3) {
				if (dataCnt == 0) {
					System.out.println("생성된 점이 없습니다.");
					continue;
				}
				while (true) {
					System.out.println("출력할 점 번호를 입력해주세요");
					action = sc.nextInt();
					if (action < 1 || action > dataCnt) {
						System.out.println("존재하지 않는 점 입니다. 다시 입력해주세요.");
						continue;
					}
					System.out.print(action + 1 + ") ");
					data[action - 1].printInfo();
				}
			} else if (action == 4) {
				while (true) {
					System.out.println("이동할 점을 입력해주세요.");
					point = sc.nextInt();
					if (point < 1 || point > dataCnt) {
						System.out.println("존재하지 않는 점 입니다. 다시 입력해주세요.");
						continue;
					}
					System.out.println("1칸씩이동) 1");
					System.out.println("1번이동) 2");
					System.out.println("x, y이동) 3");
					action = sc.nextInt();
					
					if (action == 3) {
						while (true) {
							System.out.println("x좌표를 이동할 값을 입력해주세요.");
							x = sc.nextInt();
							System.out.println("y좌표를 이동할 값을 입력해주세요.");
							y = sc.nextInt();
							System.out.println(x + " " + y + "가 맞습니까?");
							while (true) {
								action = sc.nextInt();
								System.out.println("yes) 1 no) 2");
								if (action == 2) {
									System.out.println("다시 입력해주세요\n");													
								} else if (action == 1) {
									flag = true;
								} else {
									System.out.println("잘못 입력하셨습니다.");
									continue;
								}
								break;
							}
							if (flag) {
								break;
							}
						}
						flag = false;
						
						data[point - 1].move(x, y);
						
					} else if (action == 2) {
						System.out.println("이동할 값을 입력해주세요.");
						x = sc.nextInt();
						data[point - 1].move(x);
					} else if (action == 1) {
						data[point - 1].move();
					} else {
						System.out.println("잘못 입력하셨습니다.");
						continue;
					}
					System.out.println(point + "번 점이 이동되었습니다.");
					break;
				}
			} else if (action == 5) {
				while (true) {
					System.out.println("색을 변경할 점을 입력해주세요.");
					point = sc.nextInt();
					if (point < 1 || point > dataCnt) {
						System.out.println("존재하지 않는 점 입니다. 다시 입력해주세요.");
						continue;
					}
					if (data[point - 1] instanceof ColorPoint) {
						System.out.println("색을 변경할 수 없는 점 입니다.");
						break;
					}
					System.out.println("변경할 색을 입력해주세요.");
					color = sc.next();
					System.out.println("'" + color + "' 이(가) 맞습니까?");
					while (true) {
						System.out.println("yes) 1 no) 2");
						action = sc.nextInt();
						if (action == 2) {
							System.out.println("다시 입력해주세요\n");													
						} else if (action == 1) {
							flag = true;
						} else {
							System.out.println("잘못 입력하셨습니다.");
							continue;
						}
						break;
					}
					ColorPoint colorpoint = (ColorPoint)data[point - 1];
					colorpoint.changeColor(color);
					System.out.println(point + "번 색이 " + color +"로 변경되었습니다.");
					if (flag) {
						break;
					}
				}
				flag = false;
			} else if (action == 6) {
				
			} else {
				System.out.println("잘못 입력하셨습니다.");
			}
		}
		
	}
}