package belven.toolkits.testimplementations;

import belven.toolkits.Menu;
import belven.toolkits.Toolkit;

public class TestMenu extends Menu {

	public TestMenu(Toolkit toolkit) {
		super(toolkit);
		addPage(new TestPage1(toolkit));
		addPage(new TestPage2(toolkit));
	}
}