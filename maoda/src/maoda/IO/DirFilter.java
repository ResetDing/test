package maoda.IO;

import java.io.File;
import java.io.FilenameFilter;

class DirFilter implements FilenameFilter{

	@Override
	public boolean accept(File dir, String name)
	{
		if(name.endsWith("java")){
		return true;
		}
		return false;
}

	
	}