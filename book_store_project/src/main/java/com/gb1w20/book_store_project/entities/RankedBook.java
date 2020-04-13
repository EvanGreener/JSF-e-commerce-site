/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gb1w20.book_store_project.entities;

/**
 *
 * @author Cedric Richards
 */
public class RankedBook {
    private Book book;
    private double sales;
    public RankedBook(Book book, double sales)
    {
        this.book = book;
        this.sales = sales;
    }
    public Book getBook()
    {
        return this.book;
    }
    public double getSales()
    {
        return this.sales;
    }
}
