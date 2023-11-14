import { Component } from '@angular/core';
import { GenresService } from 'src/app/_services/genres.service';

@Component({
  selector: 'app-genre-form',
  templateUrl: './genre-form.component.html',
  styleUrls: ['./genre-form.component.css']
})
export class GenreFormComponent {

  constructor(private http: GenresService) { }

  genreModel: any = 
    {
      genre: ''
    }

  addGenre (){
    
    this.http.addGenre(this.genreModel).subscribe({

      next: (data) => {this.genreModel = data, console.log(data);},
      error: (err: Error) => console.log('Erreur : ' + err),
      complete: () => {console.log('Ajoût réussi')}

    })
  }

}
