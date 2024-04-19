package edu.sejong.game.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface LottoCommand {
	void excuete(HttpServletRequest request, HttpServletResponse response);
}
