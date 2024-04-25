package listeners;

import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import utilities.Logs;

public class TestListeners implements BeforeEachCallback, AfterEachCallback {

    @Override
    public void afterEach(ExtensionContext extensionContext) {
        Logs.info("after each...");
    }

    @Override
    public void beforeEach(ExtensionContext extensionContext) {
        Logs.info("before each...");
    }
}
