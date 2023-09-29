import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ClientsService } from 'src/app/_services/clients.service';

export interface ClientModel{
  id? : number,
  nom : string,
  prenom : string,
  adresse : string;
}

@Component({
  selector: 'app-client-list',
  templateUrl: './client-list.component.html',
  styleUrls: ['./client-list.component.css']
})
export class ClientListComponent {

  constructor( private http : ClientsService, private route: ActivatedRoute ){}


  clients : Array<ClientModel> = [];
  clientToShow: Array<ClientModel> = [];

ngOnInit(): void 
{
this.http.getAllClients().subscribe({

  next: (data) => {this.clients = data, console.table(data);},
  error: (err: Error) => console.log('Erreur : ' + err),
  complete: () =>  this.clientToShow=this.clients
  })
}

deleteClient(id: any){
  this.http.deleteClient(id).subscribe({

    next: (data) => {this.clients = data, console.table(data);},
    error: (err: Error) => console.log('Observer got an error: ' + err),
    complete: () => console.log('Suppression ok')

  });
}

// choixClient = (genre : string) => {
//   this.clientToShow = this.clients.filter((value) => {
//       return value.name === name
//   })
// }



}
