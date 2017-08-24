package com.alacriti.empleavetool.session;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.core.Context;

import com.alacriti.empleavetool.vo.EmpVo;

public class SessionUtility {
	public SessionUtility() {

	}

	public void createSession(HttpServletRequest request, EmpVo empVo) {
		try {
			HttpSession session = request.getSession(true);
			session.setAttribute("email", empVo.getEmail());
		} catch (Exception e) {
			System.out.println("Exception in creating session: " + e);
		}
	}

	public HttpSession getSession(@Context HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		return session;
	}

	public boolean destroySession(HttpServletRequest request) {
		HttpSession existingSession = request.getSession(false);

		try {
			existingSession.invalidate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			System.out
					.println("\n\n Exception in destroying the session: " + e);
			return false;
		}

	}

}
