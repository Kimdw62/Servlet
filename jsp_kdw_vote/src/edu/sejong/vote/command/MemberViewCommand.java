package edu.sejong.vote.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.sejong.vote.dao.MemberDao;
import edu.sejong.vote.vo.MemberVO;

public class MemberViewCommand implements Command {

	@Override
	public void excuete(HttpServletRequest request, HttpServletResponse response) {
		String m_no = request.getParameter("m_no");
		MemberDao dao = new MemberDao();
		MemberVO member = dao.memberView(m_no);
		request.setAttribute("view", member);
	}

}
