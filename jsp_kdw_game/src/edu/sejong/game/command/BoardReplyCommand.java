package edu.sejong.game.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.sejong.game.dao.BoardDao;

public class BoardReplyCommand implements Command {

	@Override
	public void excuete(HttpServletRequest request, HttpServletResponse response) {
		String bid = request.getParameter("bid");
		String bname = request.getParameter("bname");
		String btitle = request.getParameter("btitle");
		String bcontent = request.getParameter("bcontent");

		String bgroup = request.getParameter("bgroup");
		String bstep = request.getParameter("bstep");
		String bindent = request.getParameter("bindent");
		
		BoardDao dao = new BoardDao();
		
		dao.reply(bid, bname, btitle, bcontent, bgroup, bstep, bindent);
	}

}
