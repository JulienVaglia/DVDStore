import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { LogInModel } from '../auth/login/login.component';


@Injectable({
  providedIn: 'root'
})
export class AuthService {


  loginModel: any;

  constructor(private http: HttpClient) { }


// LogIn

  login(loginModel: string): Observable<any> {
    return this.http.post('http://localhost:9000/authorize', loginModel);
  }


// Gestion du token :

  // Enregistrer le token dans le sessionStorage
  setToken(userLogged: any) {
    
    sessionStorage.setItem('authToken', JSON.stringify(userLogged));
    console.log(userLogged);
    console.log("Ajout sessionStorage ok");
    
  }

  // Obtenenir le token depuis le sessionStorage
  getToken(): string | null {
    return sessionStorage.getItem('authToken');
  }

  // Supprimer le token du sessionStorage lors de la déconnexion
  logout() {
    sessionStorage.removeItem('authToken');
  }
}
