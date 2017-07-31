package com.tmpPage.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;


/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class TmpPageDashboard implements EntryPoint {
	
//	Define UI-viewer elements to show
	private navBarViewer navBar = new navBarViewer();
	private tmpPageViewer tmpPage = new tmpPageViewer();
	private simpleTable cellTable = new simpleTable();

	
	public void onModuleLoad() {
		// this command injects css-files from resource folder. Please see Resources.java to make adjustments
//		Resources.INSTANCE.data_grid_style().ensureInjected(); 
//		AbstractTableResources.gwtCssDataGridResources.dataGrid().ensureInjected();
		Resources.INSTANCE.site_style().ensureInjected();
		RootPanel.get().add(navBar);
		RootPanel.get().add(tmpPage);
		RootPanel.get().add(cellTable);
//		RootPanel.get().add(tmpPageDesign2);
		
	}
}
