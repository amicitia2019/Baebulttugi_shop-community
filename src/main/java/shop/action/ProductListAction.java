package shop.action;

import java.util.ArrayList; 

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop.service.ProductListService;
import vo.ActionForward;
import shop.vo.ProductVO;

public class ProductListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		ArrayList<String> todayImageList = new ArrayList<String>();
		Cookie[] cookieArray = request.getCookies();
		//request.getCookies() : Ŭ���̾�Ʈ���� ���޵� ��Ű��ü���� ��ȯ
		
		if(cookieArray != null) {
			//Ŭ���̾�Ʈ���� ��Ű�� �ϳ��� ���۵� ���
			
			for (int i = 0; i < cookieArray.length; i++) {
				//��Ű����
				//��Ű�̸�=��Ű��;����Ⱓ�� ����...
				if(cookieArray[i].getName().startsWith("today")) {
					todayImageList.add(cookieArray[i].getValue());
				}
			}
		}
		
		ProductListService productListService = new ProductListService();
		
		ArrayList<ProductVO> productList = productListService.getProductList();
		request.setAttribute("productList", productList);
		request.setAttribute("todayImageList", todayImageList);
		
		ActionForward forward = new ActionForward();
		/* forward.setUrl("productList.jsp"); */
		 forward.setUrl("productList.jsp"); 
		return forward;
	}

}
