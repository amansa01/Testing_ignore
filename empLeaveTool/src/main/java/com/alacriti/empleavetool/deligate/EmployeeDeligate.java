package com.alacriti.empleavetool.deligate;

import java.sql.SQLException;

import com.alacriti.empleavetool.bo.impl.EmpBoImpl;
import com.alacriti.empleavetool.vo.EmpAuthVo;
import com.alacriti.empleavetool.vo.EmpVo;

public class EmployeeDeligate {

	public EmpVo empValidateDeligate(EmpAuthVo empAuth) {
		EmpBoImpl empBoImpl = new EmpBoImpl();
		EmpVo empVo = new EmpVo();

		try {
			empVo = empBoImpl.empValidateBo(empAuth);
		} catch (Exception e) {
			System.out.println("Exception occur in empValidateDeligate() " + e);
		}
		return empVo;

	}

	public boolean registerEmployee(EmpVo empVo) {
		boolean flag = false;
		EmpBoImpl empBoImpl = new EmpBoImpl();

		try {
			flag = empBoImpl.registerEmployee(empVo);
		} catch (Exception e) {
			System.out.println("Exception occur in empAddDeligate() " + e);
		}
		return flag;
	}

	public EmpVo empDetailsDeligate(String empId) throws SQLException {
		EmpBoImpl empBoImpl = new EmpBoImpl();
		EmpVo empVo = new EmpVo();
		empVo = empBoImpl.empValidateBo(empId);
		return empVo;
	}
}
