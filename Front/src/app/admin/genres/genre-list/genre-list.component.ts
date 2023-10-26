import { Component } from '@angular/core';
import { GenresService } from 'src/app/_services/genres.service';

export interface GenreModelList{
  id? : number,
  genre : String;
}

@Component({
  selector: 'app-genre-list',
  templateUrl: './genre-list.component.html',
  styleUrls: ['./genre-list.component.css']
})
export class GenreListComponent {

  constructor (private http: GenresService){}

  genres : Array<GenreModelList> = [];
  genre : any =
    {
      id:''
    }

  ngOnInit(): void {
    this.http.getAllGenre().subscribe({

    next: (data) => {this.genres = data, console.table(data);},
    error: (err: Error) => console.log('Erreur : ' + err),
    complete: () => console.log('ngOnInit complet')
    })
  }

  deleteGenre(id: any){
    this.http.deleteGenre(id).subscribe({

      next: (data) => {this.genre = data, console.log(data);},
      error: (err: Error) => console.log('Observer got an error: ' + err),
      complete: () => console.log('Suppression ok')

    });
  }

}
