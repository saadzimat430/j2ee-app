package com.app.dao;

import com.app.beans.Utilisateur;

public interface UtilisateurDao {

    int creer( Utilisateur utilisateur ) throws DaoException;
    void supprimer(Utilisateur utilisateur) throws DaoException;
}