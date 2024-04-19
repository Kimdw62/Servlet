package edu.sejong.game.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.sejong.game.command.BoardContentCommand;
import edu.sejong.game.command.BoardDeleteCommand;
import edu.sejong.game.command.BoardListCommand;
import edu.sejong.game.command.BoardModifyCommand;
import edu.sejong.game.command.BoardReplyCommand;
import edu.sejong.game.command.BoardReplyViewCommand;
import edu.sejong.game.command.BoardWriteCommand;
import edu.sejong.game.command.Command;

@WebServlet("/board/*")
public class BoardController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BoardController() {
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

		if (commandDo.equals("/board/list.do")) {
			command = new BoardListCommand();
			command.excuete(request, response);
			viewPage = "/board_list.jsp";

		}else if (commandDo.equals("/board/write_view.do")) {
			viewPage = "/write_view.jsp";

		} else if (commandDo.equals("/board/write.do")) {
			command = new BoardWriteCommand();
			command.excuete(request, response);
			viewPage = "/board/list.do";

		} else if (commandDo.equals("/board/content_view.do")) {
			command = new BoardContentCommand();
			command.excuete(request, response);
			viewPage = "/content_view.jsp";

		} else if (commandDo.equals("/board/modify.do")) {
			command = new BoardModifyCommand();
			command.excuete(request, response);
			viewPage = "/board/list.do";
			
		}else if (commandDo.equals("/board/delete.do")) {
			command = new BoardDeleteCommand();
			command.excuete(request, response);
			viewPage = "/board/list.do";

		} else if (commandDo.equals("/board/reply_view.do")) {
			command = new BoardReplyViewCommand();
			command.excuete(request, response);
			viewPage = "/reply_view.jsp";

		} else if (commandDo.equals("/board/reply.do")) {
			command = new BoardReplyCommand();
			command.excuete(request, response);
			viewPage = "/board/list.do";
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}
}
