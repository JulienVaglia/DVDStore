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


const routes: Routes = [

    {path: '', component: AdminLayoutComponent, children: [  // Sert de sous-routing afin d'afficher le layout (visuel) adapté à l'admin

      {path: '', component: HomeComponent},

      {path: 'movie_list', component: MovieListComponent},
      {path: 'movie_form', component: MovieFormComponent},
      {path: 'movie_form/:id', component: MovieFormComponent},
      {path: 'movie_detail/:id', component: MovieDetailComponent},

      {path: 'sale_list', component: SaleListComponent},
      {path: 'sale_form', component: SaleFormComponent},
      {path: 'sale_form/:id', component: SaleFormComponent},
      {path: 'sale_detail/:id', component: SaleDetailComponent},

      {path: 'client_list', component: ClientListComponent},
      {path: 'client_form', component: ClientFormComponent},
      {path: 'client_form/:id', component: ClientFormComponent},
      {path: 'client_detail/:id', component: ClientDetailComponent},
      
      {path: 'genre_form', component: GenreFormComponent}

    ]}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AdminRoutingModule { }
