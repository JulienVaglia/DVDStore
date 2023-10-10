import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { VenteModel } from '../admin/sales/sale-list/sale-list.component';
import { environment } from 'src/environments/environment';
import { AuthService } from './auth.service';

@Injectable({
  providedIn: 'root'
})
export class SalesService {

  constructor( private http: HttpClient, private auth: AuthService) { }

  vente: Array<VenteModel> = [];
  venteModel: any;

// { headers: {'Authorization': `Bearer ${this.auth.getToken()!.token}`}} permet de remplir le header avec le token pour débloquer le chemin vers le back sécurisé

// CREATE

addSale(venteModel: any, id: any = null): Observable<any> 
  {
        return this.http.post( environment.BASE_URL_API + 'ventes', venteModel, { headers: {'Authorization': `Bearer ${this.auth.getToken()!.token}`}});
  }



// UPDATE

updateSale(venteModel: any, id: any = null): Observable<any> 
  {
      return this.http.put( environment.BASE_URL_API + 'ventes/'+ venteModel.id, venteModel, { headers: {'Authorization': `Bearer ${this.auth.getToken()!.token}`}});
  }



// READ

getAllSale(): Observable<Array<VenteModel>>  
{
  console.log(this.auth.getToken()!.token);
  
  return this.http.get( environment.BASE_URL_API + 'ventes',{ headers: {'Authorization': `Bearer ${this.auth.getToken()!.token}`}}) as Observable<Array<VenteModel>>
}


getOneSale(id: number): Observable<any> 
{
  return this.http.get( environment.BASE_URL_API + 'ventes/'+id, { headers: {'Authorization': `Bearer ${this.auth.getToken()!.token}`}}) as Observable<Array<VenteModel>>
}


//DELETE

deleteSale(id: number): Observable<any> 
  {
    return this.http.delete( environment.BASE_URL_API + 'ventes/'+id, { headers: {'Authorization': `Bearer ${this.auth.getToken()!.token}`}})
  }


}
