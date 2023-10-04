import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { GenreModelList } from '../admin/genres/genre-list/genre-list.component';

@Injectable({
  providedIn: 'root'
})
export class GenresService {

  constructor(private http: HttpClient) { }

  genres: Array<GenreModelList> = [];
  genreModel: any;

  
// CREATE

  addGenre(genreModel: any)
    {
      return this.http.post('http://localhost:9000/categories', genreModel);
    }



// READ

  getAllGenre(): Observable<Array<GenreModelList>>

    { 
      return this.http.get('http://localhost:9000/categories') as Observable<Array<GenreModelList>>;
    }

  getOneGenre(id: number): Observable<Array<GenreModelList>> 

    {
      return this.http.get('http://localhost:9000/categories/'+id) as Observable<Array<GenreModelList>>;
    }


// DELETE

  deleteGenre(id: number): Observable<Array<GenreModelList>>
  {
    return this.http.delete('http://localhost:9000/categories/'+id) as Observable<Array<GenreModelList>>;
  }

}
