package com.project.El_Buen_Sabor.config;


import org.springframework.data.history.Revision;
import org.hibernate.envers.RevisionListener;

//Crea una revision cada vez que hagamos una consulta
public class CustomRevisionListener implements RevisionListener {
    public void newRevision(Object revisionEntity) {final Revision revision = (Revision) revisionEntity;}

}


