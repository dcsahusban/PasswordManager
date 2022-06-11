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
public class NotesModel {
    private final int id;
        private final String title;
        private final String notes;
        private final Date date;
        
        NotesModel(int id,String title,String notes,Date date) {
            this.id = id;
            this.title = title;
            this.notes = notes;
            this.date = date;
        }
        
        public int getID(){
            return this.id;
        }
        
        public String getTitle(){
            return this.title;
        }
        
        public String getNotes(){
            return this.notes;
        }
        
        public Date getDate(){
            return this.date;
        }
}
