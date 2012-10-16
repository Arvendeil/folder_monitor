package com.epam.nulp.servlet;

import com.epam.nulp.database.DataBaseEditor;

public class ThreadRunner implements Runnable {
    boolean status = true;

    public boolean isRun() {
	return status;
    }

    @Override
    public void run() {
	while (isRun()) {
	    try {
		DataBaseEditor.addBookInBD();
		Thread.sleep(60 * 1024);
	    } catch (InterruptedException e) {
		e.printStackTrace();
	    }
	}
    }

}
