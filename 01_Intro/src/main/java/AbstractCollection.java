import java.lang.reflect.Array;
import java.util.Collection;
import java.util.function.IntFunction;

public abstract class AbstractCollection<E> implements Collection<E> {

    @Override
    public Object[] toArray() {
        Object[] objects = new Object[size()];
        int idx = 0;
        for(E e :this){
            objects[idx++] = e;
        }
        return objects;
    }

    @Override
    public int size() {
        int n = 0;
        for (E e : this) {
            n++;
        }
        return n;
    }

    @Override
    public boolean isEmpty() {
        return !iterator().hasNext();
    }

    @Override
    public boolean contains(Object o) {
        if (o == null) {
            for (E e : this) {
                if (e == null) {
                    return true;
                }
            }
            return false;
        }
        for (E e : this) {
            if (e.equals(o)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return c.stream().map(this::add).reduce(true, Boolean::logicalAnd);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return c.stream().map(this::remove).reduce(true, Boolean::logicalAnd);

    }

    @Override
    public void clear() {
        for (E e : this) {
            remove(e);
        }
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        if (c.isEmpty()) {
            return false;
        }
        for (E e : this) {
            if (!c.contains(e)) {
                remove(e);
            }
        }
        return true;
    }
}
