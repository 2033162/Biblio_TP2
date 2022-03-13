package ca.cal.bibliotheque;

import ca.cal.bibliotheque.model.*;
import ca.cal.bibliotheque.persistance.DB.JDBCCreateDB;
import ca.cal.bibliotheque.persistance.JPA.*;
import ca.cal.bibliotheque.service.*;

import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class MainBibliotheque {

    public static void main(String[] args) throws ParseException {

        //JDBCCreateDB.createDatabase();


        ServiceDocument serviceDocument = new ServiceDocument(new DocumentsDaoJPAH2());
        ServiceEmploye serviceEmploye = new ServiceEmploye(new EmployeDaoJPAH2());
        ServiceClient serviceClient = new ServiceClient(new ClientsDaoJPAH2());
        ServiceReservation serviceReservation = new ServiceReservation(new ReservationDaoJPAh2());
        ServiceEmpruntDocuments serviceEmpruntDocuments = new ServiceEmpruntDocuments(new EmpruntDocumentsDaoJPAH2());
        /*ServiceClient serviceClient = new ServiceClient();
        ServiceCD serviceCD = new ServiceCD();
        ServiceDVD serviceDVD = new ServiceDVD();
        ServiceLivre serviceLivre = new ServiceLivre();
        ServiceEmploye serviceEmploye = new ServiceEmploye();
        ServiceReservation serviceReservation = new ServiceReservation();
        ServiceEmpruntDocuments serviceEmpruntDocuments = new ServiceEmpruntDocuments();*/

        var cd = new CD(EtatDocument.DISPONIBLE,
                Documents.C_CD,
                "harry potter",
                "JK. Rolling",
                "maison edition",
                2000,
                "classique",
                "JK. Rolling",
                "michel");

        serviceDocument.createCD(cd);
        var cd2 = serviceDocument.getCD(cd.getId());
        System.out.println(cd2);

        cd.setGenreMusique("jazz");
        serviceDocument.updateCD(cd);
        var cd3 = serviceDocument.getCD(cd.getId());
        System.out.println(cd3);



        var dvd = new DVD(
                EtatDocument.ENDOMMAGE,
                Documents.C_DVD,
                "bobby bob",
                "lilo lee",
                "edition bop",
                2018,
                44,
                "drame");

        serviceDocument.createDVD(dvd);
        var dvd2 = serviceDocument.getDVD(dvd.getId());
        System.out.println(dvd2);

        dvd.setEtatDocument(EtatDocument.DISPONIBLE);
        serviceDocument.updateDVD(dvd);
        var dvd3 = serviceDocument.getDVD(dvd.getId());
        System.out.println(dvd3);



        var livre = new Livre(
                EtatDocument.EMPRUNTE,
                Documents.C_LIVRE,
                "avengers",
                "Josh whedon",
                "marvel",
                2020,
                230,
                GenreLivre.ROMAN);
        serviceDocument.createLivre(livre);
        var livre2 = serviceDocument.getLivre(livre.getId());
        System.out.println(livre2);

        livre.setNbrPages(900);
        serviceDocument.updateLivre(livre);
        var livre3 = serviceDocument.getLivre(livre.getId());
        System.out.println(livre3);



        var employe = new Employe(
                "bernadette",
                "carmier",
                Fonction.GESTIONNAIRE);
        serviceEmploye.createEmploye(employe);
        var employe2 = serviceEmploye.getEmploye(employe.getId());
        System.out.println(employe2);

        employe.setFonction(Fonction.PREPOSE);
        serviceEmploye.updateEmploye(employe);
        var employe3 = serviceEmploye.getEmploye(employe.getId());
        System.out.println(employe3);

        var employe4 = serviceEmploye.getEmploye(employe.getId());
        serviceEmploye.removeEmploye(employe);
        System.out.println(employe4);



        var client = new Clients(
                "John",
                "Smith",
                "daragon",
                "montreal",
                "H05C42",
                "514-900-5698",
                new SimpleDateFormat("dd/MM/yyyy").parse("20/02/2022"),
                1);
        serviceClient.createClient(client);
        var client2 = serviceClient.getClient(client.getId());
        System.out.println(client2);

        client.setRue("drolet");
        serviceClient.updateClient(client);
        var client3 = serviceClient.getClient(client.getId());
        System.out.println(client3);

        var client4 = serviceClient.getClient(client.getId());
        serviceClient.removeClient(client);
        System.out.println(client4);



        var reservation = new Reservation(
                new SimpleDateFormat("dd/MM/yyyy").parse("05/10/2000"),
                client,
                livre);
        serviceReservation.createReservation(reservation);
        var reservation2 = serviceReservation.getReservation(reservation.getId());
        System.out.println(reservation2);

        reservation.setDateReservation(new SimpleDateFormat("dd/MM/yyyy").parse("13/03/2022"));
        serviceReservation.updateReservation(reservation);
        var reservation3 = serviceReservation.getReservation(reservation.getId());
        System.out.println(reservation3);

        var reservation4 = serviceReservation.getReservation(reservation.getId());
        serviceReservation.removeReservation(reservation);
        System.out.println(reservation4);



        var empruntDocuments = new EmpruntDocuments(
                new SimpleDateFormat("dd/MM/yyyy").parse("15/03/2018"),
                new SimpleDateFormat("dd/MM/yyyy").parse("04/01/2022"),
                2,
                client,
                dvd);
        serviceEmpruntDocuments.createEmpruntDocuments(empruntDocuments);
        var empruntDocuments2 = serviceEmpruntDocuments.getEmpruntDocuments(empruntDocuments.getId());
        System.out.println(empruntDocuments2);

        empruntDocuments.setNbrRappel(0);
        serviceEmpruntDocuments.updateEmpruntDocuments(empruntDocuments);
        var empruntDocuments3 = serviceEmpruntDocuments.getEmpruntDocuments(empruntDocuments.getId());
        System.out.println(empruntDocuments3);



        /*var idClient = 1L;
        var idCD = 1L;
        var idDVD = 2L;
        var idLivre = 3L;
        var idEmploye = 1L;
        var idReservation = 1L;
        var idEmpruntDocuments = 1L;



        var client1 = new Clients(idClient,
                "John",
                "Smith",
                "daragon",
                "montreal",
                "H05C42",
                "514-900-5698",
                new SimpleDateFormat("dd/MM/yyyy").parse("20/02/2022"),
                1);
        serviceClient.enregistrer(client1);

        var client2 = serviceClient.getClient(idClient);
        System.out.println(client2);



        client1.setRue("rancour");
        serviceClient.modification(client1);

        var client3 = serviceClient.getClient(idClient);
        System.out.println(client3);



        var document1 = new Documents(idCD,
                EtatDocument.DISPONIBLE,
                Documents.C_CD,
                "harry potter",
                "JK. Rolling",
                "maison edition",
                2000);

        var cd = new CD(document1,
                "classique",
                "JK. Rolling",
                "maison edition");
        serviceCD.enregistrer(cd);
        var cd2 = serviceCD.getCD(idCD);
        System.out.println(cd2);

        cd.setInterprete("JK. Rolling");
        serviceCD.modification(cd);
        var cd3 = serviceCD.getCD(idCD);
        System.out.println(cd3);



        var document2 = new Documents(idDVD,
                EtatDocument.ENDOMMAGE,
                Documents.C_DVD,
                "bobby bob",
                "lilo lee",
                "edition bop",
                2018);

        var dvd = new DVD(document2,
                44,
                "drame");
        serviceDVD.enregistrer(dvd);
        var dvd2 = serviceDVD.getDVD(idDVD);
        System.out.println(dvd2);

        dvd.setGenreFilm("Horreur");
        serviceDVD.modification(dvd);
        var dvd3 = serviceDVD.getDVD(idDVD);
        System.out.println(dvd3);



        var document3 = new Documents(idLivre,
                EtatDocument.EMPRUNTE,
                Documents.C_LIVRE,
                "avengers",
                "Josh whedon",
                "marvel",
                2020);

        var livre = new Livre(document3,
                230,
                GenreLivre.ROMAN);
        serviceLivre.enregistrer(livre);
        var livre2 = serviceLivre.getLivre(idLivre);
        System.out.println(livre2);

        livre.setAnneePublication(2002);
        serviceLivre.modification(livre);
        var livre3 = serviceLivre.getLivre(idLivre);
        System.out.println(livre3);



        var employe1 = new Employe(idEmploye,
                "bernadette",
                "carmier",
                Fonction.GESTIONNAIRE);
        serviceEmploye.enregistrer(employe1);
        var employe2 = serviceEmploye.getEmploye(idEmploye);
        System.out.println(employe2);

        employe1.setFonction(Fonction.PREPOSE);
        serviceEmploye.modification(employe1);
        var employe3 = serviceEmploye.getEmploye(idEmploye);
        System.out.println(employe3);



        var reservation = new Reservation(idReservation,
                new SimpleDateFormat("dd/MM/yyyy").parse("05/10/2000"),
                client1,
                document3);
        serviceReservation.faireReservation(reservation);
        var reservation2 = serviceReservation.getReservation(idReservation);
        System.out.println(reservation2);

        employe1.setFonction(Fonction.PREPOSE);
        serviceEmploye.modification(employe1);
        var employe4 = serviceEmploye.getEmploye(idEmploye);
        System.out.println(employe4);

        reservation.setDateReservation(new SimpleDateFormat("dd/MM/yyyy").parse("15/03/2000"));
        serviceReservation.modification(reservation);
        var reservation3 = serviceReservation.getReservation(idReservation);
        System.out.println(reservation3);



        var empruntDocument = new EmpruntDocuments(idEmpruntDocuments,
                new SimpleDateFormat("dd/MM/yyyy").parse("15/03/2018"),
                new SimpleDateFormat("dd/MM/yyyy").parse("04/01/2022"),
                2,
                client1,
                document3);
        serviceEmpruntDocuments.enregistrer(empruntDocument);
        var empruntDocument2 = serviceEmpruntDocuments.getEmpruntDocument(idEmpruntDocuments);
        System.out.println(empruntDocument2);

        empruntDocument.setNbrRappel(4);
        serviceEmpruntDocuments.modification(empruntDocument);
        var empruntDocument3 = serviceEmpruntDocuments.getEmpruntDocument(idEmpruntDocuments);
        System.out.println(empruntDocument3);


        System.out.println("\nLISTE DOCUMENTS :");
        List<Documents> listeDocuments = serviceDocument.rechercheDocument("",
                EtatDocument.DISPONIBLE,
                "harry potter",
                "",
                "",
                0);
        listeDocuments.forEach((document) -> {
            System.out.println(document.toStringDocument());
        });
        System.out.println();



        serviceEmpruntDocuments.faireEmprunt(client1, document1);



        System.out.println("\nNOMBRE D'EMPRUNT PAR MOIS :");
        int[] nbrEmpruntParMois = serviceEmpruntDocuments.getNbrEmpruntParMois();
        for (int i = 0; i < nbrEmpruntParMois.length; i++) {
            System.out.println(new DateFormatSymbols().getMonths()[i] + "  " + nbrEmpruntParMois[i]);
        }
        System.out.println();



        var empruntDocument4 = serviceEmpruntDocuments.getEmpruntDocument(idEmpruntDocuments);
        serviceEmpruntDocuments.suppression(empruntDocument4);
        System.out.println(empruntDocument4);



        var reservation4 = serviceReservation.getReservation(idReservation);
        serviceReservation.suppression(reservation4);
        System.out.println(reservation4);



        var employe5 = serviceEmploye.getEmploye(idEmploye);
        serviceEmploye.suppression(employe5);
        System.out.println(employe5);



        var client4 = serviceClient.getClient(idClient);
        serviceClient.suppression(client4);
        System.out.println(client4);



        var cd4 = serviceCD.getCD(idCD);
        serviceCD.suppression(cd4);
        System.out.println(cd4);



        var dvd4 = serviceDVD.getDVD(idDVD);
        serviceDVD.suppression(dvd4);
        System.out.println(dvd4);



        var livre4 = serviceLivre.getLivre(idLivre);
        serviceLivre.suppression(livre4);
        System.out.println(livre4);*/
    }
}