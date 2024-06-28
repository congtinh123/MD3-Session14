package business;

import java.util.List;

public interface IGenericDesign<T, E> {
    //    Thêm mới:
    boolean create(T t);

    //    Chỉnh sửa:
    boolean update(T t);

    //    Xóa:
    boolean deleteById(E id);

    //    Tìm theo id:
    T findById(E id);

    //    Tìm tất cả:
    List<T> findAll();
}