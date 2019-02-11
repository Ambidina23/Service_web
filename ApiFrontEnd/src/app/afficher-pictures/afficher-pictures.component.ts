import { Component, OnInit } from '@angular/core';
import { Http } from '@angular/http';
import "rxjs/add/operator/map";

@Component({
  selector: 'app-afficher-pictures',
  templateUrl: './afficher-pictures.component.html',
  styleUrls: ['./afficher-pictures.component.css']
})
export class AfficherPicturesComponent implements OnInit {
  pagePictures:any;
  constructor(public http:Http) { }

  ngOnInit() {
    this.http.get("http://localhost:8080/pictures/1156")
    .map(resp=>resp.json())
    .subscribe(data=>{
      this.pagePictures=data;
    }, error=>{
      console.log(error);
    })
   
  }

}
