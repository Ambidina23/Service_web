import { Routes } from "@angular/router"
import { GalleryComponent } from "./app/gallery/gallery.component"
import { ImageDetailComponent } from "./app/image/image-detail.component"
import { GererPictureComponent } from "app/gerer-picture/gerer-picture.component";
import { RechercherPicturesComponent } from "./app/rechercher-pictures/rechercher-pictures.component";
import { AjouterPictureComponent } from "./app/ajouter-picture/ajouter-picture.component";
import { AfficherPicturesComponent } from "app/afficher-pictures/afficher-pictures.component";


export const appRoutes:Routes = [
  { path: "gallery", component: GalleryComponent },
  { path: "image/:id", component: ImageDetailComponent },
  { path: "gerer-picture", component: GererPictureComponent },
  { path: "rechercher-pictures", component: RechercherPicturesComponent },
  { path: "ajouter-picture", component: AjouterPictureComponent },
  { path: "afficher-pictures", component: AfficherPicturesComponent },
  { path: "", redirectTo: "/app", pathMatch: 'full' },
]
