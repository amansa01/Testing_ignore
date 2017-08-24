export interface LeaveModel {
  leaveId: String;
   empId: string ;
 fromDate: Date;
  // lastModifyTime
  reason: string;
  noDays: number;
  leaveTag: string;
  leaveStatus: string;
  toDate: Date;
}
