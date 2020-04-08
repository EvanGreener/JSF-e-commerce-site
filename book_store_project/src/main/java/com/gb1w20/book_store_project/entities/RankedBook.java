/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gb1w20.book_store_project.entities;

/**
 *
 * @author cawri
 */
public class RankedBook {
    private Book book;
    private String sales;
    public RankedBook(Book book, String sales)
    {
        this.book = book;
        this.sales = sales;
    }
    public Book getBook()
    {
        return this.book;
    }
    public String getSales()
    {
        return this.sales;
    }
}
