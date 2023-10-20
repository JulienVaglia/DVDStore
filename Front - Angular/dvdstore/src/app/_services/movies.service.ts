import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { DvdModel } from '../admin/movies/movie-list/movie-list.component';
import { environment } from 'src/environments/environment';
import { AuthService } from './auth.service';


@Injectable({
  providedIn: 'root'
})
export class MoviesService {

  constructor(private http: HttpClient, private auth: AuthService) { }

  dvd: Array<DvdModel> = [];
  movieModel: any;

//CREATE

addMovie(movieModel: any, id: any = null): Observable<any> 
  {
        return this.http.post( environment.BASE_URL_API + '/admin/dvds', movieModel, { headers: {'Authorization': `Bearer ${this.auth.getToken()!.token}`}});
  }

//UPDATE

updateMovie(movieModel: any, id: any = null): Observable<any> 
  {
      return this.http.put( environment.BASE_URL_API + '/admin/dvds'+ movieModel.id, movieModel, { headers: {'Authorization': `Bearer ${this.auth.getToken()!.token}`}});
  }
    
// READ

  getAllDvd(): Observable<Array<DvdModel>> 
  
    {

      return this.http.get( environment.BASE_URL_API + 'dvds',{ headers: {'Authorization': `Bearer ${this.auth.getToken()!.token}`}}) as Observable<Array<DvdModel>>

    }

  getOneDvd(id: number): Observable<Array<DvdModel>> 

    {
      return this.http.get( environment.BASE_URL_API + 'dvds/'+id, { headers: {'Authorization': `Bearer ${this.auth.getToken()!.token}`}}) as Observable<Array<DvdModel>>
    }


//DELETE

    deleteMovie(id: number): Observable<any> 
      {
        return this.http.delete( environment.BASE_URL_API + '/admin/dvds/'+id, { headers: {'Authorization': `Bearer ${this.auth.getToken()!.token}`}})
      }

}
