package com.alacriti.empleavetool.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import com.alacriti.empleavetool.dao.impl.DAOException;
import com.alacriti.empleavetool.vo.LeaveVo;

public interface ILeaveDAO {
	String applyNewLeave(LeaveVo leavevo) throws DAOException,
	SQLException;
	ArrayList<LeaveVo> historyOfLeaves(String leaveVo)
 throws DAOException,
			SQLException;
	boolean	insertIntoLeaveTable(LeaveVo leavevo, Connection conn)
			throws DAOException, SQLException;

	boolean	leaveApproveDao(LeaveVo leavevo) throws DAOException,
	SQLException;
	boolean cancelLeave(LeaveVo leavevo) throws DAOException,
	SQLException;
	
	 LeaveVo leaveInfoResult(LeaveVo leavevo) throws SQLException;
	 int updateLeaveTable(String leaveStatus, String leaveId,
				Connection conn) throws SQLException;
	 int updateEmpInfo(int leaveBalance, String empId, Connection conn)
				throws SQLException;
}
