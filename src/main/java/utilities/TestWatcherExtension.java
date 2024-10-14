package utilities;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;

import java.util.Optional;

/**
 * The TestWatcherExtension class implements the TestWatcher interface from JUnit 5.
 *
 * This class provides callbacks for monitoring the status of tests during execution.
 * It defines actions to be taken when a test is successful, failed, aborted, or disabled.
 */
public class TestWatcherExtension implements TestWatcher {

    /**
     * Callback executed when a test is successful.
     *
     * @param context the context of the test that was successful.
     */
    @Override
    public void testSuccessful(ExtensionContext context) {
        System.out.println("Test " + context.getDisplayName() + " was successful!");
    }

    /**
     * Callback executed when a test fails.
     *
     * @param context the context of the test that failed.
     * @param cause the throwable that caused the test to fail.
     */
    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        System.out.println("Test " + context.getDisplayName() + " failed with exception: " + cause.getMessage());
    }

    /**
     * Callback executed when a test is aborted.
     *
     * @param context the context of the test that was aborted.
     * @param cause the throwable that caused the test to be aborted.
     */
    @Override
    public void testAborted(ExtensionContext context, Throwable cause) {
        System.out.println("Test " + context.getDisplayName() + " was aborted due to: " + cause.getMessage());
    }

    /**
     * Callback executed when a test is disabled.
     *
     * @param context the context of the test that was disabled.
     * @param reason optional reason for why the test was disabled.
     */
    @Override
    public void testDisabled(ExtensionContext context, Optional<String> reason) {
        System.out.println("Test " + context.getDisplayName() + " was disabled. Reason: " + reason.orElse("No reason provided"));
    }
}
