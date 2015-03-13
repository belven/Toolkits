package belven.toolkits;

/**
 * This is used to give open and close functionality to objects that would otherwise not do this
 * 
 * @author sam
 * 
 */
public abstract class Closeable {
	private boolean isOpen = false;

	/**
	 * Gets the isOpen property
	 * 
	 * @return If the object is open/closed
	 */
	public boolean isOpen() {
		return isOpen;
	}

	/**
	 * @param isOpen the new value of isOpen
	 */
	public void setOpen(boolean isOpen) {
		this.isOpen = isOpen;
	}

	/**
	 * Used to allow objects to close
	 */
	public abstract void close();

	/**
	 * Used to allow objects to open
	 */
	public abstract void open();
}
