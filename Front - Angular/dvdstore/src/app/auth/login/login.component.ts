import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/_services/auth.service';

//Interface LogIn
 export interface ICredential {
  username: string,
  password: string;
}

export interface IToken {
  username: string,
  token: string;
}

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
  standalone:true,
  imports:[FormsModule]

})
export class LoginComponent {

loginModel: ICredential =
  {
    username: '',
    password: '',
  }

userLogged: IToken =
  {
    username: '',
    token: '',
  }

constructor(private httpLogIn: AuthService, private route: Router){}


logIn() {

  this.httpLogIn.login(this.loginModel).subscribe({
    next: (data) => { 
      this.userLogged.username = this.loginModel.username; 
      this.userLogged.token = data.token;
      this.httpLogIn.setToken(this.userLogged); 
      this.route.navigate([''])
    },
    error: (err: Error) => console.log('Erreur : ' + err),
    complete: () => { console.log('LogIn réussi') }
  });
}

}
