package com.gb1w20.book_store_project.entities;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.1.v20171221-rNA", date="2020-03-21T11:37:11")
@StaticMetamodel(Tax.class)
public class Tax_ { 

    public static volatile SingularAttribute<Tax, BigDecimal> pst;
    public static volatile SingularAttribute<Tax, String> provinceAbbreviation;
    public static volatile SingularAttribute<Tax, BigDecimal> hst;
    public static volatile SingularAttribute<Tax, BigDecimal> gst;

}