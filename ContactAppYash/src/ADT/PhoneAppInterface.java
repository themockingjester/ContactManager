package ADT;

public interface PhoneAppInterface<E,F> {
    void viewAll();
    void search(F item);
    void delete();
    boolean add(F first,F last,F email,Object num);
}
