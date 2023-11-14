import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ActivatedRoute, Router } from '@angular/router';
import { SalesService } from 'src/app/_services/sales.service';
import { ClientModel, DvdModel } from '../sale-form/sale-form.component';

//Interface Vente
export interface VenteModel {
  id? : number,
  date: Date,
  montant: number,
  id_dvd: number,
  id_client: number,
  quantity: number
}

@Component({
  selector: 'app-sale-detail',
  templateUrl: './sale-detail.component.html',
  styleUrls: ['./sale-detail.component.css']
})
export class SaleDetailComponent implements OnInit {

  ventes: Array<VenteModel>= [];
  vente!: any;
  id: any ='';

  constructor( private http: HttpClient, private route: ActivatedRoute, private httpSale: SalesService, private router: Router ) {}

  ngOnInit() 
{
  this.id = this.route.snapshot.paramMap.get('id');
  this.httpSale.getOneSale(this.id).subscribe({

    next: (data) => { this.vente = data, console.table(data) },
    error: (err: Error) => console.log('Erreur : ' + err),
    complete: () => console.log('ngOnInit complet')

  })
}

deleteSale(id: any)
{
  console.log(id);     
  this.httpSale.deleteSale(id).subscribe({

  next: (data) => 
    { this.vente = data, 
      console.log(data),
      this.router.navigate(['sale_list'])
    },
  error: (err: Error) => console.log('Erreur : ' + err),
  complete: () => console.log('Supression effectuée')

})
}


}
