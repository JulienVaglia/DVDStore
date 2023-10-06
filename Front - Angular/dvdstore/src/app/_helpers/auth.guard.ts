import { inject } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivateFn, Router, RouterStateSnapshot } from '@angular/router';
import { AuthService } from '../_services/auth.service';


export const authGuard: CanActivateFn = (route: ActivatedRouteSnapshot, state: RouterStateSnapshot) => {
  
  if (inject(AuthService).isLogged()) {
    console.log("true");
    return true
    

  }
  console.log("false");
  
  inject(Router).navigate(['/auth/login']);
  return false
  // return  inject(Router).navigate(['/auth/login']);
};
