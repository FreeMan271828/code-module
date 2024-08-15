package Query;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * QueryModule
 * 代码查询模块
 */
public class QueryModuleImpl<T> implements QueryModule<T> {

    private static final int MAXSIZE = 1000;
    // 获取condition不为空的字段
    private final Field[] valueFields = new Field[MAXSIZE];
    private final Object[] values = new Object[MAXSIZE];
    private int valueFieldIndex = 0;

    @SuppressWarnings("unchecked")
    @Override
    public List<T> query(List<T> data, T condition)
            throws NoSuchFieldException, IllegalAccessException {
        return query((T[]) data.toArray(),condition);
    }

    @Override
    public List<T> query(T[] data, T condition)
            throws NoSuchFieldException, IllegalAccessException {
        if (data==null)
            return null;
        if(condition==null)
            return Arrays.stream(data).toList();
        // 获取condition对象的类
        Class<?> clazz = condition.getClass();
        // 获取所有字段
        Field[] fields = clazz.getDeclaredFields();
        //获取所有不为空的字段
        for (Field field : fields) {
            try {
                // 设置可访问性，以便可以访问私有字段
                field.setAccessible(true);
                // 获取当前字段的值
                Object value = field.get(condition);
                // 检查字段值是否不为空
                if (value != null && !value.equals("")) {
                    valueFields[valueFieldIndex] = field;
                    values[valueFieldIndex] = value;
                    valueFieldIndex++;
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        //构建返回对象
        List<T> ret = new ArrayList<T>();
        for(T item: data) {
            if(matchesCondition(item)){
                ret.add(item);
            }
        }
        return ret;
    }

    /**
     *
     * @param item  要判断的对象
     * @return 当前对象是否匹配不为空的字段以及值
     */
    private boolean matchesCondition(Object item)
            throws IllegalAccessException, NoSuchFieldException {
        // 检查item是否具有与field对应的属性
        if (item != null) {
            // 比较item的属性值是否与condition的属性值相等
            for(int i = 0; i < valueFieldIndex; i++) {
                Object itemValue = valueFields[i].get(item);
                boolean matches = Objects.equals(itemValue, values[i]);
                if (!matches)  return false;
            }
            return true;
        }
        return false;
    }
}