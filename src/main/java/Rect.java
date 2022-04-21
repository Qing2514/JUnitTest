import java.util.Comparator;

public class Rect {

    public static final int MIN_DIGIT = 1;
    public static final int MAX_DIGIT = 100;

    private int length;
    private int width;

    public Rect(int length, int width) {
        this.length = length;
        this.width = width;
    }

    public Rect(String length, String width) throws RectException {
        if (length == null || width == null) {
            throw new RectException(RectException.NULL_ERROR);
        }
        if (!checkString(length) || !checkString(width)) {
            throw new RectException(RectException.TYPE_ERROR);
        } else if (!checkDigit(length) || !checkDigit(width)) {
            throw new RectException(RectException.RANGE_ERROR);
        }
        this.length = Integer.parseInt(length);
        this.width = Integer.parseInt(width);
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getArea() {
        return length * width;
    }

    public int getPerimeter() {
        return 2 * length + 2 * width;
    }

    public String getObject() {
        return "(" + length + "," + width + ")";
    }

    public static boolean checkDigit(String s) throws RectException {
        try{
            int n = Integer.parseInt(s);
            if(n >= MIN_DIGIT && n <= MAX_DIGIT){
                return true;
            }
        } catch(NumberFormatException e){
            throw new RectException(RectException.RANGE_ERROR);
        }
        return false;
    }

    public static boolean checkString(String s) {
        if(s.length() == 0) {
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            if (!Character.isDigit(s.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static <AnyType> boolean checkArr(AnyType[] arr) throws RectException {
        if(arr == null || arr.length == 0){
            throw new RectException(RectException.ARRAY_NULL_ERROR);
        }
        for (AnyType anyType : arr) {
            if (!(anyType instanceof Rect)) {
                throw new RectException(RectException.ARRAY_ERROR);
            }
        }
        return true;
    }

    public static <AnyType>
    AnyType findMax(AnyType[] arr, Comparator<? super AnyType> cmp) throws RectException {
        if (checkArr(arr)) {
            int maxIndex = 0;
            for (int i = 0; i < arr.length; i++) {
                if (cmp.compare(arr[i], arr[maxIndex]) > 0) {
                    maxIndex = i;
                }
            }
            return arr[maxIndex];
        } else {
            return null;
        }
    }

    public static class areaCompare implements Comparator<Rect> {
        @Override
        public int compare(Rect o1, Rect o2) {
            // TODO Auto-generated method stub
            if (o1.getArea() > o2.getArea()) {
                return 1;
            } else if (o1.getArea() == o2.getArea()) {
                return 0;
            } else {
                return -1;
            }
        }
    }

    public static class perimeterCompare implements Comparator<Rect> {
        @Override
        public int compare(Rect o1, Rect o2) {
            // TODO Auto-generated method stub
            if (o1.getPerimeter() > o2.getPerimeter()) {
                return 1;
            } else if (o1.getPerimeter() == o2.getPerimeter()) {
                return 0;
            } else {
                return -1;
            }
        }
    }

    public static void main(String[] args) throws RectException {
        Rect[] arr = new Rect[]{
                new Rect(10, 20), new Rect(2, 65),
                new Rect(3, 10), new Rect(6, 20)
        };

        System.out.println("面积最大：" + findMax(arr, new areaCompare()).getObject());
        System.out.println("周长最长：" + findMax(arr, new perimeterCompare()).getObject());
    }
}