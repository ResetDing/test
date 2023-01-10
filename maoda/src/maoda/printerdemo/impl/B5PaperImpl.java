package maoda.printerdemo.impl;

import maoda.printerdemo.iface.IPaper;

public class B5PaperImpl implements IPaper
{

	@Override
	public String getSize()
	{
		
		return "B5";
	}

}
