import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ClientsService } from 'src/app/_services/clients.service';
import { HttpClient } from '@angular/common/http';

export interface ClientModel {
  id?: number,
  nom: String,
  prenom: String,
  adresse: String;
}

@Component({
  selector: 'app-client-form',
  templateUrl: './client-form.component.html',
  styleUrls: ['./client-form.component.css']
})
export class ClientFormComponent {

  constructor(private httpClient: ClientsService, private route: ActivatedRoute, private http: HttpClient, private router: Router) { }

  clients: Array<ClientModel> = [];
  id: any = 0;

  clientModel: any =
    {
      id: 0,
      nom: '',
      prenom: '',
      adresse: '',
    }

    addClient() {

      this.id = this.route.snapshot.paramMap.get('id')

      if (this.id) 
          {
            this.httpClient.addClient(this.clientModel).subscribe({
      
                  next: (data) => { this.clientModel = data, console.log(data), this.router.navigate(['client_detail/' + this.id ])},
                  error: (err: Error) => console.log('Erreur : ' + err),
                  complete: () => { console.log('Modification réussie') }
            
                })
          }
      else
          {
          this.httpClient.addClient(this.clientModel).subscribe({
      
            next: (data) => { this.clientModel = data, console.log(data), this.router.navigate(['client_list'])},
            error: (err: Error) => console.log('Erreur : ' + err),
            complete: () => { console.log('Ajoût réussi') }
      
          })
          }

    }



    ngOnInit(): void {

      this.id = this.route.snapshot.paramMap.get('id')

      if (this.id != null) // si un ID on charge getOneClient
        {
    
          this.httpClient.getOneClient(this.id).subscribe({
            next: (data) => { this.clientModel = data, console.table(data) },
            error: (err: Error) => console.log('Erreur : ' + err),
            complete: () => console.log('ngOnInitClient complet')
          })

        }
      else // si pas d'ID on charge getAllClients
        {
            this.httpClient.getAllClients().subscribe({
          next: (data) => { this.clients = data, console.table(data)},
          error: (err: Error) => console.log('Erreur : ' + err),
          complete: () => console.log('ngOnInitAllClients complet'),
        })
        }
      
    }

}
