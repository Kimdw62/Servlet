package edu.sejong.vote.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.sejong.vote.dao.MemberDao;

public class MemberModifyCommand implements Command {

	@Override
	public void excuete(HttpServletRequest request, HttpServletResponse response) {
		String m_no = request.getParameter("m_no");
		String m_name = request.getParameter("m_name");
		String p_code = request.getParameter("p_code");
		String p_school = request.getParameter("p_school");
		String m_jumin = request.getParameter("m_jumin");
		String m_city = request.getParameter("m_city");
		
		System.out.println("m_name = " + m_name);
		
		MemberDao dao = new MemberDao();
		dao.modify(m_no, m_name, p_code, p_school, m_jumin, m_city);
	}

}
