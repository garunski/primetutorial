package org.primefaces.prime.domain;

public class ColumnDefinition {
    private String columnName;
    private String dataType;
    private Boolean ignoreCase;
    private Boolean partialMatch;
    private String description;

    // Default constructor
    public ColumnDefinition() {}

    // Getters and Setters
    public String getColumnName() { return columnName; }
    public void setColumnName(String columnName) { this.columnName = columnName; }

    public String getDataType() { return dataType; }
    public void setDataType(String dataType) { this.dataType = dataType; }

    public Boolean getIgnoreCase() { return ignoreCase; }
    public void setIgnoreCase(Boolean ignoreCase) { this.ignoreCase = ignoreCase; }

    public Boolean getPartialMatch() { return partialMatch; }
    public void setPartialMatch(Boolean partialMatch) { this.partialMatch = partialMatch; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
} 