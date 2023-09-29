import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { VenteModel } from '../admin/sales/sale-list/sale-list.component';

@Injectable({
  providedIn: 'root'
})
export class SalesService {

  constructor( private http: HttpClient) { }

  vente: Array<VenteModel> = [];
  venteModel: any;

// CREATE

addSale(venteModel: any, id: any = null): Observable<any> 
  {
        return this.http.post('http://localhost:9000/ventes', venteModel);
  }



// UPDATE

updateSale(venteModel: any, id: any = null): Observable<any> 
  {
      return this.http.put('http://localhost:9000/ventes'+ venteModel.id, venteModel);
  }



// READ

getAllSale(): Observable<Array<VenteModel>> 
  
{

  return this.http.get('http://localhost:9000/ventes') as Observable<Array<VenteModel>>

}

getOneSale(id: number): Observable<Array<VenteModel>> 

{
  return this.http.get('http://localhost:9000/ventes/'+id) as Observable<Array<VenteModel>>
}



//DELETE

deleteSale(id: number): Observable<any> 
  {
    return this.http.delete('http://localhost:9000/ventes/'+id)
  }


}
