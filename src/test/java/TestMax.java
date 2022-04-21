import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

@RunWith(Parameterized.class)
public class TestMax {

    private final Rect[] arr;
    private final int area, perimeter;

    private static Rect[] arr1 = new Rect[4], arr2 = new Rect[4], arr3 = new Rect[4];
    static {
        try {
            arr1 = new Rect[]{new Rect("10", "20"),
                              new Rect("2", "65"),
                              new Rect("3", "10"),
                              new Rect("6", "20")};
            arr2 = new Rect[]{new Rect("10", "a"),
                              new Rect("2", "65"),
                              new Rect("3", "10"),
                              new Rect("6", "20")};
            arr3 = new Rect[]{new Rect("10", "a"),
                              new Rect("2", "a"),
                              new Rect("3", "10"),
                              new Rect("6", "20")};
        } catch (RectException e) {
            e.printStackTrace();
        }
    }

    public TestMax(Rect[] arr, int area, int perimeter) {
        this.arr = arr;
        this.area = area;
        this.perimeter = perimeter;
    }

    @Parameterized.Parameters(name = "{index}: arr = {0}, max area = {1}, max perimeter = {2}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {arr1, 200, 134},
                {new int[]{1, 2, 3, 4}, 0, 0},
                {null, 0, 0},
                {arr2, 0, 0},
                {arr3, 0, 0},
        });
    }

    @Test
    public void test(){
         try {
             Assert.assertEquals(area, (Rect.findMax(arr, new Rect.areaCompare())).getArea());
             Assert.assertEquals(perimeter, (Rect.findMax(arr, new Rect.perimeterCompare())).getPerimeter());
         } catch (RectException e) {
             e.printStackTrace();
         }

    }
}
