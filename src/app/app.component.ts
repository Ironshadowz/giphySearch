import { Component, ElementRef, ViewChild } from '@angular/core';
import { GiphySearchService } from './giphy-search.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent
{
  @ViewChild('q')
  qCtrl! : ElementRef
  urls : string[] = [];
  constructor(private giphyService:GiphySearchService){}
  ngAfterViewInit() :void
  {

  }
  search()
  {

  }
}
