package com.gb1w20.book_store_project.entities;

import java.math.BigDecimal;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2020-04-12T15:45:54", comments="EclipseLink-2.7.6.v20200131-rNA")
=======
@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2020-04-12T17:25:03", comments="EclipseLink-2.7.6.v20200131-rNA")
>>>>>>> 1b1f2db6be9f9dfefe62c6980aec5c1724ed60d0
@StaticMetamodel(Tax.class)
public class Tax_ { 

    public static volatile SingularAttribute<Tax, BigDecimal> pst;
    public static volatile SingularAttribute<Tax, String> provinceAbbreviation;
    public static volatile SingularAttribute<Tax, BigDecimal> hst;
    public static volatile SingularAttribute<Tax, BigDecimal> gst;

}