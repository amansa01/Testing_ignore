package com.alacriti.empleavetool.bo.impl;

import java.sql.SQLException;

import com.alacriti.empleavetool.bo.IEmployeeBO;
import com.alacriti.empleavetool.dao.impl.DAOException;
import com.alacriti.empleavetool.dao.impl.EmpDao;
import com.alacriti.empleavetool.vo.EmpAuthVo;
import com.alacriti.empleavetool.vo.EmpVo;

public class EmpBoImpl implements IEmployeeBO {

	public boolean registerEmployee(EmpVo details) throws DAOException,
			BOException {

		boolean flag = false;
		EmpDao empDao = new EmpDao();

		try {
			flag = empDao.createNewEmp(details);
		} catch (Exception e) {
			System.out.println("Exception occur in registerEmployee() " + e);
			throw new BOException();
		}
		return flag;
	}

	public EmpVo empValidateBo(EmpAuthVo empAuthVo) throws DAOException,
			BOException {
		EmpDao empdao = new EmpDao();
		EmpVo empvo = new EmpVo();

		try {

			empvo = empdao.empValidate(empAuthVo);
		} catch (Exception e) {
			System.out.println("Exception occur in empValidateBo()" + e);
			throw new BOException();
		}
		return empvo;
	}

	public EmpVo empValidateBo(String empId) throws SQLException {
		EmpDao empDao = new EmpDao();
		EmpVo empVo= new EmpVo();
		empVo= empDao.empInfoResult(empId);
		return empVo;
	}

}
