import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginServiceService } from '../login-service.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.page.html',
  styleUrls: ['./login.page.scss'],
})
export class LoginPage implements OnInit {


  user = {
    voloWeb : '',
    password : ''
  }

  constructor(private router : Router, private loginService : LoginServiceService) { }

  ngOnInit() {
  }

  login(){
    if(this.user.voloWeb != null && this.user.password != null){
      this.router.navigate(['/menu']);
    }else{
      alert('login failed!');

    }
  }

  prova(){
    this.loginService.prova().subscribe(data => {
      alert(data.codiceId);
    });
  }
}
  


