package edu.sejong.game.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.sejong.game.command.Command;
import edu.sejong.game.vo.RspVO;

public class RspResultCommand implements Command {

	@Override
	public void excuete(HttpServletRequest request, HttpServletResponse response) {
		String rsp = request.getParameter("rsp");

		System.out.println("RspResultCommand:rsp = " + rsp);
		
		RspVO computer = new RspVO();
		RspVO you = new RspVO(rsp);

		request.setAttribute("computer", computer);
		request.setAttribute("you", you);
	}
}
