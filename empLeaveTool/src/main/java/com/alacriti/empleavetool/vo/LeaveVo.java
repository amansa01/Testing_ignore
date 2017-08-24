package com.alacriti.empleavetool.vo;

import java.sql.Date;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonFormat;

@XmlRootElement
public class LeaveVo {
	private String leaveId;
	private Date fromDate;
	private Date toDate;
	private String Reason;
	private int noDays;
	private String leaveStatus;
	private String empId;
	private String leaveTag;
	private Date lastModifyTime;

	public LeaveVo(Date leave_to_date, Date date_applied, String emp_id,
			int no_days, String leave_reason, String leave_tag,
			String leave_id, Date last_modify_time, String leaveStatus) {
		super();
		this.fromDate = date_applied;
		this.toDate = leave_to_date;
		Reason = leave_reason;
		this.leaveStatus = leaveStatus;
		this.noDays = no_days;
		this.empId = emp_id;
		this.leaveTag = leave_tag;
		this.leaveId = leave_id;
		this.lastModifyTime = last_modify_time;
	}

	public LeaveVo() {
	}

	public String getLeaveId() {
		return leaveId;
	}

	public void setLeaveId(String leaveId) {
		this.leaveId = leaveId;
	}

	public String getLeaveTag() {
		return leaveTag;
	}

	public void setLeaveTag(String leaveTag) {
		this.leaveTag = leaveTag;
	}

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	@JsonFormat
	public Date getToDate() {
		return toDate;
	}

	@JsonFormat
	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	public String getReason() {
		return Reason;
	}

	public void setReason(String reason) {
		Reason = reason;
	}

	public int getNoDays() {
		return noDays;
	}

	public void setNoDays(int noDays) {
		this.noDays = noDays;
	}

	public String getLeaveStatus() {
		return leaveStatus;
	}

	public void setLeaveStatus(String leaveStatus) {
		this.leaveStatus = leaveStatus;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public Date getLastModifyTime() {
		return lastModifyTime;
	}

	public void setLastModifyTime(Date lastModifyTime) {
		this.lastModifyTime = lastModifyTime;
	}

}
