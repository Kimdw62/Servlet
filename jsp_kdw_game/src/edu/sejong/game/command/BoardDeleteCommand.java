package edu.sejong.game.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.sejong.game.dao.BoardDao;

public class BoardDeleteCommand implements Command {

	@Override
	public void excuete(HttpServletRequest request, HttpServletResponse response) {
		String bid = request.getParameter("bid");
		
		BoardDao dao = new BoardDao();
		dao.delete(bid);
	}
}
