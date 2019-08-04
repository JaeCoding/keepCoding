package test;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class mySet<T> {

    private int addCount = 0;

    private Set<T> set = new HashSet<>();

    public mySet() {
    }

    public boolean add(T t) {
        addCount++;
        return set.add(t);
    }

    public boolean addAll(Collection<? extends T> ts) {
        addCount += ts.size();
        return set.addAll(ts);
    }
}
