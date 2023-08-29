import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable, inject } from '@angular/core';
import { Observable, firstValueFrom } from 'rxjs';

const URL = "http://localhost:8080/api"
@Injectable
({
  providedIn: 'root'
})
export class GiphySearchService
{
  private http = inject(HttpClient);
  constructor() { }

  searchByPromise(item:string) : Promise<string[]>
  {
    const query = new HttpParams().set('searchItem', item);
    return firstValueFrom(this.http.get<string[]>(URL, {params:query}));
  }
  searchByObservable(item:string) : Observable<string[]>
  {
    const query = new HttpParams().set('searchItem', item);
    return this.http.get<string[]>(URL, {params:query})
  }
}
