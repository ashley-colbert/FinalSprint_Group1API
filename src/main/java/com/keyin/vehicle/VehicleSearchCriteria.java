package com.keyin.vehicle;

public class VehicleSearchCriteria {
    private String category;
    private Long agency_pk; // Change to Long
    private String manufacturer;
    private String model;

    // Getters and Setters
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Long getAgencyPk() {
        return agency_pk;
    }

    public void setAgencyPk(Long agency_pk) {
        this.agency_pk = agency_pk;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}