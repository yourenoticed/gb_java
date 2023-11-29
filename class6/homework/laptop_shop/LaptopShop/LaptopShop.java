package LaptopShop;

import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import Laptop.Laptop;

public class LaptopShop {
    private Set<Laptop> allLaptops;
    private Set<Laptop> filteredLaptops;
    
    public LaptopShop() {
        this.allLaptops = new HashSet<>();
    }
    
    public void startFiltration() {
        this.filteredLaptops = new HashSet<>();
        this.filteredLaptops.addAll(this.allLaptops);
    }

    public void applyFilter(String criterion, List<String> parameters) {
        Set<Laptop> currentFilter = new HashSet<>();
        for (Laptop laptop : this.filteredLaptops) {
            if (laptop.isApplicableToFilter(criterion, parameters)) currentFilter.add(laptop);
        }
        this.filteredLaptops.retainAll(currentFilter);
    }

    public void addLaptop(String brand, String model, int priceRUB, String operatingSystem, int cpuFrequencyHZ, int ramMB, int storageGB) {
        Laptop addedLaptop = new Laptop(brand, model, priceRUB, operatingSystem, cpuFrequencyHZ, ramMB, storageGB);
        allLaptops.add(addedLaptop);
    }

    public Laptop deleteLaptop(String brand, String model) {
        Laptop deletedLaptop = this.findLaptop(brand, model);
        this.allLaptops.remove(deletedLaptop);
        return deletedLaptop;
    }

    public Laptop findLaptop(String brand, String model) {
        for (Laptop laptop : this.allLaptops) {
            if ((brand.toLowerCase() == laptop.getBrand().toLowerCase()) && (model.toLowerCase() == laptop.getModel().toLowerCase())) return laptop;
        }
        return null;
    }

    public List<String> getAllBrands() {
        List<String> allBrands = new ArrayList<>();
        for (Laptop laptop : this.allLaptops) {
            if (!allBrands.contains(laptop.getBrand())) allBrands.add(laptop.getBrand());
        }
        return allBrands;
    }

    public List<String> getFilteredBrands() {
        List<String> filteredBrands = new ArrayList<>();
        for (Laptop laptop : this.filteredLaptops) {
            if (!filteredBrands.contains(laptop.getBrand())) filteredBrands.add(laptop.getBrand());
        }
        return filteredBrands;
    }

    public List<String> getAllModels() {
        List<String> allModels = new ArrayList<>();
        for (Laptop laptop : this.allLaptops) {
            if (!allModels.contains(laptop.getModel())) allModels.add(laptop.getModel());
        }
        return allModels;
    }

    public List<String> getFilteredModels() {
        List<String> filteredModels = new ArrayList<>();
        for (Laptop laptop : this.filteredLaptops) {
            if (!filteredModels.contains(laptop.getModel())) filteredModels.add(laptop.getModel());
        }
        return filteredModels;
    }

    public List<Integer> getFilteredPrices() {
        List<Integer> filteredPrices = new ArrayList<>();
        for (Laptop laptop : this.filteredLaptops) {
            filteredPrices.add(laptop.getPriceRUB());
        }
        return filteredPrices;
    }

    public List<String> getAllOperatingSystems() {
        List<String> allOperatingSystems = new ArrayList<>();
        for (Laptop laptop : this.allLaptops) {
            if (!allOperatingSystems.contains(laptop.getOperatingSystem())) allOperatingSystems.add(laptop.getOperatingSystem());
        }
        return allOperatingSystems;
    }

    public List<String> getFilteredOperatingSystems() {
        List<String> filteredOS = new ArrayList<>();
        for (Laptop laptop : this.filteredLaptops) {
            if (!filteredOS.contains(laptop.getOperatingSystem())) filteredOS.add(laptop.getOperatingSystem());
        }
        return filteredOS;
    }

    public List<Integer> getFilteredCPUFrequencies() {
        List<Integer> filteredCPUFreq = new ArrayList<>();
        for (Laptop laptop : this.filteredLaptops) {
            filteredCPUFreq.add(laptop.getCpuFrequencyHZ());
        }
        return filteredCPUFreq;
    }

    public List<Integer> getFilteredRAM() {
        List<Integer> filteredRAM = new ArrayList<>();
        for (Laptop laptop : this.filteredLaptops) {
            filteredRAM.add(laptop.getRamMB());
        }
        return filteredRAM;
    }

    public List<Integer> getFilteredStorageMB() {
        List<Integer> filteredStorages = new ArrayList<>();
        for (Laptop laptop : this.filteredLaptops) {
            filteredStorages.add(laptop.getStorageGB());
        }
        return filteredStorages;
    }

    public Set<Laptop> getAllLaptops() {
        return this.allLaptops;
    }

    public Set<Laptop> getFilteredLaptops() {
        return this.filteredLaptops;
    }
}