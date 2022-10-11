package co.edu.collect;

import java.util.LinkedList;
import java.util.Queue;

public class QueExample {
	public static void main(String[] args) {
		Queue<String> que = new LinkedList<>(); //LinkedList는 queue 인터페이스를 구현한 대표적인 클래스.
		//추가.
		que.offer("Hong");
		que.offer("Park");
		que.offer("Choi");
		
		while(!que.isEmpty()) { //값이 있는동안 계속 출력할게요
			System.out.println(que.poll()); //한개씩 가져올게요. pop이랑 같음. 하지만 먼저넣은게 먼저나옴! FIFO!
		}
	}
}
