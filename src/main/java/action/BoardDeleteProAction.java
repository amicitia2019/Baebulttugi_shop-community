package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.BoardDeleteProService;
import service.BoardUpdateProService;
import vo.ActionForward;

public class BoardDeleteProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		  int num = Integer.parseInt(request.getParameter("num"));
		  String pageNum = request.getParameter("pageNum");
		  String passwd = request.getParameter("passwd");

		  BoardDeleteProService boardDeleteProService
			= new BoardDeleteProService();
			
			boolean removeSuccess = boardDeleteProService.removeArticle(num, passwd);
			
			ActionForward forward = null;
			
			if(removeSuccess) {
				forward = new ActionForward();
				forward.setUrl("boardList.bo?PageNum=" + pageNum);
				forward.setRedirect(true);
			}
			else {
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('��������')");
				out.println("history.back();");
				out.println("</script>");
			}
			return forward;
	}

}
