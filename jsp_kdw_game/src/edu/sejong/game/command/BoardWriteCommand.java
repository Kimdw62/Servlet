package edu.sejong.game.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.sejong.game.dao.BoardDao;

public class BoardWriteCommand implements Command {

	@Override
	public void excuete(HttpServletRequest request, HttpServletResponse response) {
		String bname = request.getParameter("bname");
		String btitle = request.getParameter("btitle");
		String bcontent = request.getParameter("bcontent");
		
		BoardDao dao = new BoardDao();
		dao.write(bname, btitle, bcontent);
	}

}
