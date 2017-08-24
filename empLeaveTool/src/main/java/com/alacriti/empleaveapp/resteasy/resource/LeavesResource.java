package com.alacriti.empleaveapp.resteasy.resource;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.alacriti.empleavetool.bo.impl.BOException;
import com.alacriti.empleavetool.dao.impl.DAOException;
import com.alacriti.empleavetool.deligate.LeaveDeligate;
import com.alacriti.empleavetool.exception.BaseException;
import com.alacriti.empleavetool.vo.LeaveVo;

@Path("/leave")
public class LeavesResource {

	@POST
	@Path("/history")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<LeaveVo> history(String leaveVo,
			@Context HttpServletRequest request) throws Exception {
		LeaveDeligate deligate = new LeaveDeligate();
		return deligate.leaveHistoryDeligate(leaveVo);

	}

	@POST
	@Path("/cancel")
	@Produces(MediaType.APPLICATION_JSON)
	public String cancel(LeaveVo leaveVo, @Context HttpServletRequest request)
			throws BaseException, Exception {
		String result = null;
		LeaveDeligate deligate = new LeaveDeligate();
		result = deligate.leaveCancel(leaveVo);
		return result;
	}

	@POST
	@Path("/newleave")
	@Produces(MediaType.APPLICATION_JSON)
	public String newLeave(LeaveVo leavevo, @Context HttpServletRequest request)
			throws BOException, DAOException, SQLException {

		LeaveDeligate deligate = new LeaveDeligate();
		return deligate.applyLeaveDeligate(leavevo);
	}

	@POST
	@Path("/leaveapproved")
	@Produces(MediaType.APPLICATION_JSON)
	public String leaveapprove(LeaveVo leavevo,
			@Context HttpServletRequest request) throws DAOException,
			BOException, SQLException {
		LeaveDeligate deligate = new LeaveDeligate();
		return deligate.leaveApproveDeligate(leavevo);

	}

}
