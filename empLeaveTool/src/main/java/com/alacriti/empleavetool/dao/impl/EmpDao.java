package com.alacriti.empleavetool.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.alacriti.empleavetool.constants.Constants;
import com.alacriti.empleavetool.dao.IEmployeeDAO;
import com.alacriti.empleavetool.vo.EmpAuthVo;
import com.alacriti.empleavetool.vo.EmpVo;

public class EmpDao extends BaseDao implements IEmployeeDAO {

	public boolean checkEmpMaster(EmpVo empdetails) throws SQLException {
		Connection conn = null;
		boolean result = false;
		ResultSet rs = null;
		PreparedStatement preparedStatement = null;
		try {
			conn = getConnection();
			String passQuery = "select emp_id from amans_empleaveportal_emp_master_tbl where emp_id=?";
			preparedStatement = conn.prepareStatement(passQuery);
			preparedStatement.setString(1, empdetails.getEmpId());
			rs = preparedStatement.executeQuery();
			if (rs.next())
				result = rs.getString(1) != null;

		} catch (Exception e) {
			System.out.println("In empMaster " + e);
		} finally {
			rs.close();
			preparedStatement.close();
			closeConnection(conn);
			
		}
		return result;
	}

	public boolean createNewEmp(EmpVo empDetails) throws DAOException,
			SQLException {
		boolean flag = false;
		boolean empProfileResult = false;
		boolean empInfoResult = false;
		Connection conn = null;
		if (checkEmpMaster(empDetails)) {

			try {
				conn = getConnection();

				empInfoResult = createEmpInfo(empDetails, conn);
				empProfileResult = createEmpProfile(empDetails, conn);

				if (empProfileResult && empInfoResult) {
					commitConnection(conn);
					flag = true;
				} else {
					rollBackTransaction(conn);
				}

			} catch (Exception e) {
				System.out.println("Exception in Dao createNewEmp()"
						+ e.getMessage());
				throw new DAOException("Exception occur in Dao createNewEmp()"
						+ e);
			}

			finally {
				closeConnection(conn);

			}
			return flag;
		}

		return flag;
	}

	public EmpVo empValidate(EmpAuthVo empauthvo) throws DAOException,
			SQLException {
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement preparedStatement = null;
		String empId = null;
		String email = empauthvo.getEmail();
		String password = empauthvo.getPassWord();
		EmpVo empVo = new EmpVo();

		try {
			conn = getConnection();
			String passQuery = "select emp_id from amans_empleaveportal_emp_profile_2_tbl where email=? and password=?";
			preparedStatement = conn.prepareStatement(passQuery);
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, password);

			rs = preparedStatement.executeQuery();
			if (rs.next()) {
				empId = rs.getString(1);
			}

			if (empId != null) {
				empVo = empInfoResult(empId);
				return empVo;
			}

		} catch (SQLException e) {
			System.out
					.println("Exception occur in preparing statement for validation"
							+ e);
			throw new DAOException("Exception occur" + e);
		} finally {
			rs.close();
			preparedStatement.close();
			closeConnection(conn);
			
		}

		return null;

	}

	public boolean createEmpInfo(EmpVo empdetails, Connection conn)
			throws DAOException {
		boolean flag = false;
		int resultValue = 0;
		String query = "Insert into amans_empleaveportal_emp_info_2_tbl values(?,?,?,?,?,?,?)";
		PreparedStatement preparedStatement = null;

		try {
			preparedStatement = conn.prepareStatement(query);

			preparedStatement.setString(1, empdetails.getEmpId());
			preparedStatement.setString(2, empdetails.getfName());
			preparedStatement.setString(3, empdetails.getmName());
			preparedStatement.setString(4, empdetails.getlName());
			preparedStatement.setString(5, empdetails.getGender());
			preparedStatement.setString(6, empdetails.getContactNo());
			preparedStatement.setInt(7, Constants.TOTAL_LEAVES);

			resultValue = preparedStatement.executeUpdate();
			preparedStatement.close();
			if (resultValue == 1) {
				flag = true;
			}
		} catch (SQLException e) {
			System.out
					.println("Exception in createEmpInfo() " + e.getMessage());
			throw new DAOException("SQLException in createEmpInfo()", e);
		}
		return flag;
	}

	public boolean createEmpProfile(EmpVo empDetails, Connection conn)
			throws DAOException {
		boolean flag = false;
		int resultValue = 0;
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn
					.prepareStatement("Insert into amans_empleaveportal_emp_profile_2_tbl values(?,?,?,?,null,?,?)");
			preparedStatement.setString(1, empDetails.getEmpId());
			preparedStatement.setString(2, empDetails.getEmail());
			preparedStatement.setString(3, empDetails.getPassWord());
			preparedStatement.setBoolean(4, true);
			preparedStatement.setString(5, empDetails.getQuestionId());
			preparedStatement.setString(6, empDetails.getAnswer());

			resultValue = preparedStatement.executeUpdate();
			preparedStatement.close();
			if (resultValue == 1) {
				flag = true;
			}
		} catch (SQLException e) {
			System.out.println("Exception in createEmpProfile()"
					+ e.getMessage());
			throw new DAOException("SQLException in CreateEmpProfile", e);
		}
		return flag;

	}

	public EmpVo empInfoResult(String empId) throws SQLException {
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		EmpVo empVo = new EmpVo();
		Connection conn = null;
//		String empId=empID;
		HelperUtility helperUtility = new HelperUtility();
		try {
			System.out.println(empId);
			conn = getConnection();
			String query = "SELECT * FROM amans_empleaveportal_emp_info_2_tbl info join amans_empleaveportal_emp_profile_2_tbl profile on profile.emp_id=? AND info.emp_id =?";
			preparedStatement = conn.prepareStatement(query);
			preparedStatement.setString(1, empId);
			preparedStatement.setString(2, empId);
			rs = preparedStatement.executeQuery();
			empVo = helperUtility.wrapperEmp(rs);
			System.out.println("In empInfo" + empVo.getLeaveBalance());

		} catch (Exception e) {
			System.out.println("Exception in empInfoResult() " + e);
			e.printStackTrace();

		} finally {
			rs.close();
			preparedStatement.close();
			closeConnection(conn);
			
		}

		return empVo;
	}

}
