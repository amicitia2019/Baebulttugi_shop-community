package shop.action;

import javax.servlet.http.Cookie; 
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop.service.ProductViewService;
import vo.ActionForward;
import shop.vo.ProductVO;

public class ProductViewAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		
		ProductViewService productViewService = new ProductViewService();
		ProductVO productVO = productViewService.getProduct(id);
		
		Cookie cookie = new Cookie("today" + id, productVO.getProductImage());
		//��Ű��ü�� �����ϸ� �⺻������ �����Ⱓ�� -1�� ������
		//��, �������� ���� �߿��� ��Ű��ü�� ���������� �������� �����ϸ� 
		//��Ű�� ��� �Ҹ�Ǵ� �����Ⱓ
		cookie.setMaxAge(60 * 60 * 24); //������ �ʴ���
		response.addCookie(cookie);
		
		
		request.setAttribute("productVO",productVO);
		
		ActionForward forward = new ActionForward();
		forward.setUrl("productView.jsp");
		return forward;
	}

}
