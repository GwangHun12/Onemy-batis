package notice.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notice.model.service.NoticeService;

/**
 * Servlet implementation class NoticeDeleteController
 */
@WebServlet("/notice/delte.do")
public class NoticeDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeDeleteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// DELETE FROM NOTICE_TBL WHERE NOTICE_NO = ?
		// detail.jsp에 location.href에 적은 쿼리스트링 파싱해오기
		int noticeNo = Integer.parseInt(request.getParameter("noticeNo"));
		String noticeSubject = request.getParameter("noticeSubject");
		String noticeContent = request.getParameter("noticeContent");
		NoticeService service = new NoticeService();
		int result = service.deleteNotice(noticeNo);
		if(result > 0) {
			// 성공시 목록으로 이동
			response.sendRedirect("/notice/list.do");
		} else {
			// 실패시 실패 메시지 및 상세페이지로 이동
			request.setAttribute("msg", "공지사항 삭제가 완료되지 않았습니다.");
			request.setAttribute("rul", "/notice/detail.do?noticeNo" + noticeNo);
			request.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
