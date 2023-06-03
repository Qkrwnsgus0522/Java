package class03;

abstract class Pokemon {
	private String name;
	private int win;
	
	Pokemon(String name) {
		this.name = name;
		this.win = 0;
	}
	
	abstract void hello();
	
	boolean game(Pokemon pokemon) {
		boolean flag = false;
		if (this.win == pokemon.win) {
			flag = true;
		} else if (this.win % 2 != 0 && pokemon.win % 2 != 0) {
			flag = this.win < pokemon.win ? true : false;
		} else if (this.win == 0 && pokemon.win % 2 == 0) {
			flag = this.win > pokemon.win ? true : false;
		} else {
			flag = this.win % 2 != 0 ? true : false;
		}
		if (flag == true) {
			System.out.println(this.name + " 이(가) 승리하였습니다.");
			this.setWin(this.win + 1);
			pokemon.hello();
		} else {
			System.out.println(pokemon.name + " 이(가) 승리하였습니다.");
			pokemon.setWin(pokemon.win + 1);
			this.hello();
		}
		return flag;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public int getWin() {
		return win;
	}
	
	public void setWin(int win) {
		this.win = win;
	}
	
	@Override
	public String toString() {
		return "name=" + name + ", win=" + win ;
	}
	
}

class Pika extends Pokemon {
	Pika(String name) {
		super(name);
	}
	
	@Override
	void hello() {
		System.out.println("피카피카ㅠㅠ");
	}
}

class Pyree extends Pokemon {
	Pyree(String name) {
		super(name);
	}
	
	@Override
	void hello() {
		System.out.println("파이파이ㅠㅠ");
	}
}

class Tle extends Pokemon {
	Tle(String name) {
		super(name);
	}
	
	@Override
	void hello() {
		System.out.println("꼬북꼬북ㅠㅠ");
	}
}

public class Test01 {

	public static void main(String[] args) {
		
		Pokemon[] pk = new Pokemon[3];
		pk[0] = new Pika("피카츄");
		pk[1] = new Pyree("파이리");
		pk[2] = new Tle("꼬부기");
		
		pk[0].game(pk[1]);
		pk[0].game(pk[2]);
		pk[1].game(pk[0]);
		pk[1].game(pk[2]);
		pk[2].game(pk[0]);
		pk[2].game(pk[1]);
		
		System.out.println(pk[0]);
		System.out.println(pk[1]);
		System.out.println(pk[2]);
	}

}
