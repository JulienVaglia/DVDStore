import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { AuthService } from 'src/app/_services/auth.service';
import { HttpClient } from '@angular/common/http';

//Interface Vente
export interface RegisterModel {
  id?: number,
  username: string,
  password: string,
}

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent {

  registerModel: any =
  {
    username: '',
    password: '',
  }

constructor( private route: ActivatedRoute, private router: Router, private httpRegister: AuthService, private http: HttpClient){}

register()
  {
    
  }


}
