import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginServiceService } from '../login-service.service';
import { User } from '../user';


@Component({
  selector: 'app-login',
  templateUrl: './login.page.html',
  styleUrls: ['./login.page.scss'],
})
export class LoginPage implements OnInit {

  constructor(private router : Router, private loginService : LoginServiceService) { }

  ngOnInit() {
  }

  login() {
    var codiceVoloWeb = parseInt((document.getElementById("usernameAccesso") as HTMLInputElement).value);
    var password = (document.getElementById("passAccesso") as HTMLInputElement).value;
    this.loginService.login(new User(codiceVoloWeb, password)).subscribe(
      data => {
        console.log("Tutto bene!");
      },
      error => {
        console.log(error);
      }
    )
  }

  adminLogin() {
    var codiceVoloWeb = parseInt((document.getElementById("usernameAccesso") as HTMLInputElement).value);
    var password = (document.getElementById("passAccesso") as HTMLInputElement).value;
    this.loginService.adminLogin(new User(codiceVoloWeb, password)).subscribe(
      data => {
        console.log("Tutto bene!" + data);
      },
      error => {
        console.log(error);
      }
    )
  }
}
