import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { DvdModel } from '../admin/movies/movie-list/movie-list.component';


@Injectable({
  providedIn: 'root'
})
export class MoviesService {

  constructor(private http: HttpClient) { }

  dvd: Array<DvdModel> = [];
  movieModel: any;

//CREATE

addMovie(movieModel: any, id: any = null): Observable<any> 
  {
        return this.http.post('http://localhost:9000/dvds', movieModel);
  }

//UPDATE

updateMovie(movieModel: any, id: any = null): Observable<any> 
  {
      return this.http.put('http://localhost:9000/dvds'+ movieModel.id, movieModel);
  }
    
// READ

  getAllDvd(): Observable<Array<DvdModel>> 
  
    {

      return this.http.get('http://localhost:9000/dvds') as Observable<Array<DvdModel>>

    }

  getOneDvd(id: number): Observable<Array<DvdModel>> 

    {
      return this.http.get('http://localhost:9000/dvds/'+id) as Observable<Array<DvdModel>>
    }


//DELETE

    deleteMovie(id: number): Observable<any> 
      {
        return this.http.delete('http://localhost:9000/dvds/'+id)
      }

}
