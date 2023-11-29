package laptop_shop;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class Program {
    public static Scanner reader = new Scanner(System.in);
    public static void main(String[] args) {
        LaptopShop shop = new LaptopShop();
        boolean testcaseFlag = true;
        if (testcaseFlag) testcase(shop);
        shop.startFiltration();
        boolean running = true;
        while (running) {
            int chosenOption = chooseOption();
            switch (chosenOption) {
                case 1:
                    System.out.println("Print all laptops:");    
                    System.out.println(shop.getAllLaptops() + "\n");
                    break;
                case 2:
                    add(shop);
                    break;
                case 3:
                    delete(shop);
                    break;
                case 4:
                    filter(shop);
                    break;
                case 5:
                    running = false;
                    reader.close();
                    break;
                default:
                    System.out.println("Wrong number");
                    break;
            }
        }
    }
    
    public static void testcase(LaptopShop laptopShop) {
        laptopShop.addLaptop("Samsung", "Gal3", 140239, "Linux", 3500, 8000, 1000);
        laptopShop.addLaptop("HP", "XYZ-10", 100000, "Windows 10", 3250, 4000, 500);
        laptopShop.addLaptop("Samsung", "Gal5", 145239, "Windows 10", 3500, 8000, 1000);
        laptopShop.addLaptop("Samgung", "f0", 50239, "DOS", 2500, 4000, 250);
    }

    public static void add(LaptopShop laptopShop) {
        System.out.println("\nAdd:");

        System.out.print("Enter brand of the laptop: ");
        String brand = reader.next();
        
        System.out.print("Enter model of the laptop: ");
        String model = reader.next();

        System.out.print("Enter price RUB of the laptop: ");
        int priceRUB = reader.nextInt();

        System.out.print("Enter operating system of the laptop: ");
        String operatingSystem = reader.next();

        System.out.print("Enter CPU Frequency of the laptop: ");
        int cpuFrequencyHZ = reader.nextInt();

        System.out.print("Enter RAM MB of the laptop: ");
        int ramMB = reader.nextInt();

        System.out.print("Enter storage GB of the laptop: ");
        int storageGB = reader.nextInt();

        laptopShop.addLaptop(brand, model, priceRUB, operatingSystem, cpuFrequencyHZ, ramMB, storageGB);
    }

    public static void delete(LaptopShop laptopShop) {
        System.out.println("\nDelete:");
        System.out.print("Enter brand of the laptop to remove: ");
        String brand = reader.next();
        System.out.println(brand);
        System.out.print("Enter model of the laptop to remove: ");
        String model = reader.next();
        System.out.println(model);
        Laptop deletedLaptop = laptopShop.deleteLaptop(brand, model);
        if (deletedLaptop == null) System.out.println("Nothing was removed. No such laptop found");
    }

    public static int chooseOption() {
        boolean choosing = true;
        int chosenOption = 0;
        try {
            while (choosing) {
                System.out.println("Choose option:");
                System.out.println("1. Print all laptops");
                System.out.println("2. Add laptop");
                System.out.println("3. Delete laptop");
                System.out.println("4. Filter laptops");
                System.out.println("5. Quit");
                
                chosenOption = reader.nextInt();
                choosing = false;
            }
        } catch (Exception e) {
            return 0;
        }
        return chosenOption;
    }

    public static void filter(LaptopShop laptopShop) {
        
        boolean filtering = true;
        while (filtering) {
            System.out.println("\nFiltration:");
            System.out.println("1. Brand");
            System.out.println("2. Model");
            System.out.println("3. Price RUB");
            System.out.println("4. Operating System");
            System.out.println("5. CPU Frequency HZ");
            System.out.println("6. RAM MB");
            System.out.println("7. Storage GB");
            System.out.println("8. Finish filtering");
            int option = reader.nextInt();
            switch (option) {
                case 1:
                    List<String> allBrands = laptopShop.getAllBrands();    
                    List<String> filteredBrands = laptopShop.getFilteredBrands();
                    boolean filteringBrands = true;
                    while (filteringBrands) {
                        System.out.println("No\tBrand names\tFiltered");
                        for(int i = 0; i < allBrands.size(); i++) {
                            boolean isFiltered = false;
                            if (filteredBrands.size() > 0) {
                                if (filteredBrands.contains(allBrands.get(i))) isFiltered = true;
                            }
                            System.out.printf("%d.\t%s\t\t%b\n", i + 1, allBrands.get(i), isFiltered);
                        }
                        int brandsChoice = reader.nextInt();
                        if ((brandsChoice >= 1) && (brandsChoice <= allBrands.size())) {
                            filteredBrands.add(allBrands.get(brandsChoice - 1));
                            filteringBrands = false;
                            laptopShop.applyFilter("brand", filteredBrands);
                        }
                    }
                    break;
                }
        }
    }

}