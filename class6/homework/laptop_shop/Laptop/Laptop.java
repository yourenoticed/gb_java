package Laptop;

import java.util.List;

public class Laptop {
    private String brand;
    private String model;
    private int priceRUB;
    private String operatingSystem;
    private int cpuFrequencyHZ;
    private int ramMB;
    private int storageGB;
    
    public Laptop(String brand, String model, int priceRUB, String operatingSystem, int cpuFrequencyHZ, int ramMB, int storageGB) {
        this.brand = brand;
        this.model = model;
        this.priceRUB = priceRUB;
        this.operatingSystem = operatingSystem;
        this.cpuFrequencyHZ = cpuFrequencyHZ;
        this.ramMB = ramMB;
        this.storageGB = storageGB;
    }

    public boolean isApplicableToFilter(String criterion, List<String> parameters) {
        switch (criterion) {
            case "brand":
                for (String parameter : parameters) {
                    if (parameter == this.brand) return true;
                }
                break;

            case "model":
                for (String parameter : parameters) {
                    if (parameter == this.model) return true;
                }
                break;

            case "operatingSystem":
                for (String parameter : parameters) {
                    if (parameter == this.operatingSystem) return true;
                }
                break;

            case "priceRUB":
                if ((parameters.get(1) == "0") && (this.priceRUB >= Integer.parseInt(parameters.get(0)))) return true;
                if ((this.priceRUB >= Integer.parseInt(parameters.get(0))) && (this.priceRUB <= Integer.parseInt(parameters.get(1)))) return true; 
                break;

            case "cpuFrequencyHZ":
                if ((parameters.get(1) == "0") && (this.cpuFrequencyHZ >= Integer.parseInt(parameters.get(0)))) return true;
                if ((this.cpuFrequencyHZ >= Integer.parseInt(parameters.get(0))) && (this.cpuFrequencyHZ <= Integer.parseInt(parameters.get(1)))) return true;
                break;

            case "ramMB":
                if ((parameters.get(1) == "0") && (this.ramMB >= Integer.parseInt(parameters.get(0)))) return true;
                if ((this.ramMB >=Integer.parseInt(parameters.get(0))) && (this.ramMB <= Integer.parseInt(parameters.get(1)))) return true;
                break;

            case "storageGB":
                if ((parameters.get(1) == "0") && (this.storageGB >= Integer.parseInt(parameters.get(0)))) return true;
                if ((this.storageGB >= Integer.parseInt(parameters.get(0))) && (this.storageGB <= Integer.parseInt(parameters.get(1)))) return true;
                break;

            default:
                return false;
            }
        return false;
    }

    public String getBrand() {
        return brand;
    }

    public int getCpuFrequencyHZ() {
        return cpuFrequencyHZ;
    }

    public String getModel() {
        return model;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public int getPriceRUB() {
        return priceRUB;
    }
    
    public int getRamMB() {
        return ramMB;
    }

    public int getStorageGB() {
        return storageGB;
    }

    public void setPriceRUB(int price) {
        this.priceRUB = price;
    } 

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setCpuFrequencyHZ(int cpuFrequencyHZ) {
        this.cpuFrequencyHZ = cpuFrequencyHZ;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public void setRamMB(int ramMB) {
        this.ramMB = ramMB;
    }

    public void setStorageGB(int storageGB) {
        this.storageGB = storageGB;
    }

    @Override
    public String toString() {
        StringBuilder laptopString = new StringBuilder("Brand: ");
        laptopString.append(this.brand).append("\n")
        .append("Model: ").append(this.model).append("\n")
        .append("Price RUB: ").append(this.priceRUB).append("\n")
        .append("Operating System: ").append(this.operatingSystem).append("\n")
        .append("CPU Frequency HZ: ").append(this.cpuFrequencyHZ).append("\n")
        .append("RAM MB: ").append(this.ramMB).append("\n")
        .append("Storage GB: ").append(this.storageGB).append("\n");

        return laptopString.toString();
    }
}