package com.zimaheka.merwan_walid.volley02;

/**
 * Created by Walid Djebbouri on 18/07/2018.
 */

public class Administrateur {

    int id ;
    String nom ;
    String prenom ;
    String email ;
    String mot_passe ;
    int nss ;
    String poste_occuper ;

    public  Administrateur(int id , String nom , String prenom , String email , String mot_passe , int nss ,String poste_occuper ){

        this.id = id ;
        this.email = email ;
        this.mot_passe = mot_passe ;
        this.poste_occuper = poste_occuper ;
        this.nom = nom ;
        this.nss = nss ;
        this.prenom = prenom ;

    }


}
