package co.edu.collect;

import java.util.Stack;

class Coin{
	private int val;
	public Coin(int val) {
		this.val = val;
	}
	public int getVal() {
		return val;
	}
}

public class StackExample {
	public static void main(String[] args) {
		Stack<Coin> coinBox = new Stack<>();
		//추가.
		coinBox.push(new Coin(100)); 
		coinBox.push(new Coin(60));
		coinBox.push(new Coin(80));
		
		//출력.
		while(!coinBox.isEmpty()) {//값이 있으면 false. 없으면 true! 있는동안은 계속 보여주는거지
			Coin coin = coinBox.pop(); //제일 마지막 인스턴스부터(넣은거부터) 꺼내요
			System.out.println(coin.getVal()); //80, 60, 100
		}
	}
}
