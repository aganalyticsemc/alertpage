package com.tmpPage.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class navBarViewer extends Composite {

	private static navBarViewerUiBinder uiBinder = GWT.create(navBarViewerUiBinder.class);

	interface navBarViewerUiBinder extends UiBinder<Widget, navBarViewer> {
	}

	public navBarViewer() {
		initWidget(uiBinder.createAndBindUi(this));
	}

}
