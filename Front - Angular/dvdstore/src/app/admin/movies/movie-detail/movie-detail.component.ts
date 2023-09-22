import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ActivatedRoute, Router } from '@angular/router';

export interface DvdModel {
  id?: number,
  name: string,
  genre: string,
  price: number,
  photo: string,
  quantity: number;

}

@Component({
  selector: 'app-movie-detail',
  templateUrl: './movie-detail.component.html',
  styleUrls: ['./movie-detail.component.css']
})
export class MovieDetailComponent implements OnInit {

  dvds: Array<DvdModel> = [];
  dvd!: any;
  id: any = '';

  constructor(private http: HttpClient, private route: ActivatedRoute) {}
 
  
  ngOnInit(){

    this.id = this.route.snapshot.paramMap.get('id');
    this.http.get('http://localhost:9000/dvds/' + this.id).subscribe({

      next: (data) => { this.dvd = data, console.table(data)},
      error: (err: Error) => console.log('Erreur : ' + err),
      complete: () => console.log('ngOnInit complet')

  })
}

 
}
