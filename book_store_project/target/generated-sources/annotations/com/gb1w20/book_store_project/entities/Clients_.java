package com.gb1w20.book_store_project.entities;

import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2020-02-13T15:48:41", comments="EclipseLink-2.7.6.v20200131-rNA")
@StaticMetamodel(Clients.class)
public class Clients_ { 

    public static volatile SingularAttribute<Clients, String> lastName;
    public static volatile SingularAttribute<Clients, String> country;
    public static volatile SingularAttribute<Clients, Integer> clientID;
    public static volatile SingularAttribute<Clients, String> address2;
    public static volatile SingularAttribute<Clients, String> city;
    public static volatile SingularAttribute<Clients, Integer> provinceAbbreviation;
    public static volatile SingularAttribute<Clients, String> address1;
    public static volatile SingularAttribute<Clients, String> companyName;
    public static volatile SingularAttribute<Clients, String> postalCode;
    public static volatile SingularAttribute<Clients, String> firstName;
    public static volatile SingularAttribute<Clients, Date> dateEntered;
    public static volatile SingularAttribute<Clients, Boolean> isRemoved;
    public static volatile SingularAttribute<Clients, Boolean> isManager;
    public static volatile SingularAttribute<Clients, String> cellTelephone;
    public static volatile SingularAttribute<Clients, Date> lastModified;
    public static volatile SingularAttribute<Clients, String> homeTelephone;
    public static volatile SingularAttribute<Clients, String> email;

}