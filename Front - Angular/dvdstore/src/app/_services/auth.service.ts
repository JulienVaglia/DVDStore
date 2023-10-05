import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { ICredential, IToken } from '../auth/login/login.component';

@Injectable({
  providedIn: 'root'
})
export class AuthService {


  loginModel: any;

  constructor(private http: HttpClient) { }


// LogIn

  login(credentials: ICredential): Observable<IToken> {
    return this.http.post<IToken>('http://localhost:9000/authorize', credentials);
  }


// Gestion du token :

  // Enregistrer le token dans le sessionStorage
  setToken(userLogged: string) {
    
    sessionStorage.setItem('authToken', JSON.stringify(userLogged   ));
    console.log(userLogged);
    
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
