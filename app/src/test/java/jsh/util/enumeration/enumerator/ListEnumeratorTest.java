package jsh.util.enumeration.enumerator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import org.junit.jupiter.api.Test;
import jsh.util.debugging.DebuggingUtil;
import jsh.util.enumeration.Enumeration;

public class ListEnumeratorTest {
    private final Function<Enumeration<?>, String> enumerationEntryStringier = e -> {
        final StringBuilder sb = new StringBuilder();
        sb.append(e.index).append(": ").append(e.element);
        return sb.toString();
    };

    @Test
    void ignore_source_list_modification() {
        final List<String> listTestAgainst = List.of("Hop", "Step", "Jump");

        final ArrayList<String> variableList = new ArrayList<String>();
        for (final var s : new String[] {"Hop", "Step", "Jump"}) {
            variableList.add(s);
        }

        final ListEnumerator<String> listIterator1 = new ListEnumerator<>(variableList);
        for (; listIterator1.hasNext();) {
            final var entry = listIterator1.next();
            DebuggingUtil.printObject(enumerationEntryStringier, entry);
            assertEquals(listTestAgainst.get(entry.index), entry.element);
        }

        variableList.add("Another Hop");
        variableList.add("Another Step");
        variableList.add("Another Jump");

        System.out.println("" + variableList);
        assertNotEquals(listTestAgainst, variableList);

        final ListEnumerator<String> listIterator2 = new ListEnumerator<>(variableList);
        for (; listIterator2.hasNext();) {
            final var entry = listIterator2.next();
            DebuggingUtil.printObject(enumerationEntryStringier, entry);
        }

        assertNotEquals(listIterator1, listIterator2);
    }

    @Test
    void iteration_against_empty_list() {
        @SuppressWarnings("null")
        final ListEnumerator<?> emptyListIterator = new ListEnumerator<>(List.of());
        for (; emptyListIterator.hasNext();) {
            final var entry = emptyListIterator.next();
            DebuggingUtil.printObject(enumerationEntryStringier, entry);
        }
    }
}