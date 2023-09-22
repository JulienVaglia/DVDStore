import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AdminRoutingModule } from './admin-routing.module';
import { NavbarComponent } from './navbar/navbar.component';
import { AdminLayoutComponent } from './admin-layout/admin-layout.component';
import { HomeComponent } from './home/home.component';
import { SideMenuComponent } from './side-menu/side-menu.component';
import { MovieListComponent } from './movies/movie-list/movie-list.component';
import { MovieFormComponent } from './movies/movie-form/movie-form.component';
import { SaleFormComponent } from './sales/sale-form/sale-form.component';
import { SaleListComponent } from './sales/sale-list/sale-list.component';
import { UserListComponent } from './users/user-list/user-list.component';
import { UserFormComponent } from './users/user-form/user-form.component';
import { MovieDetailComponent } from './movies/movie-detail/movie-detail.component';

//Angular Material
import {MatIconModule} from '@angular/material/icon';
import {MatBadgeModule} from '@angular/material/badge';
import {MatButtonModule} from '@angular/material/button';
import {MatCardModule} from '@angular/material/card';




@NgModule({
  declarations: [
    NavbarComponent,
    AdminLayoutComponent,
    HomeComponent,
    SideMenuComponent,
    MovieListComponent,
    MovieFormComponent,
    SaleFormComponent,
    SaleListComponent,
    UserListComponent,
    UserFormComponent,
    MovieDetailComponent
  ],
  imports: [
    CommonModule,
    AdminRoutingModule,
    MatCardModule, 
    MatButtonModule,
    MatIconModule,
    MatBadgeModule,
    MatButtonModule
  ]
})
export class AdminModule { }
