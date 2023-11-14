import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { GenreModelList } from '../admin/genres/genre-list/genre-list.component';
import { environment } from 'src/environments/environment';
import { AuthService } from './auth.service';

@Injectable({
  providedIn: 'root'
})
export class GenresService {

  constructor(private http: HttpClient, private auth: AuthService) { }

  genres: Array<GenreModelList> = [];
  genreModel: any;

  
// CREATE

  addGenre(genreModel: any)
    {     

      return this.http.post( environment.BASE_URL_API + 'categories', genreModel,{ headers: {'Authorization': `Bearer ${this.auth.getToken()?.token}`}});
      
    }



// READ

  getAllGenre(): Observable<Array<GenreModelList>>

    { 
      console.log(this.auth.getToken()!.token);
      return this.http.get( environment.BASE_URL_API + 'categories', { headers: {'Authorization': `Bearer ${this.auth.getToken()?.token}`}}) as Observable<Array<GenreModelList>>;
    }

  getOneGenre(id: number): Observable<Array<GenreModelList>> 

    {
      return this.http.get( environment.BASE_URL_API + 'categories/'+id,{ headers: {'Authorization': `Bearer ${this.auth.getToken()?.token}`}}) as Observable<Array<GenreModelList>>;
    }


// DELETE

  deleteGenre(id: number): Observable<Array<GenreModelList>>
  {
    return this.http.delete( environment.BASE_URL_API + 'categories/'+id,{ headers: {'Authorization': `Bearer ${this.auth.getToken()?.token}`}}) as Observable<Array<GenreModelList>>;
  }

}
