package co.edu.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ByteStreamExample {
	
	public static void main(String[] args) {
		try {
			fileCopy();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//byte 단위로 읽고 쓰기.
	public static void fileCopy() throws IOException { //위치에서 파일이 없을때 일어나는 오류

		FileInputStream fis = new FileInputStream("C:/Temp/origin.jpg"); // 이걸 읽어들이고
		FileOutputStream fos = new FileOutputStream("C:/Temp/copy.jpg"); //새로 이 파일을 출력할게요
		byte[] buf = new byte[100]; //이번엔 100바이트씩 읽고, 써보자!
		
		//시간 출력. 
		long start = System.currentTimeMillis();
		
		while(true) {
			int bytes = fis.read(buf); // 한바이트씩 읽기.
			
			if(bytes == -1) 
				break;
				
			fos.write(buf); //배열의 크기만큼 buf에 모아뒀다가 한번에 저장.
			
		}
		fos.close();
		fis.close();
		
		long end = System.currentTimeMillis();
		
		System.out.println(end - start);
		System.out.println("complete.");
	}
	
	public static void readBuf() throws IOException { //배열의 크기만큼 읽을게요!
		InputStream is = new FileInputStream("C:/Temp/data2.dat");
		byte[] buf = new byte[2];
		
		while(true) {
			int bytes = is.read(buf); //매개값으로 배열에 선언된 크기만큼 한번에 읽어들임. 여기서는 2씩!
			if(bytes == -1) {
				break; //읽어들일 값이 없으면 반복문 탈출
			}
			
			for(int i=0; i<bytes; i++) { 
				System.out.print(buf[i] + " "); //2씩 출력됨
			}
			System.out.println();
		}
		System.out.println("complete.");
		is.close();
		
	}
	
	public static void writeBuf() throws IOException { //배열의 크기만큼 써볼게요
		byte[] arr = new byte[] { 10, 20, 30 };
		OutputStream os = new FileOutputStream("C:/Temp/data2.dat"); //호출한데서 예외처리하도록 예외던짐
		os.write(arr); //배열의 크기 만큼 처리
		os.close();
		
		System.out.println("complete.");
	}
	
	public static void read() {
		
		try {
			InputStream is = new FileInputStream("C:/Temp/data1.dat");//값을 읽어들이기 위해!
			
			while(true) {
				int bytes = is.read(); //1 byte씩 읽어들임. 더이상 읽을 바이트가 없으면 -1 반환.
				if(bytes == -1) {
					break;
				}
				System.out.println(bytes);
			}
			
			is.close();
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		System.out.println("complete.");
	}
	
	public static void write() {
		//출력스트림(바이트기반)
				try {
					OutputStream os = new FileOutputStream("C:/Temp/data1.dat"); //예외처리 해주기. 그리고 temp파일도 미리 만들어놔
					//1바이트씩 쓰겠다 = write(byte b)
					byte a = 10;
					byte b = 20;
					
					os.write(a);
					os.write(b);
					
					//작성 다 끝나면 resource 반환.
					os.close();
					
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				System.out.println("complete");
	}
}
