import { Component } from '@angular/core';
import { PaniersService } from 'src/app/_services/paniers.service';

export interface PanierModelList
{
  id?: number,
  client_id: number,
  date_validation: Date,
  montant: number,
  dvds: []
}


@Component({
  selector: 'app-panier-list',
  templateUrl: './panier-list.component.html',
  styleUrls: ['./panier-list.component.css']
})
export class PanierListComponent {

  constructor ( private http: PaniersService){}

  paniers : Array<PanierModelList> = [];
  panier : any =
    {
      id:'',
      client_id: '',
      date_validation: '',
      montant: ''
    }

    ngOnInit(): void {
      this.http.getAllPanier().subscribe({
  
      next: (data) => {this.paniers = data, console.table(data);},
      error: (err: Error) => console.log('Erreur : ' + err),
      complete: () => console.log('ngOnInit complet')
      })
    }

}
