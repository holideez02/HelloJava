package co.test.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.test.vo.BookVO;

public class BookDAO extends DAO {

	public List<BookVO> bookList() { //목록
		List<BookVO> list = new ArrayList<>();
		conn();
		String sql = "select * from book_info order by book_code";
		String sql2 = "select create_bookcode from dual ";
		
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				BookVO vo = new BookVO();
				list.add(new BookVO(rs.getString("book_code"),
						rs.getString("book_title"),
						rs.getString("book_author"),
						rs.getString("book_press"),
						rs.getInt("book_price")
						));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return list;
	}

	public BookVO selectBook(String bookCode) { //한건 조회
		conn();
		String sql = "select * from book_info where book_code=? ";
		BookVO vo = new BookVO();
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1,bookCode);
			
			rs = psmt.executeQuery();
			if(rs.next()) {
				vo.setBookCode(rs.getString("book_code"));
				vo.setBookTitle(rs.getString("book_title"));
				vo.setBookAuthor(rs.getString("book_author"));
				vo.setBookPress(rs.getString("book_press"));
				vo.setBookPrice(rs.getInt("book_price"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return vo;
	}

	public BookVO insertBook(BookVO book) { //등록
		conn();
		String sql = "insert into book_info "
				+ "values(?, ?, ?, ?, ?) ";
		String sql2 = "select create_bookcode from dual ";
		
		try {
			//코드 얻어오는 쿼리
			psmt = conn.prepareStatement(sql2);
			rs = psmt.executeQuery();
			String nextSeq = null;
			if(rs.next()) {
				nextSeq = rs.getString(1);
			}
			
			//insert
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, nextSeq);
			psmt.setString(2, book.getBookTitle());
			psmt.setString(3, book.getBookAuthor());
			psmt.setString(4, book.getBookPress());
			psmt.setInt(5, book.getBookPrice());
			
			int r = psmt.executeUpdate();
			System.out.println(r+"건 입력.");
			if(r > 0) {
				book.setBookCode(nextSeq);
				return book;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return null;
	}

	public void updateBook(BookVO book) { //수정
		conn();
		
		String sql = "update book_info "
				+ "set book_title =?, "
				+ "book_author =?, "
				+ "book_press =?, "
				+ "book_price =? "
				+ "where book_code =? ";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, book.getBookTitle());
			psmt.setString(2, book.getBookAuthor());
			psmt.setString(3, book.getBookPress());
			psmt.setInt(4, book.getBookPrice());
			psmt.setString(5, book.getBookCode());
			
			int r = psmt.executeUpdate();
			System.out.println(r + "건 변경");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		
	}

	public boolean deleteBook(String bookCode) { //삭제
		conn();
		String sql = "delete from book_info where book_code = ? ";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, bookCode);
			
			int r = psmt.executeUpdate();
			System.out.println(r + "건 삭제");
			if(r>0)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconn();
		}
		return false;
		
	}
}
