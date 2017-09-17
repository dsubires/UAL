package junioMP;


public class StackLinkedListTest extends AbstractStackTestCase {

    protected Stack<Integer> makeStack() {

        return new StackLinkedListIterable<Integer>();
    }
}
