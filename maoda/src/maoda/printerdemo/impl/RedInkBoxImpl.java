package maoda.printerdemo.impl;

import maoda.printerdemo.iface.IInkBox;

public class RedInkBoxImpl implements IInkBox
{

	@Override
	public String getColor()
	{
		
		return "红色";//把null重写为某个颜色
	}

}
