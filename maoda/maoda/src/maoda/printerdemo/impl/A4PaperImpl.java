package maoda.printerdemo.impl;

import maoda.printerdemo.iface.IPaper;

public class A4PaperImpl implements IPaper
{

	@Override
	public String getSize()
	{
		
		return "A4";
	}

}
