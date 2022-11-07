//싱글톤: 인스턴스가 단 하나만 있는것
package co.micol.prj.common;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DataSource { //싱글톤 클래스 기본형.
	private static SqlSessionFactory sqlSessionFactory; //mybatis 사용하기 때문에..
	//private static DataSource dataSource;
	
	private DataSource() {} //생성자를 다른곳에서 생성하지 못하도록 private로 설정.
	
	public static SqlSessionFactory getInstance()  {
		String resource = "config/mybatis-config.xml";
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			System.out.println("DB 연결성공!!!!!");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("DB 연결실패!!!!!"); //mybatis가 동작 안되는것.
		}
		return sqlSessionFactory;
	}
	
} 