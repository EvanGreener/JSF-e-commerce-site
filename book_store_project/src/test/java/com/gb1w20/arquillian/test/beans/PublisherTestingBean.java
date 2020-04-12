/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gb1w20.arquillian.test.beans;

/**
 *
 * @author Evan Greenstein
 */
public class PublisherTestingBean {
     
     public String name;
     public int expectedId;

     public PublisherTestingBean(String name, int expectedId) {
          this.name = name;
          this.expectedId = expectedId;
     }
     
     
}
