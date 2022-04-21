import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

@RunWith(Parameterized.class)
public class TestAreaAndPerimeter {

    private String len, width;
    private int area, perimeter;

    @Parameterized.Parameters(name = "{index}: Area({0}, {1}) =  {2}, Perimeter({0}, {1}) =  {3}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][]{
                { "10", "20", 200, 60 },
                { "a", "20", 0, 0 },
                { "10", "b", 0, 0 },
                { "a", "b", 0, 0 },
                { "10", 0, 0 },
                { "10", "20", 30 ,0, 0 },
                { "-1", "20", 0, 0 },
                { "10", "-1", 0, 0 },
                { "-1", "-1", 0, 0 },
                { "101", "20", 0, 0 },
                { "10", "101", 0, 0 },
                { "101", "101", 0, 0 },
                { "10", null, 0, 0 }
        });
    }

    public TestAreaAndPerimeter(String len, String width, Integer area, Integer perimeter) {
        this.len = len;
        this.width = width;
        this.area = area;
        this.perimeter = perimeter;
    }

    @Test
    public void test() {
        Rect rect;
        try {
            rect = new Rect(len, width);
            Assert.assertEquals(area, rect.getArea());
            Assert.assertEquals(perimeter, rect.getPerimeter());
        } catch (RectException e) {
            e.printStackTrace();
        }
    }
}