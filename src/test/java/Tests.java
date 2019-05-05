import com.practice.DataStructures.MinHeap;
import com.practice.DataStructures.SampleBinaryTrees;
import com.practice.PrintSuccessiveLeafNodes;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.stream.IntStream;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by jaiprakash on 30/11/18
 */

public class Tests {
  /*private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
  private final PrintStream originalOut = System.out;
*/
  @Test
  public void test() {
    int arr[] = {3, 2, 1};
    MinHeap minHeap = new MinHeap(arr, 3, 3);
    System.out.println(minHeap.top());
  }

  /*@Before
  public void setUpStreams() {
    System.setOut(new PrintStream(outContent));
  }

  @After
  public void restoreStreams() {
    System.setOut(originalOut);
  }
*/
  /*@Test
  public void printSuccessiveLeafNodes() {
    PrintSuccessiveLeafNodes test = new PrintSuccessiveLeafNodes();
    test.printSuccessiveLeafNodesUnOptimised(SampleBinaryTrees.sample_1());
    Assert.assertEquals("405030\n20\n10", outContent.toString());
  }*/
}
