package edu.sejong.game.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.sejong.game.command.LottoCommand;
import edu.sejong.game.vo.LottoVO;

public class LottoListCommand implements LottoCommand {

	@Override
	public void excuete(HttpServletRequest request, HttpServletResponse response) {
		LottoVO lotto = new LottoVO();
		request.setAttribute("lotto", lotto);
	}
}
