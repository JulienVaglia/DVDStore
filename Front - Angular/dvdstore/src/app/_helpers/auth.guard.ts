import { inject } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivateFn, Router, RouterStateSnapshot } from '@angular/router';
import { AuthService } from '../_services/auth.service';


export const authGuard: CanActivateFn = (route: ActivatedRouteSnapshot, state: RouterStateSnapshot) => {
  
  if (inject(AuthService).isLogged()) { // inject remplace import{} + constructeur dans la classe guard
    console.log("true");
    return true
  }
  
  inject(Router).navigate(['/auth/login']);
  return false
};
