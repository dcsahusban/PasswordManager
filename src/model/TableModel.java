/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author harshit
 */
    public class TableModel{
        private final int id;
        private final String website;
        private final String password;
        private final Date date;
        
        TableModel(int id,String website,String password,Date date) {
            this.id = id;
            this.website = website;
            this.password = password;
            this.date = date;
        }
        
        public int getID(){
            return this.id;
        }
        
        public String getSite(){
            return this.website;
        }
        
        public String getPwd(){
            return this.password;
        }
        
        public Date getDate(){
            return this.date;
        }                
    }