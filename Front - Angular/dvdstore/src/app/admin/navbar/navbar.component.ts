import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/_services/auth.service';


@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent {

  constructor(private httpLogout: AuthService, private route: Router){}

  logout()
  {
    this.httpLogout.logout();
    this.route.navigate(['']);
  }

}
