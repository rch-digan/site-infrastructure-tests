package com.exner.tools.analyticstdd.GenericTests4AnalyticsProject.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class DOMElementForSelectorExistenceTestCase extends WebDriverBasedTestCase {
	private String _elementSelector;

	public DOMElementForSelectorExistenceTestCase(String pageURL, String elementSelector) {
		super(pageURL);
		_elementSelector = elementSelector;
		setName("DOM element " + _elementSelector + " exists - " + _pageURL);
	}

	@Override
	protected void runTest() throws Throwable {
		// try finding the element in the page
		WebElement element = null;
		try {
			element = _webDriver.findElement(By.cssSelector(_elementSelector));
		} catch (NoSuchElementException e) {
			// it ain't there
			fail("DOM element " + _elementSelector + " must exist");
		}

		// make sure the element exists
		assertNotNull("DOM element " + _elementSelector + " must exist", element);
	}

}