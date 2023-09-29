import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { ClientModel } from '../admin/clients/client-list/client-list.component';

@Injectable({
  providedIn: 'root'
})
export class ClientsService {

  constructor( private http: HttpClient) { }

  client: Array<ClientModel> = [];
  clientModel: any;

//CREATE - UPDATE

addClient(clientModel: any, id: any = null): Observable<any> {

  if( clientModel.id != null )
    {
      return this.http.put('http://localhost:9000/clients/' + clientModel.id, clientModel);
    }
  else
    {
      return this.http.post('http://localhost:9000/clients', clientModel);
    }
}


// READ

getAllClients(): Observable<Array<ClientModel>> 
  
{

  return this.http.get('http://localhost:9000/clients') as Observable<Array<ClientModel>>

}

getOneClient(id: number): Observable<Array<ClientModel>> 

{
  return this.http.get('http://localhost:9000/clients/'+id) as Observable<Array<ClientModel>>
}


//DELETE

deleteClient(id: number): Observable<any> 
  {
    return this.http.delete('http://localhost:9000/clients/'+id)
  }

}
