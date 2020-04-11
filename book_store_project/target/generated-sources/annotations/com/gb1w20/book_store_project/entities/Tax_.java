package com.gb1w20.book_store_project.entities;

import java.math.BigDecimal;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2020-04-10T22:40:09", comments="EclipseLink-2.7.6.v20200131-rNA")
=======
@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2020-04-10T12:13:33", comments="EclipseLink-2.7.6.v20200131-rNA")
>>>>>>> e45bae9a3fba5abe97e954fa25e80e25aedb842b
@StaticMetamodel(Tax.class)
public class Tax_ { 

    public static volatile SingularAttribute<Tax, BigDecimal> pst;
    public static volatile SingularAttribute<Tax, String> provinceAbbreviation;
    public static volatile SingularAttribute<Tax, BigDecimal> hst;
    public static volatile SingularAttribute<Tax, BigDecimal> gst;

}