import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ActivatedRoute, Router } from '@angular/router';
import { ClientsService } from 'src/app/_services/clients.service';

export interface ClientModel {
  id?: number,
  nom: string,
  prenom: string,
  adresse: String;
}


@Component({
  selector: 'app-profil',
  templateUrl: './profil.component.html',
  styleUrls: ['./profil.component.css']
})
export class ProfilComponent implements OnInit {

  clients: Array<ClientModel> = [];
  client!: any;
  id: any = '';


  constructor(private http: HttpClient, private route: ActivatedRoute, private httpClient: ClientsService, private router: Router) { }

  ngOnInit() {
    this.id = this.route.snapshot.paramMap.get('id');
    this.httpClient.getOneClient(this.id).subscribe({

      next: (data) => { this.client = data, console.table(data) },
      error: (err: Error) => console.log('Erreur : ' + err),
      complete: () => console.log('ngOnInit complet')

    })
  }

  deleteClient(id: any) {
    console.log(id);
    this.httpClient.deleteClient(id).subscribe({

      next: (data) => {
        this.client = data,
        console.log(data),
        this.router.navigate(['client_list'])
      },
      error: (err: Error) => console.log('Erreur : ' + err),
      complete: () => console.log('Supression effectuée')

    })
  }


}
