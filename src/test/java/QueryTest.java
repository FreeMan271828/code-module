import Query.QueryModule;
import Query.QueryModuleImpl;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.junit.Test;

import java.io.File;
import java.util.List;

public class QueryTest {

    public static List<TestObject> convertYamlToTestObjectList(String yamlFilePath) throws Exception {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        // 读取YAML文件并将其转换为TestObject列表
        return mapper.readValue(new File(yamlFilePath),  new TypeReference<List<TestObject>>(){});
    }

    @Test
    public void test() throws Exception {
        String path = "src/main/java/Query/TestData.yaml";
        List<TestObject> testObjectList = convertYamlToTestObjectList(path);

        TestObject testObject = new TestObject();
        testObject.setA(149);
        testObject.setB(28.3);
        QueryModule<TestObject> queryModule = new QueryModuleImpl<>();
        List<TestObject> ret = queryModule.query(
                testObjectList, testObject);
        System.out.println(ret);
    }
}
