package com.alacriti.empleavetool.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.alacriti.empleavetool.vo.EmpVo;
import com.alacriti.empleavetool.vo.LeaveVo;

public class HelperUtility extends BaseDao {

	

	public EmpVo wrapperEmp(ResultSet empInfoResult) throws SQLException {
		EmpVo empVo = new EmpVo();
		if(empInfoResult==null)
			return null;
		if (empInfoResult.next()) {

			empVo.setEmpId(empInfoResult.getString(1));
			empVo.setfName(empInfoResult.getString(2));
			empVo.setmName(empInfoResult.getString(3));
			empVo.setlName(empInfoResult.getString(4));
			empVo.setGender(empInfoResult.getString(5));
			empVo.setContactNo(empInfoResult.getString(6));
			empVo.setLeaveBalance(empInfoResult.getInt(7));
			empVo.setEmail(empInfoResult.getString(9));
			empVo.setEmpStatus(empInfoResult.getBoolean(11));
			empVo.setQuestionId((empInfoResult.getString(13)));
			empVo.setAnswer((empInfoResult.getString(14)));

		}

		return empVo;

	}

	

	public LeaveVo wrapperLeave(ResultSet leaveInfoResult) throws SQLException {
		LeaveVo leaveVo = new LeaveVo();
		if(leaveInfoResult==null)
			return null;
		if (leaveInfoResult.next()) {
			leaveVo.setLeaveId(leaveInfoResult.getString(1));
			leaveVo.setEmpId(leaveInfoResult.getString(2));
			leaveVo.setFromDate((leaveInfoResult.getDate(3)));
			leaveVo.setReason(leaveInfoResult.getString(5));
			leaveVo.setNoDays(leaveInfoResult.getInt(6));
			leaveVo.setLeaveTag(leaveInfoResult.getString(7));
			leaveVo.setLeaveStatus(leaveInfoResult.getString(8));
			leaveVo.setToDate(leaveInfoResult.getDate(9));
		}

		return leaveVo;

	}

}