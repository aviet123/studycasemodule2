package IService;

public interface IService<T> {
    void add(T t);
    void update(int id, T t);
    void getAll();
    void delete(int id);
}
