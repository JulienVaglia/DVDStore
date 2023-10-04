//----Natives imports----
import { Component, ElementRef, ViewChild } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { FormsModule, NgModel } from '@angular/forms';
import { NgFor } from '@angular/common';
import { NgIf } from '@angular/common';

//----Components imports----
import { SalesService } from 'src/app/_services/sales.service';
import { MoviesService } from 'src/app/_services/movies.service';
import { ClientsService } from 'src/app/_services/clients.service';

//----Matérial imports----
import { MatDatepickerModule, MatDatepickerInputEvent } from '@angular/material/datepicker';
import { MatCardModule } from '@angular/material/card';
import { MatNativeDateModule } from '@angular/material/core';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';


//Interface Vente
export interface VenteModel {
  id?: number,
  date: Date,
  id_dvd: number;
  id_client: number;
  quantity: number;
}

//Interface DVD
export interface DvdModel {
  id?: number,
  name: string,
  genre: string,
  price: number,
  photo: string,
  quantity: number;
}

//Interface Client
export interface ClientModel {
  id?: number,
  nom: String,
  prenom: String,
  adresse: String;
}


@Component({
  selector: 'app-sale-form',
  templateUrl: './sale-form.component.html',
  styleUrls: ['./sale-form.component.css'],
  standalone: true,
  imports: [
    MatCardModule,
    MatDatepickerModule,
    MatNativeDateModule,
    FormsModule,
    NgFor,
    MatFormFieldModule,
    MatInputModule,
    NgIf
  ],
})



export class SaleFormComponent {

  ventes: Array<VenteModel> = [];
  id: any = 0;

  venteModel: any =
    {
      id: 0,
      date: new Date(),
      id_dvd: 0,
      id_client: 0,
      quantity: 0,
    }

  dvds: Array<DvdModel> = [];
  clients: Array<ClientModel> = [];
  id_client = 0;
  id_dvd = 0;

  events: string[] = [];

  constructor(private httpSale: SalesService, private route: ActivatedRoute, private http: HttpClient, private router: Router, private httpService: MoviesService, private httpClient: ClientsService) { }

  ngOnInit(): void {

    this.id = this.route.snapshot.paramMap.get('id')
    console.log(this.id);

    this.httpService.getAllDvd().subscribe({

      next: (data) => { this.dvds = data, console.table(data); },
      error: (err: Error) => console.log('Erreur : ' + err),
      complete: () => console.log('ngOnInitAllDvds complet')
    })

    this.httpClient.getAllClients().subscribe({
      next: (data) => { this.clients = data, console.table(data) },
      error: (err: Error) => console.log('Erreur : ' + err),
      complete: () => console.log('ngOnInitAllClients complet'),
    })

    if (this.id != null) // si un ID on charge getOneSale
    {

      this.httpSale.getOneSale(this.id).subscribe({
        next: (data) => { this.venteModel = data, console.table(data) },
        error: (err: Error) => console.log('Erreur : ' + err),
        complete: () => console.log('ngOnInitOneSale complet')
      })

    }
    else // si pas d'ID on charge getAllSale
    {
      this.httpSale.getAllSale().subscribe({
        next: (data) => { this.ventes = data, console.table(data) },
        error: (err: Error) => console.log('Erreur : ' + err),
        complete: () => console.log('ngOnInitAllSales complet')
      })
    }

  }


  addEvent(type: string, event: MatDatepickerInputEvent<Date>) {
    this.events.push(`${type}: ${event.value}`);
  }


  addSale() {

    this.id = this.route.snapshot.paramMap.get('id')
    console.log(this.venteModel);

    if (this.id) {
      this.venteModel.date = new Date(this.venteModel.date)
      this.httpSale.updateSale(this.venteModel).subscribe({

        next: (data) => { this.venteModel = data, console.log(data), this.router.navigate(['sale_detail/' + this.id]) },
        error: (err: Error) => console.log('Erreur : ' + err),
        complete: () => { console.log('Modification réussie') }

      })
    }
    else {

      console.table(this.ventes);
      console.log(this.venteModel);
      


      this.httpSale.addSale(this.venteModel).subscribe({

        next: (data) => { this.venteModel = data, console.log(data), this.router.navigate(['sale_list']) },
        error: (err: Error) => console.log('Erreur : ' + err),
        complete: () => { console.log('Ajoût réussi') }

      })
    }

  }

}
