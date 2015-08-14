package com.garyhendrick.android3js;

import android.test.ActivityInstrumentationTestCase2;
import android.webkit.WebView;
import android.widget.Button;

/**
 * Created by gary on 8/12/2015.
 */
public class AnDroiD3jsEntryTest extends ActivityInstrumentationTestCase2<AnDroidD3jsEntry> {
    private AnDroidD3jsEntry myActivity;
    private WebView myWebView;
    private Button myJavaFnButton;
    private Button myJsFnButton;

    public AnDroiD3jsEntryTest() {
        super(AnDroidD3jsEntry.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        myActivity = (AnDroidD3jsEntry)getActivity();
        String foo = myActivity.toString();
        myWebView = (WebView) myActivity.findViewById(
                com.garyhendrick.android3js.R.id.webViewer);
        myJavaFnButton = (Button) myActivity.findViewById(
                R.id.javafnButton);
        myJsFnButton = (Button) myActivity.findViewById(
                R.id.jsfnButton);
    }

    public void testPreconditions() {
        assertNotNull("myActivity is null", myActivity);
        assertNotNull("myWebView is null", myWebView);
        assertNotNull("myJavaFnButton is null", myJavaFnButton);
        assertNotNull("myJsFnButton is null", myJsFnButton);
    }

    public void testMyJavaFnButton_labelText() {
        final String expected = myActivity.getString(
                R.string.label_javafnbutton);
        final String actual = myJavaFnButton.getText().toString();
        assertEquals(expected, actual);
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
}
