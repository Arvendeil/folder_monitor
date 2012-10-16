package com.epam.nulp.parser;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.List;

public class FileWorker {

    public static List<File> getFullFileList(String folder) {
	File sourceFolder = new File(folder);
	FilenameFilter filter = new FilenameFilter() {
	    @Override
	    public boolean accept(File directory, String filename) {
		return filename.endsWith(".xml");
	    }
	};
	File[] allFiles = sourceFolder.listFiles(filter);
	return Arrays.asList(allFiles);
    }

}
