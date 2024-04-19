package edu.sejong.game.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.sejong.game.dao.BoardDao;
import edu.sejong.game.vo.BoardVO;

public class BoardReplyViewCommand implements Command {

	@Override
	public void excuete(HttpServletRequest request, HttpServletResponse response) {
		String bid = request.getParameter("bid");
		
		BoardDao dao = new BoardDao();
		
		BoardVO board = dao.replyView(bid);
		
		request.setAttribute("board", board);
	}

}
