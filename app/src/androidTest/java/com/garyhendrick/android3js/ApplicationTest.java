package com.garyhendrick.android3js;

import android.app.Application;
import android.test.ApplicationTestCase;
import android.util.Log;
import android.webkit.WebView;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<Application> {
    private Application myApp;
    private AnDroidD3jsEntry myActivity;
    private WebView myWebView;

    public ApplicationTest() {
        super(Application.class);
    }

    /**
     * This will do the work to instantiate the Application under test.  After this, your test
     * code must also start and stop the Application.
     */
    @Override
    protected void setUp() throws Exception {
        super.setUp();
        myApp = getApplication();
        Log.d("Testing a Test", myApp.toString());
    }

    /**
     * Shuts down the Application under test.  Also makes sure all resources are cleaned up and
     * garbage collected before moving on to the next
     * test.  Subclasses that override this method should make sure they call super.tearDown()
     * at the end of the overriding method.
     *
     * @throws Exception
     */
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
}