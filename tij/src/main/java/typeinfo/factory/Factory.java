package typeinfo.factory;

@FunctionalInterface
public interface Factory<T> {
    T create();
}
