package edu.sejong.vote.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.sejong.vote.command.Command;
import edu.sejong.vote.command.MemberDeleteCommand;
import edu.sejong.vote.command.MemberListCommand;
import edu.sejong.vote.command.MemberModifyCommand;
import edu.sejong.vote.command.MemberViewCommand;
import edu.sejong.vote.command.MemberWriteCommand;
import edu.sejong.vote.command.PartyListCommand;
import edu.sejong.vote.command.SchoolListCommand;

@WebServlet("/member/*")
public class MemberController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MemberController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doGet() .. ");
		actionDo(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doPost() .. ");
		actionDo(request, response);
	}

	private void actionDo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("actionDo() .. ");

		request.setCharacterEncoding("UTF-8");

		String viewPage = null;
		Command command = null;

		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String commandDo = uri.substring(conPath.length());

		System.out.println("uri : " + uri);
		System.out.println("conPath : " + conPath);
		System.out.println("commandDo : " + commandDo);

		if (commandDo.equals("/member/member_list.do")) {
			command = new MemberListCommand();
			command.excuete(request, response);

			//popup
			command = new PartyListCommand();
			command.excuete(request, response);
			command = new SchoolListCommand();
			command.excuete(request, response);
			
			viewPage = "/member_list.jsp";

		} else if (commandDo.equals("/member/member_write.do")) {
			command = new MemberWriteCommand();
			command.excuete(request, response);
			viewPage = "/member/member_list.do";

		}else if (commandDo.equals("/member/member_delete.do")) {
			command = new MemberDeleteCommand();
			command.excuete(request, response);
			viewPage = "/member/member_list.do";

		}else if (commandDo.equals("/member/member_view.do")) {
			command = new MemberViewCommand();
			command.excuete(request, response);

			command = new PartyListCommand();
			command.excuete(request, response);
			command = new SchoolListCommand();
			command.excuete(request, response);
			
			viewPage = "/member_view.jsp";

		} else if (commandDo.equals("/member/member_modify.do")) {
			command = new MemberModifyCommand();
			command.excuete(request, response);
			viewPage = "/member/member_list.do";
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}
}
