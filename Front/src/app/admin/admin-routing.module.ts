import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminLayoutComponent } from './admin-layout/admin-layout.component';
import { HomeComponent } from './home/home.component';
import { MovieListComponent } from './movies/movie-list/movie-list.component';
import { MovieFormComponent } from './movies/movie-form/movie-form.component';
import { SaleListComponent } from './sales/sale-list/sale-list.component';
import { SaleFormComponent } from './sales/sale-form/sale-form.component';
import { MovieDetailComponent } from './movies/movie-detail/movie-detail.component';
import { GenreFormComponent } from './genres/genre-form/genre-form.component';
import { ClientListComponent } from './clients/client-list/client-list.component';
import { ClientFormComponent } from './clients/client-form/client-form.component';
import { ClientDetailComponent } from './clients/client-detail/client-detail.component';
import { SaleDetailComponent } from './sales/sale-detail/sale-detail.component';
import { authGuard } from '../_helpers/auth.guard';
import { ProfilComponent } from './profil/profil/profil.component';
import { ProfilFormComponent } from './profil/profil-form/profil-form.component';
import { PanierListComponent } from './paniers/panier-list/panier-list.component';
import { PanierFormComponent } from './paniers/panier-form/panier-form.component';
import { PanierDetailComponent } from './paniers/panier-detail/panier-detail.component';


const routes: Routes = [

    {path: '', component: AdminLayoutComponent, children: [  // Sert de sous-routing afin d'afficher le layout (visuel) adapté à l'admin

      {path: '', component: HomeComponent, canActivate: [authGuard] },

      {path: 'movie_list', component: MovieListComponent, canActivate: [authGuard] },
      {path: 'movie_form', component: MovieFormComponent, canActivate: [authGuard] },
      {path: 'movie_form/:id', component: MovieFormComponent, canActivate: [authGuard] },
      {path: 'movie_detail/:id', component: MovieDetailComponent, canActivate: [authGuard] },

      {path: 'sale_list', component: SaleListComponent, canActivate: [authGuard] },
      {path: 'sale_form', component: SaleFormComponent, canActivate: [authGuard] },
      {path: 'sale_form/:id', component: SaleFormComponent, canActivate: [authGuard] },
      {path: 'sale_detail/:id', component: SaleDetailComponent, canActivate: [authGuard] },

      {path: 'client_list', component: ClientListComponent, canActivate: [authGuard] },
      {path: 'client_form', component: ClientFormComponent, canActivate: [authGuard] },
      {path: 'client_form/:id', component: ClientFormComponent, canActivate: [authGuard] },
      {path: 'client_detail/:id', component: ClientDetailComponent, canActivate: [authGuard] },
      
      {path: 'genre_form', component: GenreFormComponent, canActivate: [authGuard] },

      {path: 'profil', component: ProfilComponent, canActivate: [authGuard] },
      {path: 'profil_form/:id', component: ProfilFormComponent, canActivate: [authGuard] },

      {path: 'panier_list', component: PanierListComponent, canActivate: [authGuard] },
      {path: 'panier_form', component: PanierFormComponent, canActivate: [authGuard] },
      {path: 'panier_detail', component: PanierDetailComponent, canActivate: [authGuard] },
      {path: 'panier_detail/:id', component: PanierDetailComponent, canActivate: [authGuard] }

    ]}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AdminRoutingModule { }
