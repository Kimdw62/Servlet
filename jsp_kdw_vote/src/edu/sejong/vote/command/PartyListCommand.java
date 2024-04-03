package edu.sejong.vote.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.sejong.vote.dao.CodeDao;
import edu.sejong.vote.vo.CodeVO;

public class PartyListCommand implements Command {

	@Override
	public void excuete(HttpServletRequest request, HttpServletResponse response) {
		CodeDao dao = new CodeDao();
		List<CodeVO> party = dao.party();
		request.setAttribute("party", party);
	}

}
