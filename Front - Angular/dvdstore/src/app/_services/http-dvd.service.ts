import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { DvdModel } from '../admin/movies/movie-list/movie-list.component';

@Injectable({
  providedIn: 'root'
})
export class HttpDvdService {

  constructor(private http: HttpClient) { }


  dvd: Array<DvdModel> = [];


  // Lecture

  getAllDvd(): Observable<Array<DvdModel>> 
  
    {

      return this.http.get('http://localhost:9000/dvds') as Observable<Array<DvdModel>>

    }

  getOneDvd(id: number): Observable<Array<DvdModel>> 

    {
      return this.http.get('http://localhost:9000/dvds/'+id) as Observable<Array<DvdModel>>
    }


}
