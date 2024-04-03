package edu.sejong.vote.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.sejong.vote.dao.VoteDao;
import edu.sejong.vote.vo.VoteVO;

public class VoteViewCommand implements Command {

	@Override
	public void excuete(HttpServletRequest request, HttpServletResponse response) {
		String v_jumin = request.getParameter("v_jumin");
		VoteDao dao = new VoteDao();
		VoteVO vote = dao.voteView(v_jumin);
		request.setAttribute("vote", vote);
	}

}
