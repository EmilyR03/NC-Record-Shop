package com.ncrecordshop.recordshopspringbootapp.model;

public enum Genre {

        ROCK("Rock"),
        POP("Pop"),
        JAZZ("Jazz"),
        HIP_HOP("HipHop");

        public final String description;


        Genre(String description){
            this.description = description;
        }

    @Override
    public String toString() {
        return description;
    }
}


