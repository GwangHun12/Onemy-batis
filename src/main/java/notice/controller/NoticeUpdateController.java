package notice.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notice.model.service.NoticeService;
import notice.model.vo.Notice;

/**
 * Servlet implementation class NoticeUpdateController
 */
@WebServlet("/notice/modify.do")
public class NoticeUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeUpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int noticeNo = Integer.parseInt(request.getParameter("noticeNo"));
		NoticeService service = new NoticeService();
		// SELECT * FROM NOTICE_TBL WHERE NOTICE_NO = ?
		Notice notice = service.selectOneById(noticeNo);
		if(notice != null) {
			// 데이터가 있으면 modify.jsp로 이동
			request.setAttribute("notice", notice);
			request.getRequestDispatcher("/WEB-INF/views/notice/detail.jsp").forward(request, response);
//			response.sendRedirect("/notice/detail.do?noticeNo="+notice);
		} else { 
			// 데이터가 없으면 에러페이지로 이동
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// UPDATE NOTICE_TBL SET NOTICE_SUBJECT = ?, NOTICE_CONTENT = ? WHERE NOTICE_NO = ?
		request.setCharacterEncoding("UTF-8");
		int noticeNo = Integer.parseInt(request.getParameter("noticeNo"));
		String noticeSubject = request.getParameter("noticeSubject");
		String noticeContent = request.getParameter("noticeContent");
		String noticeProduct = request.getParameter("noticeProduct");
		Notice notice = new Notice(noticeSubject, noticeContent, noticeContent, noticeProduct);
		NoticeService service = new NoticeService();
		int result = service.UpdateNotice(noticeNo);
		if(result > 0) {
			// 성공하면 상세페이지로 이동
			response.sendRedirect("/notice/detail.do?noticeNo=" + noticeNo);
		} else {
			// 실패하면 에러메시지 출력
			request.setAttribute("msg", "공지사항 수정이 완료되지 않았습니다.");
			request.setAttribute("url", "/notice/modify.do?noticeNo" + noticeNo);
			request.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp").forward(request, response);
		}
	}

}
