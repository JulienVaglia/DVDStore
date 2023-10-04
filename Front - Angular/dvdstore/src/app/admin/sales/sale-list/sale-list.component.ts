import { Component } from '@angular/core';
import { AfterViewInit, ViewChild } from '@angular/core';
import { MatPaginator, MatPaginatorModule } from '@angular/material/paginator';
import { MatTableDataSource, MatTableModule } from '@angular/material/table';
import { ActivatedRoute } from '@angular/router';
import { SalesService } from 'src/app/_services/sales.service';
import { CommonModule } from '@angular/common';

export interface VenteModel {
  id?: number,
  date: Date,
  montant: number,
  id_dvd: number,
  id_client: number,
  quantity: number;
}

const ELEMENT_DATA: VenteModel[] =
  [{
    date: new Date(),
    montant: 0,
    id_dvd: 0,
    id_client: 0,
    quantity: 0
  }];


@Component({
  selector: 'app-sale-list',
  templateUrl: './sale-list.component.html',
  styleUrls: ['./sale-list.component.css'],
  standalone: true,
  imports: [
    MatTableModule,
    MatPaginatorModule,
    CommonModule
  ]

})
export class SaleListComponent implements AfterViewInit {

  dataSource: any = []
  ventes: VenteModel[] = [];


  displayedColumns: string[] = ['Date', 'Montant', 'DVD', 'Client', 'Quantité', 'Détails'];

  @ViewChild(MatPaginator)
  paginator!: MatPaginator;

  constructor( private route: ActivatedRoute, private http: SalesService) { }


  ngOnInit(): void {

    this.http.getAllSale().subscribe({
      next: (data) => {this.ventes = data.reverse(), // Afficher la dernière entrée en premier dans le tableau gâce a ".reverse()"
        console.table(data)
        this.dataSource = new MatTableDataSource<VenteModel>(this.ventes);
        this.dataSource.paginator = this.paginator;
        this.dataSource.paginator.length = this.ventes.length;
      },
      error: (err: Error) => console.log('Erreur : ' + err),
      complete: () => console.log()
    })
      ;
  }
  //--------------- Tableaux Matérials ---------------
  ngAfterViewInit() {

  }





/*

                            
                            
                            [(ngModel)]="venteModel.id_client"*/

}





