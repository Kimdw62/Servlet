package edu.sejong.vote.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Command {
	void excuete(HttpServletRequest request, HttpServletResponse response);
}
