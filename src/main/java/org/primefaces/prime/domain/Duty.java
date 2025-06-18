package org.primefaces.prime.domain;

import java.util.List;

public class Duty {
    private String name;
    private List<String> exampleList;

    // Default constructor
    public Duty() {}

    // Getters and Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public List<String> getExampleList() { return exampleList; }
    public void setExampleList(List<String> exampleList) { this.exampleList = exampleList; }
} 