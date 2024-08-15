package Query;

/**
 * QueryModule
 */
public class QueryModule {

    public static Object query (Object condition){
        
        return null;
    }

    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        TestObjectList testObjectList;

        try {
            testObjectList = mapper.readValue(new File("path/to/your/file.yaml"), TestObjectList.class);
            List<TestObject> testObjects = testObjectList.getTestObjects();
            // 现在你可以使用testObjects列表了
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}