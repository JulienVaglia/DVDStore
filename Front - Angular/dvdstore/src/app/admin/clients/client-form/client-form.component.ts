import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ClientsService } from 'src/app/_services/clients.service';
import { HttpClient } from '@angular/common/http';

export interface ClientModel {
  id?: number,
  nom: String,
  prenom: String,
  adresse: String;
}

@Component({
  selector: 'app-client-form',
  templateUrl: './client-form.component.html',
  styleUrls: ['./client-form.component.css']
})
export class ClientFormComponent {

  constructor(private httpClient: ClientsService, private route: ActivatedRoute, private http: HttpClient, private router: Router) { }

  clients: Array<ClientModel> = [];
  id: any = 0;

  clientModel: any =
    {
      id: 0,
      nom: '',
      prenom: '',
      adresse: '',
    }


  //-------------- Preview image --------------
  //   imagePreview: string | ArrayBuffer | null = null; // Contient l'URL de l'aperçu de l'image

  //   previewImage(event: Event) {
  //     const inputElement = event.target as HTMLInputElement;
  //     const file = inputElement.files?.[0];

  //     if (file) {
  //         const reader = new FileReader();
  //         reader.onload = () => {
  //             this.imagePreview = reader.result;
  //         };
  //         reader.readAsDataURL(file);
  //     } else {
  //         this.imagePreview = null;
  //     }
  // }

//-------------- Ajoût client --------------


    // addClient() {
    //   console.log(this.clientModel);
      
    //   this.httpClient.addClient(this.clientModel).subscribe({
  
    //     next: (data) => { this.clientModel = data, console.log(data), this.router.navigate(['client_detail/' + this.id ])},
    //     error: (err: Error) => console.log('Erreur : ' + err),
    //     complete: () => { console.log('Ajoût réussi') }
  
    //   })
    // }

    addClient() {

      this.id = this.route.snapshot.paramMap.get('id')

      if (this.id) 
          {
            this.httpClient.addClient(this.clientModel).subscribe({
      
                  next: (data) => { this.clientModel = data, console.log(data), this.router.navigate(['client_detail/' + this.id ])},
                  error: (err: Error) => console.log('Erreur : ' + err),
                  complete: () => { console.log('Ajoût réussi') }
            
                })
          }
      else
          {
          this.httpClient.addClient(this.clientModel).subscribe({
      
            next: (data) => { this.clientModel = data, console.log(data), this.router.navigate(['client_list'])},
            error: (err: Error) => console.log('Erreur : ' + err),
            complete: () => { console.log('Ajoût réussi') }
      
          })
          }

    }



    ngOnInit(): void {

      this.id = this.route.snapshot.paramMap.get('id')

      this.httpClient.getAllClients().subscribe({
        next: (data) => { this.clients = data, console.table(data)},
        error: (err: Error) => console.log('Erreur : ' + err),
        complete: () => console.log('ngOnInitAllClients complet'),
      })
  
      if (this.id != null) {
  
        this.http.get('http://localhost:9000/clients/' + this.id).subscribe({
  
          next: (data) => { this.clientModel = data, console.table(data) },
          error: (err: Error) => console.log('Erreur : ' + err),
          complete: () => console.log('ngOnInitClient complet')
  
        })
      }
      
    }

}
