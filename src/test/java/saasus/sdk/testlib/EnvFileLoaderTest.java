package saasus.sdk.testlib;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.Map;
import org.junit.jupiter.api.Test;

class EnvFileLoaderTest {

    @Test
    void parsesKeyValuePairs() {
        String content = "SAASUS_SAAS_ID=abc123\nSAASUS_API_KEY=key\n";
        Map<String, String> env = EnvFileLoader.parse(content);
        assertEquals("abc123", env.get("SAASUS_SAAS_ID"));
        assertEquals("key", env.get("SAASUS_API_KEY"));
    }

    @Test
    void ignoresCommentsAndBlankLines() {
        String content = "# a comment\n\n  \nKEY=value\n";
        Map<String, String> env = EnvFileLoader.parse(content);
        assertEquals(1, env.size());
        assertEquals("value", env.get("KEY"));
    }

    @Test
    void handlesExportPrefixAndQuotes() {
        String content = "export QUOTED=\"hello world\"\nSINGLE='single quoted'\n";
        Map<String, String> env = EnvFileLoader.parse(content);
        assertEquals("hello world", env.get("QUOTED"));
        assertEquals("single quoted", env.get("SINGLE"));
    }

    @Test
    void stripsTrailingInlineCommentForUnquotedValues() {
        Map<String, String> env = EnvFileLoader.parse("KEY=value # trailing comment\n");
        assertEquals("value", env.get("KEY"));
    }

    @Test
    void stripsQuotesWhenQuotedValueHasTrailingComment() {
        Map<String, String> env = EnvFileLoader.parse("SAASUS_API_KEY=\"key\" # local credential\n");
        assertEquals("key", env.get("SAASUS_API_KEY"));

        Map<String, String> single = EnvFileLoader.parse("K='val' # note\n");
        assertEquals("val", single.get("K"));
    }

    @Test
    void ignoresLinesWithoutKey() {
        Map<String, String> env = EnvFileLoader.parse("=novalue\nJUSTTEXT\n");
        assertFalse(env.containsKey(""));
        assertNull(env.get("JUSTTEXT"));
    }
}
