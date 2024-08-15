import java.util.List;

/**
 * TestObject
 */
public class TestObject {

    private Integer a;
    private Double b;
    private String c;
    private List<Integer> d;

    public Integer getA() {
        return a;
    }
    public void setA(Integer a) {
        this.a = a;
    }
    public Double getB() {
        return b;
    }
    public void setB(Double b) {
        this.b = b;
    }
    public String getC() {
        return c;
    }
    public void setC(String c) {
        this.c = c;
    }
    public List<Integer> getD() {
        return d;
    }
    public void setD(List<Integer> d) {
        this.d = d;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("TestObject [a=");
        builder.append(a);
        builder.append(", b=");
        builder.append(b);
        builder.append(", c=");
        builder.append(c);
        builder.append(", d=");
        builder.append(d);
        builder.append("]");
        return builder.toString();
    }
}