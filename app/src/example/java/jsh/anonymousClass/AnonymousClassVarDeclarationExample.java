package jsh.anonymousClass;

import java.util.ArrayList;

public class AnonymousClassVarDeclarationExample {
    public static void main(final String[] args) {
        final var myList = new ArrayList<Integer>() {
            @Override
            public boolean add(final Integer e) {
                System.out.printf("Add: %d%n", e);
                return super.add(e);
            }

            public void greet() {
                System.out.println("Hello, this is an anonymous class of java.util.ArrayList.");
            }
        };

        myList.add(1);
        myList.greet(); // can be auto-completed thanks to javac.
    }
}
