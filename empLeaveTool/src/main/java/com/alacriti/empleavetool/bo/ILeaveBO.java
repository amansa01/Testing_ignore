package com.alacriti.empleavetool.bo;

import java.sql.SQLException;
import java.util.ArrayList;

import com.alacriti.empleavetool.bo.impl.BOException;
import com.alacriti.empleavetool.dao.impl.DAOException;
import com.alacriti.empleavetool.vo.LeaveVo;

public interface ILeaveBO {

	String applyNewLeaveBo(LeaveVo leavevo) throws DAOException, SQLException,
			BOException;

	ArrayList<LeaveVo> leaveHistoryBo(String leavevo) throws DAOException,SQLException;

	String leaveApproveBo(LeaveVo leavevo) throws BOException, SQLException;

	String cancelLeaveBo(LeaveVo leavevo) throws BOException, Exception;
}
