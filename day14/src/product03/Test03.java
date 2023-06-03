package product03;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

class Product {
	private int num; // PK
	private String name; // 이름
	private int price; // 가격
	private int cnt; // 재고
	
	Product(int num, String name, int price, int cnt) { // 상품 추가
		this.num = num;
		this.name = name;
		this.price = price;
		this.cnt = cnt;
		System.out.println("[" + this.name + "] 상품이 추가되었습니다.");
	}

	void sell(int cnt) { // 상품 구매
		this.cnt -= cnt;
		System.out.println("\n[" + this.name + "] X [" + cnt + "개] 총가격 : " + this.price * cnt + "원");
		System.out.println("구매완료되었습니다.");
	}
	
	void editCnt(int cnt, boolean flag) { // 상품재고 변경
		if (flag) {
			this.cnt += cnt;
			System.out.println("\n[" + this.name + "] 재고가 [" + cnt + "개] 추가되었습니다.");			
		} else {
			this.cnt -= cnt;
			System.out.println("\n[" + this.name + "] 재고가 [" + cnt + "개] 감소되었습니다.");	
		}
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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

	@Override
	public String toString() { // 상품 정보
		if (this.cnt == 0) { // 재고가 0개이면
			return " [" + this.num + "] | [ " + this.name + " ] [ " + this.price + "원 ] [ 품절 ]";
		}
		return " [" + this.num + "] | [ " + this.name + " ] [ " + this.price + "원 ] [ " + this.cnt + "개 ]";
	}

}

public class Test03 {
	
	private static Scanner sc = new Scanner(System.in);

	public static int tryCatchInputMismatch() {
		try {
			printInputMsg();
			int action = sc.nextInt();
			return action;
		} catch (InputMismatchException e) {
			sc.nextLine();
			return -1;
		}
	}
	
	public static void printUserMenu() {
		String userMenu = "\n=============메뉴=============\n"
						+ "1. 상품목록출력\n"
						+ "2. 구매하기\n"
						+ "3. 프로그램종료\n"
						+ "=============================";
		System.out.println(userMenu);
	}
	
	public static void printAdminMenu() {
		String adminMenu = "\n===========관리메뉴============\n"
						 + "1. 상품추가\n"
						 + "2. 상품재고변경\n"
						 + "3. 상품삭제\n"
						 + "4. 관리자모드종료\n"
						 + "5. 프로그램종료\n"
						 + "=============================";
		System.out.println(adminMenu);
	}
	
	public static void printStartList() {
		String startList = "\n-상품번호-|-----------상품 목록---------------------";
		System.out.println(startList);
	}
	
	public static void printEndList() {
		String endList = "--------|--------------------------------------";
		System.out.println(endList);
	}
	
	public static void printInputMsg() {
		String line = "----------------------------";
		String input = "\n입력) ";
		System.out.print(line + input);
	}
	
	public static void printMoveMenuMsg() {
		String moveMenuMsg = "(메뉴로 돌아가려면 0을 입력해주세요)";
		System.out.println(moveMenuMsg);
	}
	
	public static void printReTryIntMsg() {
		String reTryIntMsg = "\n정수를 입력해주세요";
		System.out.println(reTryIntMsg);
	}
	
	public static void printReTryMsg() {
		String reTryMsg = "\n다시 입력해주세요";
		System.out.println(reTryMsg);
	}
	
	public static void printYesOrNoMsg() {
		String yesOrNoMsg = "YES (1) NO (2) ";
		System.out.println(yesOrNoMsg);
	}
	
	public static void printCheckInsertProduct(int num, String name, int price, int cnt) {
		String str = "\n============================"
				+ "\n상품번호 : " + num 
				+ "\n상품이름 : " + name 
				+ "\n상품가격 : " + price 
				+ "\n 재고   : " + cnt
				+ "\n============================"
				+ "\n상품을 추가하시겠습니까?";
		System.out.println(str);
	}
	
	public static void printCheckSell(ArrayList<Product> arrlist, int index, int cnt) {
		String str = "\n[" + arrlist.get(index).getName() + "] X [" + cnt + "개] 총가격 : " + (arrlist.get(index).getPrice() * cnt) + "원"
				   + "\n구매하시겠습니까?";
		System.out.println(str);
	}
	
	public static void printCheckInput(String value) {
		System.out.println("\n상품이름 [" + value + "] 이(가) 맞습니까?");			
	}
	
	public static void printCheckInput(int num, int value) {
		if (num == 1) {
			System.out.println("\n상품가격 [" + value + "원] 이(가) 맞습니까?");			
		} else if (num == 2) {
			System.out.println("\n상품재고 [" + value + "개] 이(가) 맞습니까?");			
		}
		
	}
	
	public static void printRemoveMsg(int num, String name) {
		System.out.println("\n[" + num + "] [" + name + "] 상품이 삭제되었습니다.");
	}

	public static void printEmptyMsg() {
		String isEmptyMsg = "\n존재하는 상품이 없습니다.";
		System.out.println(isEmptyMsg);
	}
	
	public static void printIsNotNumMsg(int num) {
		String isNotMsg = "\n" + num + "번은 존재하지 않는 상품번호입니다.";
		System.out.println(isNotMsg);
	}
	
	public static boolean isArrayEmpty(ArrayList<Product> arrlist) {
		if (arrlist.isEmpty()) {
			printEmptyMsg();
			return true;
		}
		return false;
	}
	
	public static List<Object> existsProduct(ArrayList<Product> arrlist, int num, boolean flag, int index) {
		for (Product product : arrlist) {
			if (product.getNum() == num) {
				flag = true;
				System.out.println("\n" + product);
				break;
			}
			index++;
		}
		return Arrays.asList(flag, index);
	}
	
	public static boolean isCheckAction() {
		boolean flag = false;
		while (true) {
			printYesOrNoMsg();
			printInputMsg();
			int action = sc.nextInt();
			if (action != 1 && action != 2) {
				printReTryMsg();
				continue;
			} else if (action == 1) {
				flag = true;
			}
			break;
		}
		return flag;
	}
	
	public static void printCheckEditCnt(ArrayList<Product> arrlist, int index, int cnt, boolean flag) {
		System.out.println("\n" + arrlist.get(index).getName() + "을(를) " + cnt + "개 " + (flag ? "증가" : "감소") + "시키시겠습니까?");
	}
	
	public static void sleepThread(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void saveFile(String path_START, String path_FILE, String path_END, ArrayList<Product> arrlist) {
		try {
			FileWriter fw = new FileWriter(path_START + path_FILE + path_END);
			int i = 0;
			while (i < arrlist.size()) {
				fw.write(arrlist.get(i).getNum() + "번 ");
				fw.write(arrlist.get(i).getName() + " ");
				fw.write(arrlist.get(i).getPrice() + "원 ");
				fw.write(arrlist.get(i).getCnt() + "개\n");
				i++;
			}
			fw.flush();
			fw.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		ArrayList<Product> data = new ArrayList<Product>();
		
		int action; // 입력할 메뉴 번호
		int pkNum = 1001; // 상품번호 101번부터 순서대로 부여
		int num = 0; // 상품 번호
		String name = ""; // 상품 이름
		int price = 0; // 상품 가격
		int cnt = 0; // 상품 재고
		int pIndex = 0; // 해당 상품인덱스
		boolean hasNum = false; // 상품 존재여부
		boolean flagNum = false; // 상품 번호 flag
		boolean flagName = false; // 상품 이름 flag
		boolean flagPrice = false; // 상품 가격 flag
		boolean flagCnt = false; // 상품 재고 flag
		boolean flagEditType = false; // 상품재고 변경방식 flag
		boolean flagEditCnt = false; // 상품재고 변경개수 flag
		boolean flagAddSub = false; // 상품재고 증가 감소 flag
		boolean flagExit = false; // 프로그램종료 flag
		boolean flagExe = false; // 실행 flag
		
		final String path_START = "D:\\PJH\\resource\\";
		final String path_FILE = "test";
		final String path_END = ".txt";
		
		data.add(new Product(pkNum++, "새우깡", 2500, 17));
		data.add(new Product(pkNum++, "감자깡", 3400, 43));
		data.add(new Product(pkNum++, "칙촉", 1700, 26));
		data.add(new Product(pkNum++, "빈츠", 2100, 12));
		data.add(new Product(pkNum++, "콜라", 3700, 0));
		
		while (true) {
			if (flagExit) {
				saveFile(path_START, path_FILE, path_END, data);
				System.out.println("\n프로그램을 종료합니다.");
				break;
			}
			sleepThread(1500);
			printUserMenu(); // 사용자메뉴 출력
			action = tryCatchInputMismatch();
			if (action == 1) { // 1번 입력시 상품목록출력
				if (isArrayEmpty(data)) { // 생성된 상품여부 확인
					continue;
				}
				printStartList();
				for (Product product : data) { // 상품 목록 출력
					System.out.println(product);
				}
				printEndList();
			} else if (action == 2) { // 2번 입력시 상품구매
				if (isArrayEmpty(data)) { // 생성된 상품여부 확인
					continue;
				}
				
				while (true) {
					hasNum = false;
					flagNum = false;
					pIndex = 0;
					System.out.println("\n구매하실 상품번호를 입력해주세요.");
					printMoveMenuMsg();
					num = tryCatchInputMismatch();
					if (num == 0) {
						break;
					} else if (num < 1) {
						printReTryMsg();
						continue;
					}
					List<Object> res = existsProduct(data, num, hasNum, pIndex);
					hasNum = (boolean)res.get(0);
					pIndex = (int)res.get(1);
					if (!hasNum) {
						printIsNotNumMsg(num);
						continue;
					}
					if (data.get(pIndex).getCnt() == 0) {
						System.out.println("\n품절된 상품입니다.");
						continue;
					}
					System.out.println("\n구매하실 상품이 맞습니까?");
					flagNum = isCheckAction();
					if (flagNum) {
						break;
					}
				}
				
				while (flagNum) {
					flagCnt = false;
					System.out.println("\n구매하실 상품수량을 입력해주세요.");
					printMoveMenuMsg();
					cnt = tryCatchInputMismatch();
					if (cnt == 0) {
						break;
					} else if (cnt < 1) {
						printReTryMsg();
						continue;
					} else if (cnt > data.get(pIndex).getCnt()) {
						System.out.println("\n구매수량이 재고보다 많습니다.");
						continue;
					}
					System.out.println("\n구매하실 수량이 [" + cnt + "개] 가 맞습니까?");
					flagCnt = isCheckAction();
					if (flagCnt) {
						break;
					}
				}
				
				if (flagNum && flagCnt) {
					flagExe = false;
					printCheckSell(data, pIndex, cnt);
					flagExe = isCheckAction();
				}
				
				if (flagExe) {
					data.get(pIndex).sell(cnt);
				}
				
			} else if (action == 1234) { // 1234 입력시 관리자메뉴로 이동
				System.out.println("\n관리자모드로 이동합니다.");
				while (true) {
					sleepThread(1500);
					printAdminMenu(); // 관리자메뉴 출력
					action = tryCatchInputMismatch();
					if (action == 1) { // 1번 입력시 상품추가
						
						while (true) {
							flagName = false;
							System.out.println("\n추가할 상품이름을 입력해주세요");
							printMoveMenuMsg();
							printInputMsg();
							name = sc.next(); // 상품 이름
							if (name.equals("0")) {
								break;
							}
							printCheckInput(name);
							flagName = isCheckAction();
							if (flagName) {
								break;
							}
						}
						
						while (flagName) {
							flagPrice = false;
							System.out.println("\n추가할 상품가격을 입력해주세요");
							printMoveMenuMsg();
							price = tryCatchInputMismatch(); // 상품 가격
							if (price == 0) {
								break;
							} else if (price < 1) {
								System.out.println("\n상품가격은 1원 이상 입력해주세요.");
								continue;
							}
							printCheckInput(1, price);
							flagPrice = isCheckAction();
							if (flagPrice) {
								break;
							}
						}
						
						while (flagPrice) {
							flagCnt = false;
							System.out.println("\n추가할 상품재고를 입력해주세요");
							printMoveMenuMsg();
							cnt = tryCatchInputMismatch(); // 상품 재고
							if (cnt == 0) {
								break;
							} else if (cnt < 1) {
								System.out.println("\n상품재고는 1개 이상 입력해주세요");
								continue;
							}
							printCheckInput(2, cnt);
							flagCnt = isCheckAction();
							if (flagCnt) {
								break;
							}
						}
						
						if (flagName && flagPrice && flagCnt) {
							flagExe = false;
							printCheckInsertProduct(pkNum, name, price, cnt);
							flagExe = isCheckAction();
						}
						
						if (flagExe) {
							data.add(new Product(pkNum++, name, price, cnt)); // 상품 생성시 pkNum 증가	
						}
					} else if (action == 2) { // 2번 입력시 상품재고변경
						if (isArrayEmpty(data)) {
							continue;
						}
						while (true) {
							hasNum = false;
							flagNum = false;
							pIndex = 0;
							System.out.println("\n재고를 변경할 상품 번호를 입력해주세요)");
							printMoveMenuMsg();
							num = tryCatchInputMismatch(); // 상품 번호
							if (num == 0) {
								break;
							} else if (num < 1) {
								printReTryMsg();
								continue;
							}
							List<Object> res = existsProduct(data, num, hasNum, pIndex);
							hasNum = (boolean)res.get(0);
							pIndex = (int)res.get(1);
							if (!hasNum) {
								printIsNotNumMsg(num);
								continue;
							}
							System.out.println("\n재고를 변경할 상품이 맞습니까?");
							flagNum = isCheckAction();
							if (flagNum) {
								break;
							}
						}
						
						while (flagNum) {
							flagEditType = false;
							flagAddSub = false;
							System.out.println("\n변경할 방식을 선택해주세요.");
							while (true) {
								System.out.println("재고추가 (1) 재고감소 (2)");
								action = tryCatchInputMismatch();
								if (action != 1 && action != 2) {
									printReTryMsg();
									continue;
								} else if (action == 1) {
									flagAddSub = true;
								} else {
									flagAddSub = false;
									if (data.get(pIndex).getCnt() == 0) {
										System.out.println("\n품절상품은 재고감소를 할 수 없습니다.");
										continue;
									}
								}
								flagEditType = true;
								break;
							}
							if (flagEditType) {
								break;
							}
						}
						
						while (flagEditType) {
							flagEditCnt = false;
							if (flagAddSub) {
								System.out.println("\n추가 수량을 입력해주세요");
							} else {
								System.out.println("\n감소 수량을 입력해주세요");
							}
							printMoveMenuMsg();
							cnt = tryCatchInputMismatch();
							if (cnt == 0) {
								break;
							} else if (cnt < 1) {
								System.out.println("\n1 이상 입력해주세요");
								continue;
							} else if (!flagAddSub && (data.get(pIndex).getCnt() - cnt < 0)) {
								System.out.println("\n감소시킬 수량이 현재재고보다 많습니다.");
								continue;
							}
							flagEditCnt = true;
							break;
						}
						
						if (flagNum && flagEditType && flagEditCnt) {
							flagExe = false;
							printCheckEditCnt(data, pIndex, cnt, flagAddSub);
							flagExe = isCheckAction();
						}
						
						if (flagExe) {
							data.get(pIndex).editCnt(cnt, flagAddSub);
							System.out.println(data.get(pIndex));
						}
						
					} else if (action == 3) { // 3번 입력시 상품삭제
						if (isArrayEmpty(data)) {
							continue;
						}
						while (true) {
							hasNum = false;
							flagNum = false;
							pIndex = 0;
							System.out.println("\n삭제할 상품 번호를 입력해주세요");
							printMoveMenuMsg();
							num = tryCatchInputMismatch(); // 상품 번호
							if (num == 0) {
								break;
							} else if (num < 1) {
								printReTryMsg();
								continue;
							}
							List<Object> res = existsProduct(data, num, hasNum, pIndex);
							hasNum = (boolean) res.get(0);
							pIndex = (int) res.get(1);
							if (!hasNum) {
								printIsNotNumMsg(num);
								continue;
							}
							System.out.println("\n삭제할 상품이 맞습니까?");
							flagNum = isCheckAction();
							if (flagNum) {
								break;
							}
						}
						
						while (flagNum) {
							flagExe = false;
							System.out.println("\n상품을 삭제하시겠습니까?");
							flagExe = isCheckAction();
							break;
						}
						
						if (flagNum && flagExe) {
							printRemoveMsg(data.get(pIndex).getNum(), data.get(pIndex).getName());
							data.remove(pIndex);
						}
						
					} else if (action == 4) { // 4번 입력시 관리자모드 종료
						System.out.println("\n사용자모드로 이동합니다.");
						break;
					} else if (action == 5) { // 5번 입력시 프로그램종료
						flagExit = true;
						break;
					} else if (action == -1) {
						printReTryIntMsg();
					} else {
						printReTryMsg();
					}
				}
			} else if (action == 3) { // 3번 입력시 프로그램종료
				flagExit = true;
			} else if (action == -1) {
				printReTryIntMsg();
			} else {
				printReTryMsg();
			}
		}
		
	}
	
}