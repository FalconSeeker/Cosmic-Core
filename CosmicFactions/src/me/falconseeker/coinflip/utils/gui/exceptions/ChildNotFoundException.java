package me.falconseeker.coinflip.utils.gui.exceptions;

import me.falconseeker.coinflip.utils.gui.MenuUtil;

public class ChildNotFoundException extends NullPointerException {

	private static final long serialVersionUID = 1L;
	private String message;

	public ChildNotFoundException(String message) {
		this.message = message;
	}

	@Override
	public void printStackTrace() {

		MenuUtil.out("");
		MenuUtil.out("&cAn " + getClass().getSimpleName() + " was thrown by Menu Interface.");
		MenuUtil.out("&cReason: &4" + message);
		for (StackTraceElement element : getStackTrace()) {

			MenuUtil.out("&c-&4 " + element.toString());

		}
		MenuUtil.out("");

	}
}
