package shop.action;

import java.io.PrintWriter;  

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import shop.service.ProductRegistService;
import vo.ActionForward;
import shop.vo.ProductVO;

public class ProductRegistAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		String realFolder = "";//�� ���ø����̼ǻ��� ���� ���

		//������ ���ε�Ǵ� ������ �����Ѵ�.
		String saveFolder = "/product/images";
		String encType = "UTF-8"; //���ڵ�Ÿ��
		int maxSize = 5*1024*1024;  //�ִ� ���ε� ����ũ�� 5Mb

		ServletContext context = request.getServletContext();
		//���ø����̼� �� �ϳ��� �����Ǵ� ȯ�漳������

		//���� jsp�������� �� ���ø����̼ǻ��� ���� ��θ� ���Ѵ�
		realFolder = context.getRealPath(saveFolder);  
		MultipartRequest multi = null;
		   
		   //������ ����� ������Ʈ�� �����ϰ� ������ �����Ѵ�.
		   //������ ���ϸ��� ������ �ִ� ��ü, �������� ������,�ִ� ���ε�� ����ũ��, �����ڵ�, �⺻ ���� ����
		   multi = new MultipartRequest(request,realFolder,maxSize,encType,
				   new DefaultFileRenamePolicy());
		ProductVO productVO = new ProductVO();
		productVO.setProductContent(multi.getParameter("productContent"));
		String productImageFileStr = multi.getFilesystemName("productImage");
		int index = productImageFileStr.indexOf(".");
		String productImage = productImageFileStr.substring(0, index);
		productVO.setProductImage(productImage);
		productVO.setProductKind(multi.getParameter("productKind"));
		productVO.setProductPrice(Integer.parseInt(multi.getParameter("productPrice")));
		productVO.setProductCategory(multi.getParameter("productCategory"));
		
	    ProductRegistService productRegistService = new ProductRegistService();
	    boolean registSuccess = productRegistService.registProduct(productVO);
	    
	    ActionForward forward = null;
	    if(registSuccess) {
	    	forward = new ActionForward();
	    	forward.setRedirect(true);
	    	forward.setUrl("productList.go");
	    }
	    else {
	    	response.setContentType("text/html;charset=UTF-8");
	    	PrintWriter out = response.getWriter();
	    	out.println("<script>");
	    	out.println("alert('��Ͻ���')");
	    	out.println("history.back()");
	    	out.println("</script>");
	    }
		return forward;
	}

}







