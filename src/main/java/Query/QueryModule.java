package Query;

import java.util.List;

/**
 * 进行查询模块
 * @param <T> 需要指明数据类型
 */
public interface QueryModule<T> {

    List<T> query(List<T> data, T condition)
            throws NoSuchFieldException, IllegalAccessException;

    List<T> query(T[] data, T condition)
            throws NoSuchFieldException, IllegalAccessException;
}
