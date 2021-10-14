package com.example.demo;

//Denominations is an enum
//It holds the vTypes, and it's description, so we can calculate the change based on them
public enum Denominations {
    V4(10, "10 Rand"),
    V3(5, "5 Rand"),
    V2(2, "2 Rand"),
    V1(1, "1 Rand");

    private final int denominations;
    private final String description;

    Denominations(int denominations, String description){

        this.denominations = denominations;
        this.description = description;
    }

    public int getDenominations() { return denominations; }

    public String getDescription() { return description; }
}
