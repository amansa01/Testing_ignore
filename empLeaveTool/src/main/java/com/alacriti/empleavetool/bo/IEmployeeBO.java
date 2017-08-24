package com.alacriti.empleavetool.bo;

import java.sql.SQLException;

import com.alacriti.empleavetool.bo.impl.BOException;
import com.alacriti.empleavetool.dao.impl.DAOException;
import com.alacriti.empleavetool.vo.EmpAuthVo;
import com.alacriti.empleavetool.vo.EmpVo;


public interface IEmployeeBO {

boolean registerEmployee(EmpVo details) throws SQLException,DAOException,BOException;
EmpVo empValidateBo(EmpAuthVo empauthvo) throws SQLException,DAOException,BOException;

}
