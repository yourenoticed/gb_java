package homework;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

public class Task2_TreeMapCounter {
    public static void main(String[] args) {
        String entries = "Иван Иванов, Светлана Петрова, Кристина Белова, Анна Мусина, Анна Крутова, Иван Юрин, Петр Лыков, Павел Чернов, Петр Чернышов, Мария Федорова, Марина Светлова, Мария Савина, Мария Рыкова, Марина Лугова, Анна Владимирова, Иван Мечников, Петр Петин, Иван Ежов";
        NameCounter counter = initializeCounter(new String[] {entries});
        System.out.println(counter.getCounter());
        System.out.println(counter.getCounterSortedByFrequency().descendingMap());
    }
    
    private static NameCounter initializeCounter(String[] args) {
        String[] entries;
        if (args.length == 1) {
            entries = args[0].split(", ");
        } else {
            entries = args; 
        }

        String[] names = getNames(entries);
        NameCounter counter = new NameCounter(names);
        return counter;
    }

    private static String[] getNames(String[] fullNames) {
        String[] names = new String[fullNames.length];
        for (int i = 0; i < fullNames.length; i++) {
            names[i] = fullNames[i].split(" ")[0];
        }
        return names;
    }
}

class NameCounter {
    private HashMap<String, Integer> counter = new HashMap<>();    
    private TreeMap<Integer, ArrayList<String>> counterSortedByFrequency = new TreeMap<>();

    public NameCounter(String[] entries) {
        for (String value : entries) {
            if (!counter.containsKey(value)) {
                counter.put(value, 1);
            } else {
                Integer currentCounter = counter.get(value);
                counter.put(value, ++currentCounter);
            }
        }
        counterToTreeMap();
    }

    private void counterToTreeMap() {
        for (String name : counter.keySet()) {
            Integer currentCount = counter.get(name);
            if (!counterSortedByFrequency.containsKey(currentCount)) {
                ArrayList<String> names = new ArrayList<>();
                names.add(name);
                counterSortedByFrequency.put(currentCount, names);
            } else {
                counterSortedByFrequency.get(currentCount).add(name);
            }
        }
        counterSortedByFrequency.descendingMap();
    }

    public HashMap<String, Integer> getCounter() {
        return counter;
    }    

    public TreeMap<Integer, ArrayList<String>> getCounterSortedByFrequency() {
        return counterSortedByFrequency;
    }    
}