import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AdminRoutingModule } from './admin-routing.module';
import { NavbarComponent } from './navbar/navbar.component';
import { FormsModule } from '@angular/forms';

//Component partie admin
import { AdminLayoutComponent } from './admin-layout/admin-layout.component';
import { SideMenuComponent } from './side-menu/side-menu.component';
import { MovieListComponent } from './movies/movie-list/movie-list.component';
import { MovieFormComponent } from './movies/movie-form/movie-form.component';
import { MovieDetailComponent } from './movies/movie-detail/movie-detail.component';
import { GenreFormComponent } from './genres/genre-form/genre-form.component';
import { ClientFormComponent } from './clients/client-form/client-form.component';
import { ClientListComponent } from './clients/client-list/client-list.component';
import { GenreListComponent } from './genres/genre-list/genre-list.component';
import { ClientDetailComponent } from './clients/client-detail/client-detail.component';

//Angular Material
import {MatIconModule} from '@angular/material/icon';
import {MatBadgeModule} from '@angular/material/badge';
import {MatButtonModule} from '@angular/material/button';
import {MatCardModule} from '@angular/material/card';
import { MatPaginatorModule} from '@angular/material/paginator';
import {MatTableModule} from '@angular/material/table';
import { SaleDetailComponent } from './sales/sale-detail/sale-detail.component';









@NgModule({
  declarations: [
    NavbarComponent,
    AdminLayoutComponent,
    // HomeComponent, déclaration en stand-alone
    SideMenuComponent,
    MovieListComponent,
    MovieFormComponent,
    MovieDetailComponent,
    GenreFormComponent,
    GenreListComponent,
    ClientFormComponent,
    ClientListComponent,
    ClientDetailComponent,
    SaleDetailComponent,

  ],
  imports: [
    CommonModule,
    AdminRoutingModule,
    MatCardModule, 
    MatButtonModule,
    MatIconModule,
    MatBadgeModule,
    MatButtonModule,
    FormsModule,
    MatPaginatorModule,
    MatTableModule,
  ],
})
export class AdminModule {


}
