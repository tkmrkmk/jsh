package jsh.util.debugging;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.function.Function;
import org.junit.jupiter.api.Test;

public class DebuggingUtilTest {

    @Test
    void nop_test() {
        DebuggingUtil.nop();
    }

    @Test
    void stringifyObject_named_class() {
        final class NamedClass {
            public final int id;
            public final String name;

            NamedClass(final int id, final String name) {
                this.id = id;
                this.name = name;
            }
        }

        final Function<NamedClass, String> f =
                nc -> String.format("NamedClass { id: %d, name: %s }", nc.id, nc.name);

        final String s1 =
                DebuggingUtil.stringifyObject(f, new NamedClass(10, "John"));
        System.out.println(s1);
        assertEquals("NamedClass { id: 10, name: John }", s1);

        final String s2 =
                DebuggingUtil.stringifyObject(f, new NamedClass(-2, "Noon"));
        System.out.println(s2);
        assertEquals("NamedClass { id: -2, name: Noon }", s2);
    }

    @Test
    void stringifyObject_anonymous_class_test() {
        // @formatter:off
        final var anonymousClass = new Object() {
            private int     code;
            public  int  getCode() { return code; }
            public  void setCode(final int code) { this.code = code; }

            private String    message;
            public  String getMessage() { return message; }
            public  void   setMessage(final String message) { this.message = message; }
        };
        // @formatter:on

        anonymousClass.setCode(10);
        anonymousClass.setMessage("Hi");
        final String s1 =
                DebuggingUtil.stringifyObject(
                        a -> String.format("anonymousClass { code: %d, message: %s }",
                                a.getCode(), a.getMessage()),
                        anonymousClass);
        System.out.println(s1);
        assertEquals("anonymousClass { code: 10, message: Hi }", s1);

        anonymousClass.setCode(-10);
        anonymousClass.setMessage("negative");
        final String s2 =
                DebuggingUtil.stringifyObject(
                        a -> String.format("anonymousClass { code: %d, message: %s }",
                                a.getCode(), a.getMessage()),
                        anonymousClass);
        System.out.println(s2);
        assertEquals("anonymousClass { code: -10, message: negative }", s2);
    }
}
