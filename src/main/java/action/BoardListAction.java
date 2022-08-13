package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.BoardListService;
import vo.ActionForward;
import vo.BoardVO;
import vo.PageVO;

public class BoardListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		int pageSize = 10; //�������� �� ��µǴ� ���� ����
		String pageNum = request.getParameter("pageNum");
	    if (pageNum == null) {//�Ķ���� ������ pageNum ���� ���۵��� �������...
	        pageNum = "1"; //�۾��������� 1 �������� ����, ��, 1�������� ����Ʈ��
	    }

	    int currentPage = Integer.parseInt(pageNum);
	    int startRow = (currentPage - 1) * pageSize + 1;
	    //�ش� �������� ��µ� ù��° ���ڵ� ��ȣ
	    //���������� : 1
	    //startRow = (1 - 1) * 10 + 1 ===> 1
	    //���������� : 2
	    //startRow = (2 - 1) * 10 + 1 ===> 11
	   
	    int count = 0; //�� ���� ����
	    int number=0; //��Ϻ��� �������� ��µǴ� �۵��� ��ȣ

	    BoardListService boardListService
	    = new BoardListService();
	    
	    
	    List<BoardVO> articleList = null; //�������� ��µ� �۸���� �����ϴ� �÷���
	    count = boardListService.getArticleCount();
	    
	    if (count > 0) {
	        articleList = boardListService.getArticles(startRow, pageSize);
	    }

		number=count-(currentPage-1)*pageSize;
		//�ش� �������� ù��°�� ��µǴ� ���� �۹�ȣ�� ���ϴ� �κ�
		//��ü ���� ���� : 132
		//���� ������ : 1
		//number : 132 - (1 - 1) * 10 ===> 132
		//��ü ���� ���� : 132
		//���� ������ : 2
		//number : 132 - (2 - 1) * 10 ===> 122
		
		int pageCount = 0;
		int startPage = 0;
		int endPage = 0;
		 if (count > 0) {
			 
		    	//��ü ������ ����
			 //120
		        pageCount = count / pageSize + 
		        		( count % pageSize == 0 ? 0 : 1);
				 
		    	//���� ������ �׷쿡�� ù��° ��������ȣ
		        startPage = (int)((currentPage-1)/10)*10+1;
		    	
		    	//�� �������׷��� ũ��
				int pageBlock=10;
		    	
		    	//������������ �����ִ� �������׷��� ������ ��������ȣ
		        endPage = startPage + pageBlock-1;
		    	
		    	//������ ������ �׷��� ��� �߻��� �� �ִ�.
		        if (endPage > pageCount) endPage = pageCount;
		 }
		 
		 
		 request.setAttribute("articleList", articleList);
		 PageVO pageVO = new PageVO();
		 pageVO.setCount(count);
		 pageVO.setCurrentPage(currentPage);
		 pageVO.setEndPage(endPage);
		 pageVO.setNumber(number);
		 pageVO.setPageCount(pageCount);
		 pageVO.setStartPage(startPage);
		 
		 request.setAttribute("pageVO", pageVO);
		 
		 ActionForward forward = new ActionForward();
		 forward.setUrl("board/list.jsp");
		return forward;
	}

}




