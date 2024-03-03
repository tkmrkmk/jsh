package jsh.utils.debugging;

import java.util.ArrayList;
import java.util.Iterator;

public class DebuggingArrayList<T> extends ArrayList<T> {
    /**
     * Returns a string representation of this list.
     *
     * @param sep the separator
     * @return a string representation of this list
     * @see java.util.AbstractCollection#toString()
     */
    public String toString(final String sep) {
        final Iterator<T> it = iterator();
        if (!it.hasNext()) {
            return "[]";
        }
        final StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (;;) {
            final T e = it.next();
            sb.append(e == this ? "(this collection)" : e);
            if (!it.hasNext()) {
                return sb.append(']').toString();
            }
            sb.append(sep);
            continue;
        }
    }

    @Override
    public String toString() {
        return this.toString(", ");
    }
}
