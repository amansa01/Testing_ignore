import { NgModule }      from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpModule } from '@angular/http';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {routing} from '../app.routing';
import {LeaveApplyComponent} from './leaveapply/leaveapply.component';
import {LeaveHistoryComponent} from './leavehistory/leavehistory.component';
import {LeaveHistoryService} from './leavehistory/leavehistoryservice';
import {LeaveApplyService} from './leaveapply/leaveapply.service';
import {LeaveCancelComponent} from './leavecancel/leavecancel.component';
import {LeaveCancelService} from "./leavecancel/leavecancelservice";



@NgModule({
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    routing,
    ReactiveFormsModule
  ],
  declarations: [  LeaveApplyComponent, LeaveHistoryComponent, LeaveCancelComponent],
  providers: [  LeaveApplyService, LeaveHistoryService, LeaveCancelService],

})
export class LeaveModule { }
