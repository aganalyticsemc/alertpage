package com.tmpPage.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;
//import com.google.gwt.user.cellview.client.AbstractCellTable;

public interface Resources extends ClientBundle {

	public static final Resources INSTANCE =  GWT.create(Resources.class);
	
//	@Source("com/tmpPage/Resources/tableStyle_From_Resources.css")
//	public AbstractCellTable.Style data_grid_style();
	
	@Source("com/tmpPage/Resources/mainStyle_From_Resources.css")
	public CssResource site_style();
	


}
