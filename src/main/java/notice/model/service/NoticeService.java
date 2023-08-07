package notice.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import common.SqlSessionTemplate;
import notice.model.dao.NoticeDAO;
import notice.model.vo.Notice;

public class NoticeService {
	
	private NoticeDAO nDao;

	public NoticeService() {  		
		nDao = new NoticeDAO();
	}
	
	public List<Notice> selectNoticeList(int currentPage) {
		SqlSession session = SqlSessionTemplate.getSqlSession();
		List<Notice> nList = nDao.selectNoticeList(session, currentPage);
		session.close();
		return nList;
	}

	public int insertNotice(Notice notice) {
		SqlSession session = SqlSessionTemplate.getSqlSession();
		int result = nDao.insertNotice(session, notice);
		if(result > 0) {
			session.commit();
		} else {
			session.rollback();
		}
		session.close();
		return result;
	}

	public int deleteNotice(int noticeNo) {
		SqlSession session = SqlSessionTemplate.getSqlSession();
		int result = nDao.deleteNotice(session, noticeNo);
		if(result > 0) {
			session.commit();
		} else {
			session.rollback();
		}
		session.close();
		return result;
	}

	public Notice selectOneById(int noticeNo) {
		SqlSession session = SqlSessionTemplate.getSqlSession();
		Notice notice = nDao.selectOneById(session, noticeNo);
		session.close();
		return notice;
	}

	public int UpdateNotice(int noticeNo) {
		SqlSession session = SqlSessionTemplate.getSqlSession();
		int result = nDao.UpdateNotice(session, noticeNo);
		if(result > 0) {
			session.commit();
		} else {
			session.rollback();
		}
		session.close();
		return result;
	}

}
