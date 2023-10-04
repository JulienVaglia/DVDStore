import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ActivatedRoute, Router } from '@angular/router';
import { ClientsService } from 'src/app/_services/clients.service';

export interface ClientModel 
  {
    id?: number,
    nom: string,
    prenom: string,
    adresse: String;
  }

@Component({
  selector: 'app-client-detail',
  templateUrl: './client-detail.component.html',
  styleUrls: ['./client-detail.component.css']
})

export class ClientDetailComponent implements OnInit{

clients: Array<ClientModel>= [];
client!: any;
id: any ='';

constructor( private http: HttpClient, private route: ActivatedRoute, private httpMovie: ClientsService, private router: Router ) {}

ngOnInit() 
{
  this.id = this.route.snapshot.paramMap.get('id');
  this.http.get('http://localhost:9000/clients/' + this.id).subscribe({

    next: (data) => { this.client = data, console.table(data) },
    error: (err: Error) => console.log('Erreur : ' + err),
    complete: () => console.log('ngOnInit complet')

  })
}

deleteClient(id: any)
{
  console.log(id);     
  this.httpMovie.deleteClient(id).subscribe({

  next: (data) => 
    { this.client = data, 
      console.log(data),
      this.router.navigate(['client_list'])
    },
  error: (err: Error) => console.log('Erreur : ' + err),
  complete: () => console.log('Supression effectuée')

})
}


}
