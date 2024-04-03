package edu.sejong.vote.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.sejong.vote.dao.MemberDao;

public class MemberDeleteCommand implements Command {

	@Override
	public void excuete(HttpServletRequest request, HttpServletResponse response) {
		String m_no = request.getParameter("m_no");
		
		MemberDao dao = new MemberDao();
		dao.delete(m_no);
	}

}
