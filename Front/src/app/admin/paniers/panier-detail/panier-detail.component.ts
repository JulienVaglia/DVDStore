import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { PaniersService } from 'src/app/_services/paniers.service';

export interface DvdModelList
{
  id?: number,
  dvd_id: number,
  quantite: number,
  panier_id: number
}

export interface PanierModelList
{
  id?: number,
  client_id: number,
  date_validation: Date,
  montant: number,
  dvds: []
}

@Component({
  selector: 'app-panier-detail',
  templateUrl: './panier-detail.component.html',
  styleUrls: ['./panier-detail.component.css']
})
export class PanierDetailComponent {

  constructor ( private http: PaniersService, private router: Router, private route: ActivatedRoute){}

  id: any ='';
  paniers : Array<PanierModelList> = [];
  panier : any =
    {
      id:'',
      client_id: '',
      date_validation: '',
      montant: '',
      dvds:[]
    }

    dvd : any =
    {
      id: '',
      dvd_id: '',
      quantite: '',
      panier_id: ''
    }
  

    ngOnInit() 
{
  this.id = this.route.snapshot.paramMap.get('id');
  this.http.getOnePanier(this.id).subscribe({

    next: (data) => { this.panier = data, console.table(this.panier.dvds) },
    error: (err: Error) => console.log('Erreur : ' + err),
    complete: () => console.log('ngOnInit complet')

  })
}

  deleteDvd(id: any){
    this.http.deleteDvd(id).subscribe({

    next: () => 
      {
        let index = this.panier.dvds.findIndex((value: any) => value.id === id)
        // Permet de cibler l'index de la ligne a supprimer 
        this.panier.dvds.splice(index,1)
        // Permet de supprimer la ligne ciblée 
      },
    error: (err: Error) => console.log('Observer got an error: ' + err),
    complete: () => console.log('Suppression ok')

  });
}

}
