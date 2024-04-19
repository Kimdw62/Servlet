package edu.sejong.game.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.sejong.game.dao.BoardDao;

public class BoardModifyCommand implements Command {

	@Override
	public void excuete(HttpServletRequest request, HttpServletResponse response) {
		String bid = request.getParameter("bid");
		String bname = request.getParameter("bname");
		String btitle = request.getParameter("btitle");
		String bcontent = request.getParameter("bcontent");
		
		System.out.println("request.getParameter(bid) = " + bid);
		System.out.println("request.getParameter(bname) = " + bname);
		
		BoardDao dao = new BoardDao();
		dao.modify(bid, bname, btitle, bcontent);
	}

}
