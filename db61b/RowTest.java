package db61b;
import static org.junit.Assert.*;
import org.junit.Test;

public class RowTest {
	
	@Test
	public void testRow() {
		Row r = new Row(new String[]{"hello", "my", "name", "yusuke."});
		assertEquals(4, r.size());
		assertEquals("hello", r.get(0));
		Row r2 = new Row(new String[]{"hello", "my", "name", "yusuke."});
		Row r3 = new Row(new String[]{"hello", "in", "name", "yusuke."});
		Row r4 = new Row(new String[]{"101", "Chris", "B", "Freshmen"});
		assertEquals(true, r.equals(r2));
		assertEquals(false, r.equals(r3));
		assertEquals(false, r.equals(r4));
	}
	
	public static void main(String[] args) {
        System.exit(ucb.junit.textui.runClasses(RowTest.class));
    }

}
