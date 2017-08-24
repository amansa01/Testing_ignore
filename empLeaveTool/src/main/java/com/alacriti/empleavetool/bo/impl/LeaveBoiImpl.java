package com.alacriti.empleavetool.bo.impl;

import java.sql.SQLException;
import java.util.ArrayList;

import com.alacriti.empleavetool.bo.ILeaveBO;
import com.alacriti.empleavetool.constants.Constants;
import com.alacriti.empleavetool.dao.impl.DAOException;
import com.alacriti.empleavetool.dao.impl.LeaveDao;
import com.alacriti.empleavetool.vo.LeaveVo;

public class LeaveBoiImpl implements ILeaveBO {

	public String applyNewLeaveBo(LeaveVo leaveVo) throws DAOException,
			SQLException {
		LeaveDao leaveDao = new LeaveDao();
		try {

		} catch (Exception e) {
			System.out.println("Exception occur in applyNewLeaveBo() " + e);
		}
		return leaveDao.applyNewLeave(leaveVo);
	}

	public ArrayList<LeaveVo> leaveHistoryBo(String leaveVo)
			throws DAOException, SQLException {
		LeaveDao leaveDao = new LeaveDao();
		return leaveDao.historyOfLeaves(leaveVo);
	}

	public String leaveApproveBo(LeaveVo leaveVo) throws BOException,
			SQLException {

		boolean result = false;
		LeaveDao leavedao = new LeaveDao();
		try {
			result = leavedao.leaveApproveDao(leaveVo);
		} catch (DAOException e) {
			System.out.println(e);
			throw new BOException();
		}
		if (result)
			return "Leave Approved";
		else
			return "leave Denied";
	}

	public String cancelLeaveBo(LeaveVo leavevo) throws BOException, Exception {
		String status;
		String ReturnBo;
		boolean reDao = false;
		LeaveDao leavedao = new LeaveDao();
		status = leavevo.getLeaveStatus();
		if (status.equalsIgnoreCase(Constants.Cancel)
				|| status.equalsIgnoreCase(Constants.Availed)) {
			ReturnBo = "Leave Already Cancelled or Already Avialed";
			return ReturnBo;
		} else
			try {
				reDao = leavedao.cancelLeave(leavevo);

			} catch (DAOException e) {
				System.out.println("In cancelLeaveBo() " + e);
				e.printStackTrace();
				throw new BOException();
			}
		if (reDao) {
			ReturnBo = "Leave Cancel";
		} else
			ReturnBo = "Leave Not cancel";
		return ReturnBo;
	}

}
