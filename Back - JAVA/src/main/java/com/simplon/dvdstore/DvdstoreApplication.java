package com.simplon.dvdstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DvdstoreApplication {

//Le controlleur : il sert à recevoir les données Json et à les passer au service (map en Service Model)
//Le service: il sert à recevoir les données en Service Model , effectuer des traitements et les passer au repository (map en RepositoryModel
//Le Repository: il sert à recevoir les données en RepositoryModel et requeter la base de données


//	ArrayList<Client> clients = new ArrayList<>();
//        clients.add(new Client(1,"Dupont","Jean"));
//        clients.add(new Client(2,"Lalon","Cédric"));
//
//
//	ArrayList<Dvd> dvds = new ArrayList<>();
//        dvds.add(new Dvd(1,"Matrix","science fiction",50, (float)3.90));
//
//	ArrayList<Vente> ventes = new ArrayList<>();
//        ventes.add(new Vente(1, dvds.get(0), clients.get(0),5));
//        ventes.add(new Vente(1, dvds.get(0), clients.get(1),2));
//
//
//// get all sales per client name/id
//        for (Vente x : ventes) {
//		if(Objects.equals(x.getClient().getName(), "Dupont")){
//			System.out.println(x.toString());
//		}
//	};
//
//        for (Vente x : ventes) {
//		if(Objects.equals(x.getClient().getId(), 1)){
//			System.out.println(x.toString());
//		}
//	};
//
//// get all sales per dvd name/id
//        for(Vente vente : ventes) {
//		if(vente.getDvd().getId() == 1){
//			System.out.println(vente);
//		}
//	}
//// get total price of sales
//	float total = 0;
//        for(Vente vente : ventes){
//		total += vente.getTotalPrice();
//	}
//        System.out.println("total des ventes " + total);
//
//// get total value of stock
//	float totalValueStock =0;
//        for(Dvd dvd : dvds){
//		totalValueStock+= dvd.getPrice() * dvd.getQty();
//	}
//        System.out.println(totalValueStock);
//
////qte vendue et en stock pour un dvd
//	int addition = 0;
//	int qteVendue = 0;
//        for(Vente vente : ventes) {
//		if(vente.getDvd().getId() == 1) {
//			qteVendue = vente.getDvd().getQty();
//			addition += vente.getQty();
//			//qte vendue de dvd par vente : vente.getQty();
//		}
//	}
////return
//        System.out.println("qte vendue du dvd 1 : " + addition);
//        System.out.println("stock du dvd 1 :" + qteVendue);
//}



	public static void main(String[] args) {
		SpringApplication.run(DvdstoreApplication.class, args);
	}



}
