import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { GenresService } from 'src/app/_services/genres.service';
import { MoviesService } from 'src/app/_services/movies.service';
import { GenreModel } from '../movie-form/movie-form.component';

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
export class MovieListComponent {


  constructor( private http : MoviesService, private route: ActivatedRoute, private httpGenre: GenresService ) {}

 
  dvds : Array<DvdModel> = [];
  genres: Array<GenreModel> = [];
  dvdToShow: Array<DvdModel> = [];

  ngOnInit(): void {
    
    this.http.getAllDvd().subscribe({

    next: (data) => {this.dvds = data, console.table(data);},
    error: (err: Error) => console.log('Erreur : ' + err),
    complete: () =>  this.dvdToShow=this.dvds
    })

     this.httpGenre.getAllGenre().subscribe({
      next: (data) => 
      { this.genres = data, 
        console.table(data)
      },
      error: (err: Error) => console.log('Erreur : ' + err),
      complete: () => console.log()
    })
    ;  
  }

  choixGenre = (genre : string) => {
    this.dvdToShow = this.dvds.filter((value) => {
        return value.genre === genre
    })
}

}


