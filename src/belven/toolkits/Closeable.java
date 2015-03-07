package belven.toolkits;

public abstract class Closeable {
	private boolean isOpen = false;

	public boolean isOpen() {
		return isOpen;
	}

	public void setOpen(boolean isOpen) {
		this.isOpen = isOpen;
	}

	public abstract void close();

	public abstract void open();
}
