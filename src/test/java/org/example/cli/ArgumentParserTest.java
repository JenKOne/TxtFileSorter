package org.example.cli;



import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ArgumentParserTest {

    @Test
    void parseArguments() {
        Arguments args = new ArgumentParser().parse(new String[]{"-f", "-p", "x-", ".txt"});
        assertTrue(args.isFullStats());
        assertEquals("x-", args.getPrefix());
        assertEquals(1, args.getInputFiles().size());
    }
}
