package com.gb1w20.book_store_project.entities;

import java.math.BigDecimal;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2020-04-11T18:22:16", comments="EclipseLink-2.7.6.v20200131-rNA")
@StaticMetamodel(Tax.class)
public class Tax_ { 

    public static volatile SingularAttribute<Tax, BigDecimal> pst;
    public static volatile SingularAttribute<Tax, String> provinceAbbreviation;
    public static volatile SingularAttribute<Tax, BigDecimal> hst;
    public static volatile SingularAttribute<Tax, BigDecimal> gst;

}