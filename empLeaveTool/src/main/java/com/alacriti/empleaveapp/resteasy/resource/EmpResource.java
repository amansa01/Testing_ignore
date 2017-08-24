package com.alacriti.empleaveapp.resteasy.resource;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.alacriti.empleavetool.deligate.EmployeeDeligate;
import com.alacriti.empleavetool.session.SessionUtility;
import com.alacriti.empleavetool.vo.EmpAuthVo;
import com.alacriti.empleavetool.vo.EmpVo;

@Path("/emp")
public class EmpResource {

	// This Method Will Verify the Employee Details and return all The Employee
	// Details if Correct Details are provided
	@POST
	@Path("/login")
	@Produces(MediaType.APPLICATION_JSON)
	public EmpVo login(EmpAuthVo empAuthVo, @Context HttpServletRequest request) {
		EmployeeDeligate deligate = new EmployeeDeligate();
		EmpVo empVo = new EmpVo();

		SessionUtility sessionUtility = new SessionUtility();
		if (deligate.empValidateDeligate(empAuthVo) != null) {
			sessionUtility.createSession(request, empVo);
		}
		return deligate.empValidateDeligate(empAuthVo);

	}

	// Create a new Employee
	@POST
	@Path("/newemp")
	@Produces(MediaType.APPLICATION_JSON)
	public boolean employeeRegistration(EmpVo empvo,
			@Context HttpServletRequest request) {
		EmployeeDeligate deligate = new EmployeeDeligate();
		return deligate.registerEmployee(empvo);
	}

	// Check the Employee Session
	@GET
	@Path("/checkSession")
	@Produces(MediaType.TEXT_PLAIN)
	public boolean checkSession(@Context HttpServletRequest request) {
		SessionUtility sessionUtility = new SessionUtility();

		HttpSession session = sessionUtility.getSession(request);
		if (session != null) {
			return true;
		} else {
			return false;
		}
	}

	// To clear the Employee Session
	@GET
	@Path("/clearSession")
	@Produces(MediaType.APPLICATION_JSON)
	public String clearSession(@Context HttpServletRequest request) {
		SessionUtility sessionUtility = new SessionUtility();

		boolean session = sessionUtility.destroySession(request);
		if (session) {
			return "Session Clear";
		} else
			return "Session Not Clear";
	}
	
	@POST
	@Path("/details")
	@Produces(MediaType.APPLICATION_JSON)
	public EmpVo employeeDetails(String empId,
			@Context HttpServletRequest request) throws SQLException {
//		EmpDao empDao = new EmpDao();
	EmployeeDeligate deligate= new EmployeeDeligate();
//	EmpVo empVo=new EmpVo();
//		empVo= empDao.empInfoResult(empId);
		return deligate.empDetailsDeligate(empId);
//return empVo;
	}
	
}
