package jsh.utils.enumerators;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import org.junit.jupiter.api.Test;
import jsh.utils.debugging.DebuggingUtil;

public class ListEnumeratorTest {
    @Test
    void ignoreOutsideChange() {
        final var listTestAgainst = List.of("Hop", "Step", "Jump");

        final var variableList = new ArrayList<String>();
        for (final var s : new String[] {"Hop", "Step", "Jump"}) {
            variableList.add(s);
        }

        final Function<EnumerationEntry<String>, String> f = e -> {
            final StringBuilder sb = new StringBuilder();
            sb.append(e.index).append(' ').append(e.element);
            return sb.toString();
        };

        final ListEnumerator<String> listIterator1 = new ListEnumerator<>(variableList);
        for (; listIterator1.hasNext();) {
            final var entry = listIterator1.next();
            DebuggingUtil.printObject(f, entry);
            assertEquals(listTestAgainst.get(entry.index), entry.element);
        }

        variableList.add("Another Hop");
        variableList.add("Another Step");
        variableList.add("Another Jump");

        System.out.println(variableList);
        assertNotEquals(listTestAgainst, variableList);

        final ListEnumerator<String> listIterator2 = new ListEnumerator<>(variableList);
        for (; listIterator2.hasNext();) {
            final var entry = listIterator2.next();
            DebuggingUtil.printObject(f, entry);
        }

        System.out.println("listIterator1 " + listIterator1.list);
        System.out.println("listIterator2 " + listIterator2.list);
        assertNotEquals(listIterator1, listIterator2);
    }
}
