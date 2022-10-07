package co.edu.collect;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class ListExample {
	public static void main(String[] args) {
		ArrayList<String> strs = new ArrayList<String>(); //만들어진 인스턴스 주소값을 strs에 담음.
		//추가.
		strs.add("홍길동");
		strs.add("김민식");
		strs.add("박유식");
		
		//삭제
		strs.remove(0); //인덱스값으로도 지우고
		strs.remove("박유식"); // 담긴 값으로도 지움
		
		strs.add(0,"최기분"); //첫번째위치(0)에 값 추가. 원래 첫번째에 있던건 한칸 뒤로 밀려남
		
		//크기 보기
		System.out.println("collect 크기: "+strs.size());
	
		for(String str : strs) {
			System.out.println(str);
		}
		
		for(int i=0; i<strs.size(); i++) {
			System.out.printf("%d번째의 값은 %s\n", i, strs.get(i));
		}
		//반복자를 생성.
		Iterator<String> itr = strs.iterator(); // 각각의 요소를 itr에 담겠습니다.
		while(itr.hasNext()) { //가져올 객체가 있으면 true.
			String result = itr.next(); //가지고 있는 녀석을 하나씩 꺼냄
			System.out.println(result);
		}
		
		// 100만건.
		ArrayList<Integer> inAry = new ArrayList<Integer>();
		long start = System.nanoTime(); //현재시점을 나노타임으로 설정
		for(int i=0; i<100000; i++) {
			inAry.add(i); //앞에 공간을 만들어주고 밀기 때문에 시간이 조금 더 걸림. 근데 끝에서부터 추가,삭제하면 arrayList가 더 빠름!
		}
		long end = System.nanoTime();
		System.out.println("ary: " + (end-start));
		
		LinkedList<Integer> lnAry = new LinkedList<Integer>();
		start = System.nanoTime(); //현재시점을 나노타임으로 설정
		for(int i=0; i<1000000; i++) {
			lnAry.add(i); //중간에 추가, 삭제하는 경우는 앞 뒤 링크끼리 연결하기 때문에 조금 더 빨리 처리가능
		}
		end = System.nanoTime();
		System.out.println("linked : " + (end-start));
		
	}
}
