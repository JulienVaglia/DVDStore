import { Component } from '@angular/core';
import { AuthService } from 'src/app/_services/auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-side-menu',
  templateUrl: './side-menu.component.html',
  styleUrls: ['./side-menu.component.css']
})
export class SideMenuComponent {

  constructor(private httpLogout: AuthService, private route: Router){}

  logout()
  {
    this.httpLogout.logout();
    this.route.navigate(['']);
  }
}
