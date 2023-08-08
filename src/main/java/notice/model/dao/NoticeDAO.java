package notice.model.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import notice.model.vo.Notice;

public class NoticeDAO {

	public int insertNotice(SqlSession session, Notice notice) {
		int result = session.insert("OneMemberMapper.insertNotice", notice);
		return result; 
	}
	
	public List<Notice> selectNoticeList(SqlSession session, int currentPage) {
		
		int limit = 10;
		int offset = (currentPage-1)*limit ;
		
		RowBounds rowBounds = new RowBounds(offset, limit);
		List<Notice> nList = session.selectList("OneMemberMapper.selectNoticeList", null, rowBounds);
		return nList; 
	}

	public String generatePageNavi(int currentPage) {
		int totalCount = 200;	
		int recordCountPerPage = 5;
		int naviTotalCount = 0;
		if(totalCount % recordCountPerPage > 0) {
			naviTotalCount = totalCount / recordCountPerPage + 1;
		} else {
			naviTotalCount = totalCount / recordCountPerPage;
		}
		int naviCountPerPage = 5;
		int startNavi = ((currentPage - 1)/naviCountPerPage) * naviCountPerPage + 1;
		int endNavi = startNavi + naviCountPerPage - 1;
		if(endNavi > naviTotalCount) {
			endNavi = naviTotalCount;
		}
		boolean needPrev = true;
		boolean needNext = true;
		if(startNavi == 1) {
			needPrev = false;
		}
		if(endNavi == naviTotalCount) {
			needNext = false;
		}
		StringBuilder result = new StringBuilder();
		if(needPrev) {
			result.append("<a href='/notice/list.do?currentPage="+(startNavi-1)+"'>[이전]</a>");
		}
		for(int i = startNavi; i <= endNavi; i++) {
			result.append("<a href='/notice/list.do?currentPage="+i+"'>"+i+"</a>&nbsp;");
		}
		if(needNext) {
			result.append("<a href='/notice/list.do?currentPage="+(endNavi+1)+"'>[다음]</a>");
		}
		return result.toString();
	}
	
	public Notice selectOneById(SqlSession session, int noticeNo) {
		Notice notice = session.selectOne("OneMemberMapper.selectOneByNo", noticeNo);
		return notice;
	}

	public int deleteNotice(SqlSession session, int noticeNo) {
		int result = session.delete("OneMemberMapper.deleteNotice", noticeNo);
		return result;
	}

	public int UpdateNotice(SqlSession session, int noticeNo) {
		int result = session.update("OneMemberMapper.updateNotice", noticeNo);
		return result;
	} 

//	public List<Notice> selectNoticeList(Connection conn, int currentPage) {
//		List<Notice> nList = new ArrayList<Notice>();
//		PreparedStatement pstmt = null;
//		int recordCountPerPage = 5;
//		int start = currentPage*recordCountPerPage-(recordCountPerPage -1);
//		int end = currentPage*recordCountPerPage;
//		ResultSet rset = null;
//		String qeury = "SELECT * FROM (SELECT ROW_NUMBER() OVER (ORDER BY NOTICE_NO DESC) ROW_NUM, NOTICE_TBL.* FROM NOTICE_TBL)WHERE ROW_NUM BETWEEN ? AND ?";
//		try {
//			pstmt = conn.prepareStatement(qeury);
//			pstmt.setInt(1, start);
//			pstmt.setInt(2, end);
//			rset = pstmt.executeQuery();
//			while(rset.next()) {
//				Notice notice = rsetToNotice(rset);
//				nList.add(notice);
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally {
//			try {
//				rset.close();
//				pstmt.close();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//		return nList;
//	}
//
//	private Notice rsetToNotice(ResultSet rset) throws SQLException {
//		Notice notice = new Notice();
//		notice.setNoticeNo(rset.getInt("NOTICE_NO"));
//		notice.setNoticeSubject(rset.getString("NOTICE_SUBJECT"));
//		notice.setNoticeContent(rset.getString("NOTICE_CONTENT"));
//		notice.setNoticeContent(rset.getString("NOTICE_PRODUCT"));
//		notice.setNoticeWriter(rset.getString("NOTICE_WRITER"));
//		notice.setNoticeDate(rset.getTimestamp("NOTICE_DATE"));
//		notice.setUpdateDate(rset.getTimestamp("UPDATE_DATE"));
//		notice.setViewCount(rset.getInt("VIEW_COUNT"));
//		return notice;
//	}
//
//	public String generatePageNavi(int currentPage) {
//		int totalCount = 200;	
//		int recordCountPerPage = 5;
//		int naviTotalCount = 0;
//		if(totalCount % recordCountPerPage > 0) {
//			naviTotalCount = totalCount / recordCountPerPage + 1;
//		} else {
//			naviTotalCount = totalCount / recordCountPerPage;
//		}
//		int naviCountPerPage = 10;
//		int startNavi = ((currentPage - 1)/naviCountPerPage) * naviCountPerPage + 1;
//		int endNavi = startNavi + naviCountPerPage - 1;
//		if(endNavi > naviTotalCount) {
//			endNavi = naviTotalCount;
//		}
//		boolean needPrev = true;
//		boolean needNext = true;
//		if(startNavi == 1) {
//			needPrev = false;
//		}
//		if(endNavi == naviTotalCount) {
//			needNext = false;
//		}
//		StringBuilder result = new StringBuilder();
//		if(needPrev) {
//			result.append("<a href='/notice/list.do?currentPage="+(startNavi-1)+"'>[이전]</a>");
//		}
//		for(int i = startNavi; i <= endNavi; i++) {
//			result.append("<a href='/notice/list.do?currentPage="+i+"'>"+i+"</a>&nbsp;");
//		}
//		if(needNext) {
//			result.append("<a href='/notice/list.do?currentPage="+(endNavi+1)+"'>[다음]</a>");
//		}
//		return result.toString();
//	}

}
