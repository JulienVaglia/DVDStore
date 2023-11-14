import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ActivatedRoute, Router } from '@angular/router';
import { MoviesService } from 'src/app/_services/movies.service';

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

  constructor(private http: HttpClient, private route: ActivatedRoute, private httpMovie: MoviesService, private router: Router) { }


  ngOnInit() 
    {
      console.log(this.dvd);
      this.id = this.route.snapshot.paramMap.get('id');
      this.httpMovie.getOneDvd(this.id).subscribe({


        
        next: (data) => { this.dvd = data, console.table(data) },
        error: (err: Error) => console.log('Erreur : ' + err),
        complete: () => console.log('ngOnInit complet')

      })
    }


  deleteMovie(id: any)
    {
      console.log(id);     
      this.httpMovie.deleteMovie(id).subscribe({

      next: (data) => 
        { this.dvd = data, 
          console.log(data),
          this.router.navigate(['movie_list'])
        },
      error: (err: Error) => console.log('Erreur : ' + err),
      complete: () => console.log('Supression effectuée')

    })
    }


}
