package com.ncrecordshop.recordshopspringbootapp.model;

public enum Genre {

        ROCK("Rock"),
        POP("Pop"),
        Jazz ("Jazz"),
        HipHop ("HipHop");

        public final String description;


        Genre(String description){
            this.description = description;
        }

    @Override
    public String toString() {
        return description;
    }

    }


