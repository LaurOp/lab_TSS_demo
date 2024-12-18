package Helpers;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class CaptureConsole implements TestRule {
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Override
    public Statement apply(Statement base, Description description) {
        return new Statement() {
            @Override
            public void evaluate() throws Throwable {
                try {
                    System.setOut(new PrintStream(outputStream));
                    base.evaluate();
                } finally {
                    System.setOut(originalOut);
                }
            }
        };
    }

    public String getOutput() {
        return outputStream.toString();
    }
}
