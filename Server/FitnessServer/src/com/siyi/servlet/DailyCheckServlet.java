package com.siyi.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class DailyCheckServlet extends BaseMobileServlet {

	private static final long serialVersionUID = 4495375668511646732L;

	/**
	 * check-in
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String check(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userId = request.getParameter("userId");
		if (dailyCheckDao.isChecked(userId)) {
			return "You have already checked in today, no need to clock in again";
		} else {
			if (dailyCheckDao.check(userId)) {
				return "success";
			} else {
				return "Can't check-in temporarily";
			}
		}
	}

	// get check in recording
	public String getCheckedList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userId = request.getParameter("userId");
		String checkedList = dailyCheckDao.getCheckedList(userId);
		if (checkedList == null) {
			return ERROR;
		} else {
			return checkedList;
		}
	}

	public String getHomepageTotalRecord(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userId = request.getParameter("userId");
		int checkedDays = dailyCheckDao.getTotalCheckedDays(userId);
		int trainingDays = dailyCheckDao.getTotalTrainingDays(userId);
		return checkedDays + ":" + trainingDays;
	}

}
