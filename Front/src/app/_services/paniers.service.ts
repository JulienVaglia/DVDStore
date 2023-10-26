import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { AuthService } from './auth.service';
import { environment } from 'src/environments/environment';
import { Observable } from 'rxjs';
import { PanierModelList } from '../admin/paniers/panier-list/panier-list.component';

@Injectable({
  providedIn: 'root'
})
export class PaniersService {

  constructor(private http: HttpClient, private auth: AuthService) { }

  paniers: Array<PanierModelList> = [];
  panierModel: any;

// READ

  getAllPanier(): Observable<Array<PanierModelList>>

    { 
      console.log(this.auth.getToken()!.token);
      return this.http.get( environment.BASE_URL_API2 + 'panier', { headers: {'Authorization': `Bearer ${this.auth.getToken()?.token}`}}) as Observable<Array<PanierModelList>>;
    }

  getOnePanier(id: number): Observable<Array<PanierModelList>> 

    {
      return this.http.get( environment.BASE_URL_API2 + 'panier/'+id,{ headers: {'Authorization': `Bearer ${this.auth.getToken()?.token}`}}) as Observable<Array<PanierModelList>>;
    }

//DELETE

  deleteDvd(id: number): Observable<any> 
{
  return this.http.delete( environment.BASE_URL_API2 + 'paniers/'+id, { headers: {'Authorization': `Bearer ${this.auth.getToken()?.token}`}})
}

}
