public interface Stack {
    public default void push(){}
    public default void  pop(){}
    public default void peek(){}
    public default boolean empty(){
        return false;
    }
    public default int search() {
        return 0;
    }

}
