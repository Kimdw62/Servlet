package edu.sejong.vote.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.sejong.vote.dao.VoteDao;
import edu.sejong.vote.vo.VoteVO;

public class CandiRankCommand implements Command {

	@Override
	public void excuete(HttpServletRequest request, HttpServletResponse response) {
		VoteDao dao = new VoteDao();
		List<VoteVO> vote = dao.rank();
		request.setAttribute("vote", vote);
	}

}
