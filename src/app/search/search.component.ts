import { Component, inject } from '@angular/core';
import { GiphySearchService } from '../giphy-search.service';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent
{
  constructor(private giphyService:GiphySearchService){}
  results : string[] = [];
  status="";

  search(item:string): any
  {
    this.giphyService.searchByPromise(item)
      .then
      ( re=>
        {
          this.results=re;
          console.log(this.results);
          
        }
      )
      .catch
      (
        err=>
        {
          this.status="Failed"+JSON.stringify(err);
          return null;
        }
      );
  }


}
