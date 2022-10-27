package co.edu.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.edu.board.BoardVO;
import co.edu.board.faqVO;
import co.edu.common.DAO;

public class faqDAO extends DAO{
	public List<faqVO> boardList(faqVO vo) { // 목록조회
		List<faqVO> list = new ArrayList<>();
		getConnect();
		String sql = "select * from faq_board " + "where 1 = 1" + " and title like '%'||?||'%' "
				+ " and content like '%'||?||'%' " + " and writer like '%'||?||'%' ";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getTitle());
			psmt.setString(2, vo.getContent());
			psmt.setString(3, vo.getWriter());

			rs = psmt.executeQuery();
			while (rs.next()) {
				faqVO faq = new faqVO();
				faq.setFaqNo(rs.getInt("faq_no"));
				faq.setTitle(rs.getString("title"));
				faq.setContent(rs.getString("content"));
				faq.setWriter(rs.getString("writer"));
				faq.setWriteDate(rs.getString("write_date"));
				faq.setClickCnt(rs.getInt("click_cnt"));
				faq.setImage(rs.getString("image"));

				list.add(faq);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}
	
	public List<faqVO> faqPageList(int page){ // 페이지 수를 적으면 그만큼만 갖고옴
		getConnect();
		List<faqVO> list = new ArrayList<>();
		String sql = "select b.* "//
				+ "from (select rownum rn, a.* "//
				+ "      from   (select * "//
				+ "              from faq_board "//
				+ "              order by faq_no desc) a  "//
				+ "      where rownum <= ? ) b "//
				+ "where b.rn >= ?";
		
		int from = (page - 1) * 10 + 1; //1, 11
		int to = (page * 10); //10, 20
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, to); //rownum
			psmt.setInt(2, from); //b.rn
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				faqVO faq = new faqVO();
				faq.setFaqNo(rs.getInt("faq_no"));
				faq.setTitle(rs.getString("title"));
				faq.setContent(rs.getString("content"));
				faq.setWriter(rs.getString("writer"));
				faq.setWriteDate(rs.getString("write_date"));
				faq.setClickCnt(rs.getInt("click_cnt"));
				faq.setImage(rs.getString("image"));
				
				list.add(faq);				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}
}
