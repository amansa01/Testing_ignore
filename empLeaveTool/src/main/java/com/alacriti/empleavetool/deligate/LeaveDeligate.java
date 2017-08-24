package com.alacriti.empleavetool.deligate;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import com.alacriti.empleavetool.bo.impl.BOException;
import com.alacriti.empleavetool.bo.impl.LeaveBoiImpl;
import com.alacriti.empleavetool.dao.impl.DAOException;
import com.alacriti.empleavetool.dao.impl.EmpDao;
import com.alacriti.empleavetool.vo.EmpVo;
import com.alacriti.empleavetool.vo.LeaveVo;

public class LeaveDeligate {

	public String applyLeaveDeligate(LeaveVo leavevo) throws DAOException,
			SQLException {
		String LOP = "";
		Date todayDate = new Date();
		EmpDao empDao = new EmpDao();
		Date fromDate = leavevo.getFromDate();
		Date tilldate = leavevo.getToDate();
		String empId = leavevo.getEmpId();
		LeaveBoiImpl leaveBoImpl = new LeaveBoiImpl();
		EmpVo result = empDao.empInfoResult(empId);
		int leavebalance = result.getLeaveBalance();
		if (leavebalance <= 0)
			LOP = "LOP Applied";

		if ((fromDate.before(todayDate))) {
			System.out.println("Please Enter A Valid from date");
			return "Please Enter A Valid from date";
		} else if (tilldate.before(todayDate) || tilldate.before(fromDate)) {
			return "Please Enter A Valid  tilll date";
		} else {
			return leaveBoImpl.applyNewLeaveBo(leavevo) + LOP;
		}
	}

	public ArrayList<LeaveVo> leaveHistoryDeligate(String leaveVo)
			throws DAOException, Exception {

		LeaveBoiImpl leaveBoImpl = new LeaveBoiImpl();
		return leaveBoImpl.leaveHistoryBo(leaveVo);

	}

	public String leaveApproveDeligate(LeaveVo leavevo) throws DAOException,
			BOException, SQLException {

		LeaveBoiImpl leaveboimpl = new LeaveBoiImpl();
		return leaveboimpl.leaveApproveBo(leavevo);

	}

	public String leaveCancel(LeaveVo leaveVo) throws DAOException,Exception {
		String response = null;
		Date todayDate = new Date();

		Date beforeDate = leaveVo.getFromDate();
		LeaveBoiImpl leaveBoImpl = new LeaveBoiImpl();

		if (todayDate.equals(beforeDate))
			response = "Sorry You Can't Cancel Now";
		else
			try {
				response = leaveBoImpl.cancelLeaveBo(leaveVo);
			} catch (BOException e) {
				System.out.println("Error In leaveCancel()" + e);
				e.printStackTrace();
			}

		return response;

	}

}
