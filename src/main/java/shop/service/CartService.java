package shop.service;

import java.util.ArrayList; 

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import shop.vo.CartVO;
import shop.vo.ProductVO;

public class CartService {

	public void addCart(HttpServletRequest request, ProductVO productVO) {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		
		ArrayList<CartVO> cartList = 
				(ArrayList<CartVO>)session.getAttribute("cartList");
		
		if(cartList == null) {
			//ù��° ��� ��ǰ�̸�
			cartList = new ArrayList<CartVO>();
			session.setAttribute("cartList", cartList);
		}
		
		//��ٱ��Ͽ� ��ǰ�� ��´�.
		//1. �̹� ��ٱ��� ��Ͽ� ����ִ� ��ǰ�� �ٽ� ��ٱ��Ͽ� ��°��
		//������ ������Ŵ
		//2. �̹� ��ٱ��� ��Ͽ� ������� ���� ��ǰ�� ��ٱ��Ͽ� ��°��
		//���ο� ��ٱ��� �׸�ü(CartVO)�� �����ؼ� �߰�
		
		boolean newCart = true;
		//���� �߰��ϴ� ��ǰ�� ��ٱ��Ͽ� ���ο� �׸����� �Ǵ��ϴ� ����
		
		for (int i = 0; i < cartList.size(); i++) {
			if(productVO.getProductId() == cartList.get(i).getProductId()) {
				newCart = false;
				cartList.get(i).setProductQty(cartList.get(i).getProductQty() + 1);
				break;
			}
		}
		
		CartVO cartVO = null;
		if(newCart) {
			cartVO = new CartVO();
			cartVO.setProductId(productVO.getProductId());
			cartVO.setProductImage(productVO.getProductImage());
			cartVO.setProductKind(productVO.getProductKind());
			cartVO.setProductPrice(productVO.getProductPrice());
			cartVO.setProductQty(1);
			cartList.add(cartVO);
		}
	}

	public ArrayList<CartVO> getCartList(HttpServletRequest request) {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		
		return (ArrayList<CartVO>)session.getAttribute("cartList");
	}

	public void upCartQty(HttpServletRequest request, int id) {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		ArrayList<CartVO> cartList = 
				(ArrayList<CartVO>)session.getAttribute("cartList");
		
		for (int i = 0; i < cartList.size(); i++) {
			if(id == cartList.get(i).getProductId()) {
				cartList.get(i).setProductQty(cartList.get(i).getProductQty() + 1);
			}
		}
	}
	public void downCartQty(HttpServletRequest request, int id) {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		ArrayList<CartVO> cartList = (ArrayList<CartVO>)
				session.getAttribute("cartList");
		
		for (int i = 0; i < cartList.size(); i++) {
			if(id == cartList.get(i).getProductId()) {
				cartList.get(i).setProductQty(cartList.get(i).getProductQty() - 1);
			}
		}
	}

	public void removeCart(HttpServletRequest request, String[] deleteIdArray) {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		ArrayList<CartVO> cartList = 
				(ArrayList<CartVO>)session.getAttribute("cartList");
		
		for (int i = 0; i < deleteIdArray.length; i++) {
			for (int j = 0; j < cartList.size(); j++) {
				if(Integer.parseInt(deleteIdArray[i]) == cartList.get(j).getProductId()) {
					cartList.remove(cartList.get(j));
				}
			}
		}
		
	}

}












