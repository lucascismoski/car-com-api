package com.fiorin.springboot.restservice;

import org.springframework.data.annotation.Id;

public class Vendor {
    @Id
    private final long vendorId;
    private final String name;
    private final double salary;
    private final String hireDate;
    private final String creationDate;
    private final String lastUpdateDate;

    public Vendor(long vendorId, String name, double salary, String hireDate, String creationDate, String lastUpdateDate) {
        this.vendorId       = vendorId;
        this.name           = name;
        this.salary         = salary;
        this.hireDate       = hireDate;
        this.creationDate   = creationDate;
        this.lastUpdateDate = lastUpdateDate;
    }

    public long getVendorId() {
        return vendorId;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public String getHireDate() {
        return hireDate;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public String getLastUpdateDate() {
        return lastUpdateDate;
    }
}

