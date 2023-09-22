import { Component } from '@angular/core';
import { HttpDvdService } from 'src/app/_services/http-dvd.service';

export interface DvdModel{
  id? : number,
  name : string,
  genre : string,
  price : number,
  photo : string,
  quantity : number;
}

@Component({
  selector: 'app-movie-list',
  templateUrl: './movie-list.component.html',
  styleUrls: ['./movie-list.component.css']
})
export class MovieListComponent{

  constructor( private http : HttpDvdService ) {}
 
  dvds : Array<DvdModel> = [];

  ngOnInit(): void {
    
    this.http.getAllDvd().subscribe({

    next: (data) => {this.dvds = data, console.table(data);},
    error: (err: Error) => console.log('Erreur : ' + err),
    complete: () => console.log('ngOnInit complet')

    })
    
    
  }

}


