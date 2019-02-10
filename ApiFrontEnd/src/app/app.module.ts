import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { RouterModule } from '@angular/router';

import { ImageService } from './image/shared/image.service';
import { ImageFilterPipe } from './image/shared/filter.pipe';
import { AppComponent } from './app.component';
import { GalleryComponent } from './gallery/gallery.component';
import { ImageComponent } from './image/image.component';
import { ImageDetailComponent } from './image/image-detail.component';
import { NavbarComponent } from './navbar/navbar.component';
//importe les services routes dans app.module
import { appRoutes } from '../routes';
import { GererPictureComponent } from './gerer-picture/gerer-picture.component';
import { RechercherPicturesComponent } from './rechercher-pictures/rechercher-pictures.component';
import { AjouterPictureComponent } from './ajouter-picture/ajouter-picture.component';
import { AfficherPicturesComponent } from './afficher-pictures/afficher-pictures.component';



@NgModule({
  declarations: [
    AppComponent,
    GalleryComponent,
    ImageComponent,
    NavbarComponent,
      ImageDetailComponent,
      ImageFilterPipe,
      GererPictureComponent,
      RechercherPicturesComponent,
      AjouterPictureComponent,
      AfficherPicturesComponent,
     
 
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    RouterModule.forRoot(appRoutes)
  ],
  providers: [ImageService, ImageFilterPipe],
  bootstrap: [AppComponent]
})
export class AppModule { }
