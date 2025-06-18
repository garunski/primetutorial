package org.primefaces.prime.domain;

import java.util.List;

public class Technology {
    private String id;
    private String name;
    private List<String> exampleList;

    // Default constructor
    public Technology() {}

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public List<String> getExampleList() { return exampleList; }
    public void setExampleList(List<String> exampleList) { this.exampleList = exampleList; }
} 