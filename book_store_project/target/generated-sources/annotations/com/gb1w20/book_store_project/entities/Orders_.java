package com.gb1w20.book_store_project.entities;

import com.gb1w20.book_store_project.entities.Clients;
import com.gb1w20.book_store_project.entities.OrderItem;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2020-04-12T18:39:08", comments="EclipseLink-2.7.6.v20200131-rNA")
=======
@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2020-04-12T19:18:42", comments="EclipseLink-2.7.6.v20200131-rNA")
>>>>>>> abb303246aa7c2ebad76bed714efe8bee5117810
@StaticMetamodel(Orders.class)
public class Orders_ { 

    public static volatile SingularAttribute<Orders, Date> lastUpdated;
    public static volatile SingularAttribute<Orders, Integer> clientID;
    public static volatile SingularAttribute<Orders, Date> dateCreated;
    public static volatile SingularAttribute<Orders, Boolean> isRemoved;
    public static volatile SingularAttribute<Orders, Integer> orderID;
    public static volatile SingularAttribute<Orders, Clients> client;
    public static volatile ListAttribute<Orders, OrderItem> orderItemsCollection;

}