/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gb1w20.book_store_project.entities;

import java.util.Comparator;

/**
 *
 * @author cawri
 */

public class BookComparator implements Comparator<RankedBook>{
    
    
    public int compare(RankedBook a, RankedBook b)
    {
       
        return (int)(b.getSales() - a.getSales());
    }
    
}
