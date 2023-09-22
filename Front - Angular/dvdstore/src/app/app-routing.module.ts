import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ErrorComponent } from './_util/error/error.component';


const routes: Routes = [

  {path:'', loadChildren: () => import ('./admin/admin.module')  // Permet de charger le module "admin"
    .then(m => m.AdminModule)},

  {path:'auth', loadChildren:() => import('./auth/auth-routing.module') // Permet de charger le module "authentification"
    .then(m => m.AuthRoutingModule)},

  { path: '**', component: ErrorComponent} // Permet, en cas de route non trouvée, d'envoyer vers le component Erreur et l'image error404

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
