import { NgModule }      from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpModule } from '@angular/http';

import { AppComponent }  from './app.component';
import {LoginComponent} from './login/login.component';
import {FormsModule, ReactiveFormsModule } from '@angular/forms';
import {RegisterComponent} from './register/register.component';
import {routing} from './app.routing';
import {LoginService} from './login/login.service';
import {RegisterService} from './register/register.service';
import { MainPageComponent} from './mainpage/mainpage.component';
import {LeaveModule} from './leave/leave.module';
import {AuthGuard} from './authguard';
import {DetailsService} from "./details.service";

@NgModule({
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    routing,
    ReactiveFormsModule,
    LeaveModule
  ],
  declarations: [ AppComponent, LoginComponent, RegisterComponent, MainPageComponent ],
  providers: [LoginService, RegisterService, AuthGuard, LoginComponent, DetailsService],
  bootstrap:    [ AppComponent ]
})
export class AppModule { }
