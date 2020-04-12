/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gb1w20.arquillian.test.beans;

import com.gb1w20.book_store_project.entities.Ads;
import com.gb1w20.book_store_project.entities.Authors;
import java.util.List;

/**
 *
 * @author shruti Pareek
 */
public class AuthorsTestingBean {

    public Authors expectedAuthor;
    public String authorName;

    public AuthorsTestingBean(Authors expectedAuthor, String authorName) {
        this.expectedAuthor = expectedAuthor;
        this.authorName = authorName;
    }

}
