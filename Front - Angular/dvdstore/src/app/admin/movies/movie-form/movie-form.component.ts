import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { GenresService } from 'src/app/_services/genres.service';
import { MoviesService } from 'src/app/_services/movies.service';
import { HttpClient } from '@angular/common/http';

export interface GenreModel {
  id?: number,
  genre: String;
}

@Component({
  selector: 'app-movie-form',
  templateUrl: './movie-form.component.html',
  styleUrls: ['./movie-form.component.css'],

})
export class MovieFormComponent {

  constructor(private httpGenre: GenresService, private httpMovie: MoviesService, private route: ActivatedRoute, private http: HttpClient, private router: Router) { }

  genres: Array<GenreModel> = [];
  id: any = 0;

  movieModel: any =
    {
      id: 0,
      name: '',
      genre: '',
      quantity: '',
      price: '',
      photo: '',
      description: '',
    }


  addMovie() {
    
    this.id = this.route.snapshot.paramMap.get('id')
    
    if (this.id) 
    {
      this.httpMovie.updateMovie(this.movieModel).subscribe({

            next: (data) => 
              { this.movieModel = data, console.log(data),
                this.router.navigate(['movie_detail/' + this.id ])
              },
            error: (err: Error) => console.log('Erreur : ' + err),
            complete: () => { console.log('Modification réussie') }

          })
    }
    else
    {
      this.httpMovie.addMovie(this.movieModel).subscribe({

        next: (data) => 
          { this.movieModel = data, console.log(data),
            this.router.navigate(['movie_list'])
          },
        error: (err: Error) => console.log('Erreur : ' + err),
        complete: () => { console.log('Ajoût de film réussi') }

      })
    }
    
  }


  ngOnInit(): void {

    this.id = this.route.snapshot.paramMap.get('id')

    this.httpGenre.getAllGenre().subscribe({      
      next: (data) => { this.genres = data,console.table(data)},
      error: (err: Error) => console.log('Erreur : ' + err),
      complete: () => console.log('ngOnInitGenre complet'),
    })

    if (this.id != null) {

      this.http.get('http://localhost:9000/dvds/' + this.id).subscribe({

        next: (data) => { this.movieModel = data, console.table(data) },
        error: (err: Error) => console.log('Erreur : ' + err),
        complete: () => console.log('ngOnInit complet')

      })
    }
    
  }

}
