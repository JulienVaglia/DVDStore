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
import { SaleDetailComponent } from './sales/sale-detail/sale-detail.component';

//Angular Material
import { MatIconModule} from '@angular/material/icon';
import { MatBadgeModule} from '@angular/material/badge';
import { MatButtonModule} from '@angular/material/button';
import { MatCardModule} from '@angular/material/card';
import { MatPaginatorModule} from '@angular/material/paginator';
import { MatTableModule} from '@angular/material/table';
import { HomeComponent } from './home/home.component';
import { SaleListComponent } from './sales/sale-list/sale-list.component';
import { ProfilComponent } from './profil/profil/profil.component';
import { ProfilFormComponent } from './profil/profil-form/profil-form.component';
import { PanierListComponent } from './paniers/panier-list/panier-list.component';
import { PanierFormComponent } from './paniers/panier-form/panier-form.component';
import { PanierDetailComponent } from './paniers/panier-detail/panier-detail.component';











@NgModule({
  declarations: [
    NavbarComponent,
    AdminLayoutComponent,
    HomeComponent,
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
    ProfilComponent,
    ProfilFormComponent,
    PanierListComponent,
    PanierFormComponent,
    PanierDetailComponent

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
    SaleListComponent
  ],
})
export class AdminModule {


}
