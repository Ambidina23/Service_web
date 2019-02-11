import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-ajouter-picture',
  templateUrl: './ajouter-picture.component.html',
  styleUrls: ['./ajouter-picture.component.css']
})
export class AjouterPictureComponent implements OnInit {
 onFileSelected(event){
   console.log(event);
 }
  constructor() { }

  ngOnInit() {
  }

}

