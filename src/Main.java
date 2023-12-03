import java.util.*;

// Обобщенный интерфейс для структуры данных
interface DataStructure<T> {
    void addObject(T obj);
    void removeObject(T obj);
    Iterator<T> iterator(); // Добавлен метод для получения итератора
}

// Обобщенный интерфейс для итератора
interface Iterator<T> {
    boolean hasNext();
    T next();
}

// Класс итератора для ObjectGroup
class ObjectGroupIterator<T> implements Iterator<T> {
    private List<T> objects;
    private int index;

    public ObjectGroupIterator(List<T> objects) {
        this.objects = objects;
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        return index < objects.size();
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException("No more elements in the list");
        }
        return objects.get(index++);
    }
}

// Generic-класс для работы с группами объектов
class ObjectGroup<T> implements DataStructure<T> {
    private List<T> objects;

    public ObjectGroup() {
        objects = new ArrayList<>();
    }

    public void addObject(T obj) {
        objects.add(obj);
    }

    public void removeObject(T obj) {
        objects.remove(obj);
    }

    public List<T> getObjects() {
        return objects;
    }

    public void addCollection(List<? extends T> collection) {
        objects.addAll(collection);
    }

    public Iterator<T> iterator() {
        return new ObjectGroupIterator<>(objects);
    }

    public static <T> ObjectGroup<T> shuffleGroup(ObjectGroup<T> group) {
        ObjectGroup<T> shuffledGroup = new ObjectGroup<>();
        List<T> originalObjects = new ArrayList<>(group.getObjects());
        Collections.shuffle(originalObjects, new Random());
        shuffledGroup.addCollection(originalObjects);
        return shuffledGroup;
    }
}

public class Main {
    public static void main(String[] args) {
        // Пример использования ObjectGroup с Integer
        ObjectGroup<Integer> integerGroup = new ObjectGroup<>();
        integerGroup.addObject(1);
        integerGroup.addObject(2);
        integerGroup.addObject(3);

        Iterator<Integer> integerIterator = integerGroup.iterator();
        while (integerIterator.hasNext()) {
            System.out.println(integerIterator.next());
        }

        // Пример использования ObjectGroup с Double
        List<Double> doubleList = new ArrayList<>();
        doubleList.add(1.1);
        doubleList.add(2.2);
        doubleList.add(3.3);

        ObjectGroup<Double> doubleGroup = new ObjectGroup<>();
        doubleGroup.addCollection(doubleList);

        Iterator<Double> doubleIterator = doubleGroup.iterator();
        while (doubleIterator.hasNext()) {
            System.out.println(doubleIterator.next());
        }

        // Пример сортировки
        List<String> names = new ArrayList<>();
        names.add("Alice");
        names.add("Charlie");
        names.add("Bob");

        Collections.sort(names);
        System.out.println("Sorted Names: " + names);
    }
}
