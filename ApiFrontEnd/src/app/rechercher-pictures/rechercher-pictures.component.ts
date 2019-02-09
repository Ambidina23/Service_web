import { Component, OnInit } from '@angular/core';
import { Http } from '@angular/http';
import "rxjs/add/operator/map";

@Component({
  selector: 'app-rechercher-pictures',
  templateUrl: './rechercher-pictures.component.html',
  styleUrls: ['./rechercher-pictures.component.css']
})
export class RechercherPicturesComponent implements OnInit {
pagePhotos:any;
  constructor(private http:Http) { }

  ngOnInit() {
  }
  onSearch(dataForm){
    this.http.get("http://localhost:8080/rechercherPictures?mc="+dataForm.motCle+"&page=3")
  .map(resp=>resp.json())
  .subscribe(data=>{
    console.log(data);
   this.pagePhotos=data;

   
 
  }) 
  }
    
}
