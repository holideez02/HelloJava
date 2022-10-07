package co.edu.collect;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MapExample {
	public static void main(String[] args) {
		//저장할 수 있는것이 key, value 두개. key:Integer, val:String 두개의 제네릭이 선언되어야 함.
		Map<Integer, String> map = new HashMap<Integer, String>();
		
		//추가. 이번엔 put. 두개를 넣어준다!(키, 값). 키는 값을 읽어오기 위한것이기 때문에 동일한 키가 있으면 안된다
		map.put(100, "홍길동");
		map.put(200, "김기영");
		map.put(300, "박문식");
		map.put(300, "윤문식"); // 키 값이 동일하기 때문에 위에 박문식은 사라지고 윤문식만 남음.
		
		map.remove(300); //키 값을 넣어주면 삭제.
		
		System.out.println("컬렉션의 크기: " + map.size());
		
		System.out.println("Val: " + map.get(300)); //키값을 넣어주면 value를 반환
		
		// 반복자 생성.
		Set<Integer> keySet= map.keySet(); //키만 따로 모아가지고 새로운 set컬렉션에 저장.
		for(Integer key : keySet) {
			System.out.println("키: " + key + ", 값: " + map.get(key)); //값을 가지고 올때는 get(키)
		}
		
		Set<Entry<Integer, String>> entSet = map.entrySet(); //얘는 키와 값을 모두 합친 entry를 가지고와서 새로운 set 컬렉션에 담아줌. 같이 가지고 온다!
		//대신 키와 value의 타입도 미리 알려줘야해
		for(Entry<Integer, String> ent : entSet) { // entSet에 담겨있는만큼 빙글빙글 돌면서 찾아가지고 ent에 담아놓을게요 (타입은 Entry타입)
			System.out.println("키: " + ent.getKey() + ", 값: " + ent.getValue());
			
		}
	}
}
