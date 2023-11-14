import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { ICredential, IToken } from '../auth/login/login.component';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class AuthService {


  loginModel: any;

  constructor(private http: HttpClient) { }


// LogIn
  
  login(credentials: ICredential): Observable<IToken> 
  {
    return this.http.post<IToken>( environment.BASE_URL_AUTH + 'authorize', credentials);
  }


// Gestion du token :

  // Enregistrer le token dans le sessionStorage
  setToken(userLogged: IToken) {
    
    sessionStorage.setItem('authToken', JSON.stringify(userLogged));
    console.log(userLogged);
    
  }

  // Obtenenir le token depuis le sessionStorage
  isLogged(): boolean {
    const token =  sessionStorage.getItem('authToken');
    return !! token  // Permet en cas de retour de données de le transformer en true et au contraire si null de le transformer en false afin de communiquer facilement avec le guard qui attends un booleen

  }

  getToken(): IToken | null {
    const authToken = sessionStorage.getItem('authToken');
    return authToken ? JSON.parse(authToken) : null;
  }


  // Supprimer le token du sessionStorage lors de la déconnexion
  logout(): boolean {
    const token = sessionStorage.removeItem('authToken');
    return true
    
    
  }
}
