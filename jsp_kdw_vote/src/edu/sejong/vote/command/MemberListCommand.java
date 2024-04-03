package edu.sejong.vote.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.sejong.vote.dao.MemberDao;
import edu.sejong.vote.vo.MemberVO;

public class MemberListCommand implements Command {

	@Override
	public void excuete(HttpServletRequest request, HttpServletResponse response) {
		MemberDao dao = new MemberDao();
		List<MemberVO> member = dao.list();
		request.setAttribute("member", member);
	}
}
