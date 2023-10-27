import { Component } from '@angular/core';
import { Platform } from '@ionic/angular';
import { AuthService } from 'src/app/_services/auth.service';

export interface IToken {
  username: string,
  token: string;
}

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})

export class HomeComponent {

  userLogged: IToken =
  {
    username: '',
    token: '',
  }

  username : any

constructor ( private authService: AuthService, public platform: Platform){}

ngOnInit()
{
  console.log(this.authService.getToken());
  this.username = this.authService.getToken()?.username
}



}
