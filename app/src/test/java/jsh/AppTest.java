/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package jsh;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;

class AppTest {
    @Test
    void appHasAGreeting() {
        final App classUnderTest = new App();
        assertNotNull(classUnderTest.getGreeting(), "app should have a greeting");
    }
}
