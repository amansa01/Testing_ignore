package com.alacriti.empleavetool.dao;

import java.sql.Connection;
import java.sql.SQLException;

import com.alacriti.empleavetool.dao.impl.DAOException;
import com.alacriti.empleavetool.vo.EmpAuthVo;
import com.alacriti.empleavetool.vo.EmpVo;

public interface IEmployeeDAO {


	boolean checkEmpMaster(EmpVo empdetails) throws SQLException;

	boolean createNewEmp(EmpVo empdetails) throws DAOException, SQLException;

	EmpVo empValidate(EmpAuthVo empauthvo) throws DAOException, SQLException;

	boolean createEmpInfo(EmpVo empdetails, Connection conn) throws DAOException;

	boolean createEmpProfile(EmpVo empdetails, Connection conn) throws DAOException;

}
