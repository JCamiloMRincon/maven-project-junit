package listeners;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import utilities.Logs;

import java.util.Optional;

public class ResultListeners implements TestWatcher {
    @Override
    public void testDisabled(ExtensionContext context, Optional<String> reason) {
        Logs.info("""
                test disabled...
                
                """);
    }

    @Override
    public void testSuccessful(ExtensionContext context) {
        Logs.info("""
                test successful...
                
                """);
    }

    @Override
    public void testAborted(ExtensionContext context, Throwable cause) {
        Logs.info("""
                test aborted...
                
                """);
    }

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        Logs.info("""
                test failed...
                
                """);
    }
}
