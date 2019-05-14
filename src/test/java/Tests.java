import java.util.PriorityQueue;
import org.junit.Test;

public class Tests {

  @Test
  public void test() {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>(5);
    minHeap.add(1);
    minHeap.add(2);
    for(Integer i : minHeap) {
      System.out.println(i);
    }
  }
}
