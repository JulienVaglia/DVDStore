import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminLayoutComponent } from './admin-layout/admin-layout.component';
import { HomeComponent } from './home/home.component';
import { MovieListComponent } from './movies/movie-list/movie-list.component';
import { MovieFormComponent } from './movies/movie-form/movie-form.component';
import { UserListComponent } from './users/user-list/user-list.component';
import { UserFormComponent } from './users/user-form/user-form.component';
import { SaleListComponent } from './sales/sale-list/sale-list.component';
import { SaleFormComponent } from './sales/sale-form/sale-form.component';
import { MovieDetailComponent } from './movies/movie-detail/movie-detail.component';

const routes: Routes = [

    {path: '', component: AdminLayoutComponent, children: [  // Sert de sous-routing afin d'afficher le layout (visuel) adapté à l'admin

      {path: '', component: HomeComponent},
      {path: 'movie_list', component: MovieListComponent},
      {path: 'movie_form', component: MovieFormComponent},
      {path: 'movie_detail/:id', component: MovieDetailComponent},
      {path: 'sale_list', component: SaleListComponent},
      {path: 'sale_form', component: SaleFormComponent},
      {path: 'user_list', component: UserListComponent},
      {path: 'user_form', component: UserFormComponent}

    ]}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AdminRoutingModule { }
