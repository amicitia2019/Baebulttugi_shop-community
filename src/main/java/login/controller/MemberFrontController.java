package login.controller;

import java.io.IOException;  

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import login.action.MemberIdCheckAction;
import login.action.MemberLoginAction;
import login.action.MemberLogoutAction;
import login.action.MemberRegistAction;
import login.action.MemberzipSearchAction;
import vo.ActionForward;

/**
 * Servlet implementation class MemberFrontController
 */
@WebServlet("*.me")
public class MemberFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MemberFrontController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String requestURI = request.getRequestURI();
		// ��û URL : http://localhost:8088/LoginProject/login.me
		// requestURI : /LoginProject/login.me

		String contextPath = request.getContextPath();
		// ��û URL : http://localhost:8088/LoginProject/login.me
		// contextPath : /LoginProject

		String command = requestURI.substring(contextPath.length());
		// /login.me
		// 2. ��û�� �����Ͻ����� ����
		ActionForward forward = null;
		Action action = null;

		if (command.equals("/login/login.me")) {
			action = new MemberLoginAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else if (command.equals("/login/logout.me")) {
			action = new MemberLogoutAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (command.equals("/login/idCheck.me")) {
			action = new MemberIdCheckAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (command.equals("/login/zipSearch.me")) {			
			action = new MemberzipSearchAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if (command.equals("/login/memberRegist.me")) {			
			action = new MemberRegistAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		// 3.���������� ������
		if (forward != null) {
			// ��ûó���� ����εǾ��ٸ�..
			if (forward.isRedirect()) {
				response.sendRedirect(forward.getUrl());
			} else {
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getUrl());
				dispatcher.forward(request, response);
			}
		}

	}// doget�� ��ûó��.

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}// Post������� �Ѿ���� �� �ѱ�ó���� �ؾ��ϴ� ���.. request.setCharacterEncoding("UTF-8");

}
