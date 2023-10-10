import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { ClientModel } from '../admin/clients/client-list/client-list.component';
import { environment } from 'src/environments/environment';
import { AuthService } from './auth.service';

@Injectable({
  providedIn: 'root'
})
export class ClientsService {

  constructor( private http: HttpClient, private auth: AuthService) { }

  client: Array<ClientModel> = [];
  clientModel: any;

//CREATE - UPDATE

addClient(clientModel: any, id: any = null): Observable<any> {

  if( clientModel.id != null )
    {
      return this.http.put( environment.BASE_URL_API + 'clients/' + clientModel.id, clientModel);
    }
  else
    {
      return this.http.post( environment.BASE_URL_API + 'clients', clientModel);
    }
}


// READ

getAllClients(): Observable<Array<ClientModel>> 
  
{
  
  return this.http.get( environment.BASE_URL_API + 'clients', { headers: {'Authorization': `Bearer ${this.auth.getToken()!.token}`}}) as Observable<Array<ClientModel>>

}

getOneClient(id: number): Observable<Array<ClientModel>> 

{
  return this.http.get( environment.BASE_URL_API + 'clients/'+id,{ headers: {'Authorization': `Bearer ${this.auth.getToken()!.token}`}}) as Observable<Array<ClientModel>>
}


//DELETE

deleteClient(id: number): Observable<any> 
  {
    return this.http.delete( environment.BASE_URL_API + 'clients/'+id,{ headers: {'Authorization': `Bearer ${this.auth.getToken()!.token}`}})
  }

}
