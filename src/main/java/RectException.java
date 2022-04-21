public class RectException extends Exception{

    public static final String NULL_ERROR = "length or width is null";
    public static final String TYPE_ERROR = "length or width type mismatch";
    public static final String RANGE_ERROR = "length or width range mismatch";
    public static final String ARRAY_ERROR = "array type mismatch";
    public static final String ARRAY_NULL_ERROR = "array is null";

    public RectException(String message) {
        super(message);
    }
}
