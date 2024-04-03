package edu.sejong.vote.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.sejong.vote.command.AreaListCommand;
import edu.sejong.vote.command.CandiRankCommand;
import edu.sejong.vote.command.Command;
import edu.sejong.vote.command.MemberListCommand;
import edu.sejong.vote.command.VoteListCommand;
import edu.sejong.vote.command.VoteModifyCommand;
import edu.sejong.vote.command.VoteViewCommand;
import edu.sejong.vote.command.VoteWriteCommand;

@WebServlet("/vote/*")
public class VoteController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public VoteController() {
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

		if (commandDo.equals("/vote/vote_list.do")) {
			command = new VoteListCommand();
			command.excuete(request, response);
			viewPage = "/vote_list.jsp";

		} else if (commandDo.equals("/vote/vote_regist.do")) {
			command = new MemberListCommand();
			command.excuete(request, response);

			command = new AreaListCommand();
			command.excuete(request, response);

			viewPage = "/vote_regist.jsp";

		} else if (commandDo.equals("/vote/vote_write.do")) {
			command = new VoteWriteCommand();
			command.excuete(request, response);
			viewPage = "/vote_regist.jsp";

		}else if (commandDo.equals("/vote/candi_rank.do")) {
			command = new CandiRankCommand();
			command.excuete(request, response);
			viewPage = "/candi_rank.jsp";

		}else if (commandDo.equals("/vote/vote_view.do")) {
			command = new VoteViewCommand();	//투표
			command.excuete(request, response);

			command = new MemberListCommand();	//후보
			command.excuete(request, response);
			command = new AreaListCommand();
			command.excuete(request, response);
			
			viewPage = "/vote_view.jsp";

		} else if (commandDo.equals("/vote/vote_modify.do")) {
			command = new VoteModifyCommand();
			command.excuete(request, response);
			viewPage = "/vote/vote_list.do";

		} else if (commandDo.equals("/vote/home.do")) {
			viewPage = "/index.jsp";
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}
}
