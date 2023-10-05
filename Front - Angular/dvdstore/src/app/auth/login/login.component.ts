import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { AuthService } from 'src/app/_services/auth.service';

//Interface LogIn
export interface LogInModel {
  id?: number,
  username: string,
  password: string;
}

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
  standalone:true,
  imports:[FormsModule]

})
export class LoginComponent {

loginModel: any =
  {
    username: '',
    password: '',
  }
userLogged: any =
  {
    username: '',
    token: '',
  }

constructor(private httpLogIn: AuthService){}


logIn()
{
  console.log(this.loginModel);
  
  this.httpLogIn.login(this.loginModel).subscribe({

    next: (data) => { 
      this.userLogged.username = data.user.login, 
      this.userLogged.token = data.token,
      console.table(data), this.httpLogIn.setToken(this.userLogged) },
    error: (err: Error) => console.log('Erreur : ' + err),
    complete: () => { console.log('LogIn réussi') }

  })
}

}
