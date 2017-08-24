package com.alacriti.empleavetool.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.alacriti.empleavetool.constants.Constants;
import com.alacriti.empleavetool.dao.ILeaveDAO;
import com.alacriti.empleavetool.vo.EmpVo;
import com.alacriti.empleavetool.vo.LeaveVo;

public class LeaveDao extends BaseDao implements ILeaveDAO {

	public String applyNewLeave(LeaveVo leavevo) throws DAOException,
			SQLException {

		Connection conn = null;
		boolean flag = false;
		boolean updateLeaveTable = false;
		try {
			conn = getConnection();
			updateLeaveTable = insertIntoLeaveTable(leavevo, conn);
		} catch (Exception e) {
			System.out.println("Exception in applyNewLeave()" + e);
			throw new DAOException("Exception occur in createNewEmp :" + e);
		} finally {

			if (updateLeaveTable) {

				commitConnection(conn);
				flag = true;
			} else {
				rollBackTransaction(conn);
			}
			closeConnection(conn);
		}
		if (flag)
			return "Sussesfully Applied New Leave";
		else
			return "Leave cannot be applied";
	}

	public ArrayList<LeaveVo> historyOfLeaves(String leaveVo)
			throws DAOException, SQLException {
		Connection conn = null;
		ResultSet rs = null;
		String query = null;
		String empId;
		Date dateApplied;
		Date lastModifyTime;
		Date leaveToDate;
		String leaveId;
		String leaveStatus = null;
		int noDays;
		String leaveReason;
		String leaveTag;
		PreparedStatement preparedStatement = null;
		ArrayList<LeaveVo> leaveVoList = new ArrayList<LeaveVo>();
		try {
			conn = getConnection();

			query = "Select emp_id,date_applied,leave_status,leave_to_date,no_days,leave_reason,last_modify_time,leave_id,leave_tag from amans_empleaveportal_leave_tbl where emp_id=?";
			preparedStatement = conn.prepareStatement(query);
			preparedStatement.setString(1, leaveVo);
			rs = preparedStatement.executeQuery();

			while(rs.next()) {

				empId = rs.getString("emp_id");
				dateApplied = rs.getDate("date_applied");
				leaveToDate = rs.getDate("leave_to_date");
				noDays = rs.getInt("no_days");
				leaveReason = rs.getString("leave_reason");
				leaveTag = rs.getString("leave_tag");
				lastModifyTime = rs.getDate("last_modify_time");
				leaveId = rs.getString("leave_id");
				leaveStatus = rs.getString("leave_status");

				leaveVoList.add(new LeaveVo(leaveToDate, dateApplied, empId,
						noDays, leaveReason, leaveTag, leaveId, lastModifyTime,
						leaveStatus));
			}
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Exception in historyOfLeavesDao() : " + e);
			throw new DAOException();
		} finally {
			preparedStatement.close();
			rs.close();
			closeConnection(conn);
		}

		return leaveVoList;

	}

	public boolean insertIntoLeaveTable(LeaveVo leavevo, Connection conn)
			throws DAOException, SQLException {
		PreparedStatement preparedStatement = null;
		boolean flag = false;
		int resultValue = 0;
		try {

			String query = "Insert into amans_empleaveportal_leave_tbl(emp_id,date_applied,last_modify_time,leave_reason,no_days,leave_tag,leave_status,leave_to_date) values(?,?,?,?,?,?,?,?)";
			long millis = System.currentTimeMillis();
			java.sql.Date date = new java.sql.Date(millis);
			String leaveStatus = "In Progress";

			preparedStatement = conn.prepareStatement(query);
			preparedStatement.setString(1, leavevo.getEmpId());
			preparedStatement.setDate(2, leavevo.getFromDate());
			preparedStatement.setDate(3, date);
			preparedStatement.setString(4, leavevo.getReason());
			preparedStatement.setInt(5, leavevo.getNoDays());
			preparedStatement.setString(6, leavevo.getLeaveTag());
			preparedStatement.setString(7, leaveStatus);
			preparedStatement.setDate(8, leavevo.getToDate());

			resultValue = preparedStatement.executeUpdate();
			if (resultValue == 1) {
				flag = true;

			}

		} catch (SQLException e) {
			System.out.println("Exception in insertIntoLeaveTable()  "
					+ e.getMessage());
			throw new DAOException("Exception in insertIntoLeaveTable() ", e);
		} finally {
			preparedStatement.close();
		}

		return flag;

	}

	public boolean leaveApproveDao(LeaveVo leaveVo) throws DAOException,
			SQLException {
		Connection conn = null;
		int result = 0;
		int result_1 = 0;
		boolean flag = false;

		EmpVo empVo = new EmpVo();
		EmpDao empDao = new EmpDao();
		leaveVo = leaveInfoResult(leaveVo);
		String empId = leaveVo.getEmpId();

		empVo = empDao.empInfoResult(empId);

		try {
			conn = getConnection();
			int updateLeaveBalance = (empVo.getLeaveBalance() - leaveVo
					.getNoDays());

			leaveVo = leaveInfoResult(leaveVo);
			if (leaveVo.getLeaveStatus()
					.equalsIgnoreCase(Constants.In_Progress))
				try {

					result = updateEmpInfo(updateLeaveBalance,
							empVo.getEmpId(), conn);
					result_1 = updateLeaveTable(Constants.Approved,
							leaveVo.getLeaveId(), conn);

					if (result == 1 && result_1 == 1) {
						commitConnection(conn);
						flag = true;

					} else {
						System.out
								.println("Some Problem Occured So Rolling back");
						rollBackTransaction(conn);
					}

				} catch (SQLException e) {
					System.out.println("Exception in leaveApproveDao() "
							+ e.getMessage());
					throw new DAOException("Exception in leaveApproveDao()", e);

				}

		} catch (SQLException e) {
			System.out.println("Exception in leaveApproveDao()"
					+ e.getMessage());
			throw new DAOException("Exception in leaveApproveDao():", e);

		} finally {
			closeConnection(conn);
		}

		return flag;
	}

	public boolean cancelLeave(LeaveVo leaveVo) throws DAOException,
			SQLException {

		Connection conn = null;
		int result = 0;
		int result_1 = 0;
		boolean flag = false;
		EmpVo empvo = new EmpVo();
		EmpDao empdao = new EmpDao();
		try {
			leaveVo = leaveInfoResult(leaveVo);
			String empId = leaveVo.getEmpId();
			empvo = empdao.empInfoResult(empId);
			conn = getConnection();

			if (leaveVo.getLeaveStatus()
					.equalsIgnoreCase(Constants.In_Progress)
					|| leaveVo.getLeaveStatus().equalsIgnoreCase(
							Constants.Availed)) {
				String leaveStatus = Constants.Cancel;
				
				result = updateLeaveTable(leaveStatus, leaveVo.getLeaveId(),
						conn);
				System.out.println("Cancel result" + result);
			}if (result == 1) {

				commitConnection(conn);

				flag = true;

			} else {
				System.out.println("Some Problem Occured Rolling back for progress");
				rollBackTransaction(conn);
			}
			if (leaveVo.getLeaveStatus().equalsIgnoreCase(Constants.Approved)) {

				int updateLeaveBalance = (empvo.getLeaveBalance() + leaveVo
						.getNoDays());
				result = updateEmpInfo(updateLeaveBalance, empvo.getEmpId(),
						conn);
				result_1 = updateLeaveTable(Constants.Cancel,
						leaveVo.getLeaveId(), conn);
			}
			if (result == 1 && result_1 == 1) {

				commitConnection(conn);

				flag = true;

			} else {
				System.out.println("Some Problem Occured Rolling back for Approved");
				rollBackTransaction(conn);
			}

		} catch (SQLException e) {
			System.out.println("In Dao cancel " + e);
			e.printStackTrace();
			throw new DAOException();
		} finally {
			closeConnection(conn);

		}
		return flag;
	}

	public LeaveVo leaveInfoResult(LeaveVo leavevo) throws SQLException {
		ResultSet rs = null;
		HelperUtility helperutility = new HelperUtility();
		String leaveId = leavevo.getLeaveId();
		LeaveVo leaveVo = new LeaveVo();
		PreparedStatement preparedStatement = null;
		Connection conn = null;

		try {
			conn = getConnection();
			String query = "Select * from amans_empleaveportal_leave_tbl where leave_id=?";
			preparedStatement = conn.prepareStatement(query);
			preparedStatement.setString(1, leaveId);
			rs = preparedStatement.executeQuery();

			leaveVo = helperutility.wrapperLeave(rs);

		} catch (Exception e) {
			System.out.println("ResultSet Leave Info " + e);

		} finally {
			preparedStatement.close();
			closeConnection(conn);
			
		}
		return leaveVo;
	}

	public int updateLeaveTable(String leaveStatus, String leaveId,
			Connection conn) throws SQLException {

		String query = null;
		int result = 0;
		PreparedStatement preparedStatement = null;
		try {
			query = "update amans_empleaveportal_leave_tbl set leave_status=? where leave_id=?";
			preparedStatement = conn.prepareStatement(query);
			preparedStatement.setString(1, leaveStatus);
			preparedStatement.setString(2, leaveId);
			result = preparedStatement.executeUpdate();

		} catch (Exception e) {
			System.out.println("updateLeaveTable " + e);

		} finally {

			preparedStatement.close();
		}

		return result;

	}

	public int updateEmpInfo(int leaveBalance, String empId, Connection conn)
			throws SQLException {

		String query = null;
		int result = 0;
		PreparedStatement preparedStatement = null;
		try {
			System.out.println("Leave Balance" + leaveBalance);
			System.out.println("empId " + empId);
			if (leaveBalance > 22)
				leaveBalance = 22;
			query = "update amans_empleaveportal_emp_info_2_tbl set leave_bal=? where emp_id=?";

			preparedStatement = conn.prepareStatement(query);
			preparedStatement.setInt(1, leaveBalance);
			preparedStatement.setString(2, empId);
			result = preparedStatement.executeUpdate();

		} catch (Exception e) {
			System.out.println("updateLeaveTable " + e);

		} finally {

			preparedStatement.close();
		}

		return result;

	}

}
