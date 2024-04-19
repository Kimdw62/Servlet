package edu.sejong.game.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.sejong.game.dao.BoardDao;
import edu.sejong.game.vo.BoardVO;

public class BoardListCommand implements Command {

	@Override
	public void excuete(HttpServletRequest request, HttpServletResponse response) {
		BoardDao dao = new BoardDao();
		List<BoardVO> boards = dao.list();

		request.setAttribute("boards", boards);
	}

}
