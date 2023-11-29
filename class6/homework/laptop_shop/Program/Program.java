package Program;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import LaptopShop.LaptopShop;
import Laptop.Laptop;

public class Program {
    public static Scanner reader = new Scanner(System.in);

    public static void main(String[] args) {
        LaptopShop shop = new LaptopShop();
        boolean testcaseFlag = true;
        if (testcaseFlag)
            testcase(shop);
        shop.startFiltration();
        boolean running = true;
        while (running) {
            int chosenOption = chooseOption();
            switch (chosenOption) {
                case 1:
                    System.out.println("Print laptops:");
                    System.out.println(shop.getFilteredLaptops() + "\n");
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
                    shop.startFiltration();
                    break;
                case 6:
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
        if (deletedLaptop == null)
            System.out.println("Nothing was removed. No such laptop found");
    }

    public static int chooseOption() {
        int chosenOption = 0;
        try {
            System.out.println("Choose option:");
            System.out.println("1. Print laptops");
            System.out.println("2. Add laptop");
            System.out.println("3. Delete laptop");
            System.out.println("4. Add filter");
            System.out.println("5. Start new filtration");
            System.out.println("6. Quit");

            chosenOption = reader.nextInt();
        } catch (Exception e) {
            e.getStackTrace();
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
                        System.out.println("No\tBrand name\tFiltered");
                        for (int i = 0; i < allBrands.size(); i++) {
                            boolean isFiltered = false;
                            if (filteredBrands.contains(allBrands.get(i)))
                                isFiltered = true;
                            System.out.printf("%d.\t%s\t\t%b\n", i + 1, allBrands.get(i), isFiltered);
                        }
                        System.out.printf("%d.\tStop choosing brands to filter\n", allBrands.size() + 1);
                        int choice = reader.nextInt();
                        if ((choice >= 1) && (choice <= allBrands.size())) {
                            if (!filteredBrands.contains(allBrands.get(choice - 1))) {
                                filteredBrands.add(allBrands.get(choice - 1));
                            } else {
                                filteredBrands.remove(allBrands.get(choice - 1));
                            }
                        } else if (choice == allBrands.size() + 1)
                            filteringBrands = false;
                        else
                            System.out.println("Wrong number");
                    }
                    laptopShop.applyFilter("brand", filteredBrands);
                    break;
                case 2:
                    List<String> allModels = laptopShop.getAllModels();
                    List<String> filteredModels = laptopShop.getFilteredModels();
                    boolean filteringModels = true;
                    while (filteringModels) {
                        System.out.println("No\tModel name\tFiltered");
                        for (int i = 0; i < allModels.size(); i++) {
                            boolean isFiltered = false;
                            if (filteredModels.contains(allModels.get(i)))
                                isFiltered = true;
                            System.out.printf("%d.\t%s\t\t%b\n", i + 1, allModels.get(i), isFiltered);
                        }
                        System.out.printf("%d.\tStop choosing models to filter\n", allModels.size() + 1);
                        int choice = reader.nextInt();
                        if ((choice >= 1) && (choice <= allModels.size())) {
                            if (!filteredModels.contains(allModels.get(choice - 1))) {
                                filteredModels.add(allModels.get(choice - 1));
                            } else {
                                filteredModels.remove(allModels.get(choice - 1));
                            }
                        } else if (choice == allModels.size() + 1)
                            filteringModels = false;
                        else
                            System.out.println("Wrong number");
                    }
                    laptopShop.applyFilter("model", filteredModels);
                    break;
                case 3:
                    System.out.println("Price filter: ");
                    laptopShop.applyFilter("priceRUB", numeralFilter());
                    break;
                case 4:
                    List<String> allOS = laptopShop.getAllOperatingSystems();
                    List<String> filteredOS = laptopShop.getFilteredOperatingSystems();
                    boolean filteringOS = true;
                    while (filteringOS) {
                        System.out.println("No\tOS name\tFiltered");
                        for (int i = 0; i < allOS.size(); i++) {
                            boolean isFiltered = false;
                            if (filteredOS.contains(allOS.get(i)))
                                isFiltered = true;
                            System.out.printf("%d.\t%s\t\t%b\n", i + 1, allOS.get(i), isFiltered);
                        }
                        System.out.printf("%d.\tStop choosing OS to filter\n", allOS.size() + 1);
                        int choice = reader.nextInt();
                        if ((choice >= 1) && (choice <= allOS.size())) {
                            if (!filteredOS.contains(allOS.get(choice - 1))) {
                                filteredOS.add(allOS.get(choice - 1));
                            } else {
                                filteredOS.remove(allOS.get(choice - 1));
                            }
                        } else if (choice == allOS.size() + 1)
                            filteringBrands = false;
                        else
                            System.out.println("Wrong number");
                    }
                    laptopShop.applyFilter("operatingSystem", filteredOS);
                    break;
                case 5:
                    System.out.println("CPU Frequency filter: ");
                    laptopShop.applyFilter("cpuFrequencyHZ", numeralFilter());
                    break;
                case 6:
                    System.out.println("RAM filter: ");
                    laptopShop.applyFilter("ramMB", numeralFilter());
                    break;
                case 7:
                    System.out.println("Storage space filter: ");
                    laptopShop.applyFilter("storageGB", numeralFilter());
                    break;
                case 8:
                    filtering = false;
                    break;
                default:
                    System.out.println("Wrong number");
                    break;
            }
        }
    }

    public static List<String> numeralFilter() {
        List<String> filterCriteria = new ArrayList<>(2);
        filterCriteria.add("0");
        filterCriteria.add("0");
        boolean numFiltering = true;
        while (numFiltering) {
            System.out.println("1. Minimum threshold");
            System.out.println("2. Maximum threshold");
            System.out.println("3. Quit ");
            int choice = reader.nextInt();
            if (choice == 1) {
                System.out.println("Minimum threshold:");
                int min = reader.nextInt();
                filterCriteria.set(0, Integer.toString(min));
            } else if (choice == 2) {
                System.out.println("Minimum threshold:");
                int max = reader.nextInt();
                filterCriteria.set(1, Integer.toString(max));
            } else if (choice == 3) {
                numFiltering = false;
            } else {
                System.out.println("Wrong number");
            }
        }
        return filterCriteria;
    }
}