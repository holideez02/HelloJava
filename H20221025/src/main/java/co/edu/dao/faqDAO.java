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
}
