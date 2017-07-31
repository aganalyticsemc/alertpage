package com.tmpPage.client;


import org.gwtbootstrap3.client.shared.event.HideEvent;
import org.gwtbootstrap3.client.shared.event.HideHandler;
import org.gwtbootstrap3.client.shared.event.ShowEvent;
import org.gwtbootstrap3.client.shared.event.ShowHandler;
import org.gwtbootstrap3.client.ui.Anchor;
import org.gwtbootstrap3.client.ui.PanelCollapse;
import org.gwtbootstrap3.client.ui.ProgressBar;
import org.gwtbootstrap3.client.ui.TabListItem;
import org.gwtbootstrap3.client.ui.constants.IconPosition;
import org.gwtbootstrap3.client.ui.constants.IconType;
import org.gwtbootstrap3.client.ui.constants.ProgressBarType;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;



public class tmpPageViewer extends Composite {

	private static tmpPageViewerUiBinder uiBinder = GWT.create(tmpPageViewerUiBinder.class);
	
		interface tmpPageViewerUiBinder extends UiBinder<Widget, tmpPageViewer> {
	}

    @UiField
    Anchor icon_up_down;
    @UiField
    Anchor icon_up_down_top5;    
    @UiField
    PanelCollapse collapseOne;
    @UiField
    PanelCollapse collapseTop5;
    @UiField
    TabListItem WeeklyTarget;
    @UiField
    TabListItem MonthlyTarget;
    @UiField
    TabListItem AnnuallyTarget;
    @UiField
    Anchor targetBar1Text;
    @UiField
    Anchor targetBar2Text;
    @UiField
    Anchor targetBar3Text;
    @UiField
    Anchor targetBar4Text;
    @UiField
    ProgressBar targetBar1 ;
    @UiField
    ProgressBar targetBar2;
    @UiField
    ProgressBar targetBar3;
    @UiField
    ProgressBar targetBar4;
    
    

    
//    Variables to be set for the target bars
    private double[] targetBarPercentWeekly   = {100,85,25,20}; //Can be modified
    private double[] targetBarPercentMonthly  = {85,70,40,25}; //Can be modified
    private double[] targetBarPercentAnnually = {80,65,60,40}; //Can be modified
    private double[] targetBarMaxWeekly     = {15,20,10,5}; //Can be modified
    private double[] targetBarMaxMonthly    = new double[targetBarMaxWeekly.length];
    private double[] targetBarMaxAnnually   = new double[targetBarMaxWeekly.length];
    private String[] targetBarLabelWeekly   = new String[targetBarPercentWeekly.length];
    private String[] targetBarLabelMonthly   = new String[targetBarPercentWeekly.length];
    private String[] targetBarLabelAnnually   = new String[targetBarPercentWeekly.length]; 

	public tmpPageViewer() {
		initWidget(uiBinder.createAndBindUi(this));
		
		
        // Add handlers for collapse of mid panels
        collapseOne.addShowHandler(new ShowHandler() {
            @Override
            public void onShow(ShowEvent showEvent) {
            	icon_up_down.setIcon(IconType.WINDOW_MINIMIZE);
            }
        });	
        
        collapseOne.addHideHandler(new HideHandler() {
            @Override
            public void onHide(HideEvent hideEvent) {
            	icon_up_down.setIcon(IconType.WINDOW_MAXIMIZE);
            }
        });
        
        collapseTop5.addShowHandler(new ShowHandler() {
            @Override
            public void onShow(ShowEvent showEvent) {
            	icon_up_down_top5.setIcon(IconType.WINDOW_MINIMIZE);
            }
        });	
        
        collapseTop5.addHideHandler(new HideHandler() {
            @Override
            public void onHide(HideEvent hideEvent) {
            	icon_up_down_top5.setIcon(IconType.WINDOW_MAXIMIZE);
            }
        });
		
        
        // Generates data and handling for left mid panel (target bars) - and set Weekly target as default active class.
        WeeklyTarget.setActive(true);
        MonthlyTarget.setActive(false);
        AnnuallyTarget.setActive(false);
        
        for(int j = 0; j < targetBarPercentWeekly.length; j++){
        	targetBarMaxMonthly[j] = targetBarMaxWeekly[j]*4;
        	targetBarMaxAnnually[j] = targetBarMaxWeekly[j]*4*12;
        	targetBarLabelWeekly[j] = Double.toString(Math.floor(targetBarPercentWeekly[j]/100*targetBarMaxWeekly[j])) + " / " + Double.toString(targetBarMaxWeekly[j]);
        	targetBarLabelMonthly[j] = Double.toString(Math.floor(targetBarPercentMonthly[j]/100*targetBarMaxMonthly[j])) + " / " + Double.toString(targetBarMaxMonthly[j]);
        	targetBarLabelAnnually[j] = Double.toString(Math.floor(targetBarPercentAnnually[j]/100*targetBarMaxAnnually[j])) + " / " + Double.toString(targetBarMaxAnnually[j]);
        } 
        
        
        
        
 	   Object[] targetBarObject= new Object[targetBarPercentWeekly.length];
 	   Object[] targetBarTextObject= new Object[targetBarPercentWeekly.length];
 	   targetBarObject[0] = targetBar1; targetBarObject[1] = targetBar2; targetBarObject[2] = targetBar3; targetBarObject[3] = targetBar4;  
 	   targetBarTextObject[0] = targetBar1Text; targetBarTextObject[1] = targetBar2Text; targetBarTextObject[2] = targetBar3Text; targetBarTextObject[3] = targetBar4Text; 
      
 	   
 	  if(WeeklyTarget.isActive()){ 
   	   for(int j = 0; j < targetBarPercentWeekly.length;j++){
    	   ((Anchor)targetBarTextObject[j]).setText(targetBarLabelWeekly[j]);	    	   
    	   ((ProgressBar)targetBarObject[j]).setPercent(targetBarPercentWeekly[j]);
    	   double procentInBar = ((ProgressBar)targetBarObject[j]).getPercent();
    	   if(procentInBar <= 20){
    		   ((ProgressBar)targetBarObject[j]).setType(ProgressBarType.DANGER);
    		   ((Anchor)targetBarTextObject[j]).setIcon(IconType.WARNING);
    	   } else if(procentInBar > 20 & procentInBar <= 60){
    		   ((ProgressBar)targetBarObject[j]).setType(ProgressBarType.WARNING);
    		   ((Anchor)targetBarTextObject[j]).setIcon(null);
    	   } else if (procentInBar > 60 && procentInBar < 100){
    		   ((ProgressBar)targetBarObject[j]).setType(ProgressBarType.SUCCESS);
    		   ((Anchor)targetBarTextObject[j]).setIcon(null);
    	   } else if (procentInBar == 100){
    		   ((ProgressBar)targetBarObject[j]).setType(ProgressBarType.SUCCESS);
    		   ((Anchor)targetBarTextObject[j]).setIcon(IconType.CHECK);
    	   }
    	   ((Anchor)targetBarTextObject[j]).setIconPosition(IconPosition.RIGHT);
	    }
 	  } 
        // SETS THE TARGET BARS TO THEIR WEEKLY TARGET AND VALUES (WOULD LATER COME FROM THE SERVER)
        WeeklyTarget.addClickHandler(new ClickHandler() {
	       @Override
	       public void onClick(ClickEvent event) {
	    	   for(int j = 0; j < targetBarPercentWeekly.length;j++){
		    	   ((Anchor)targetBarTextObject[j]).setText(targetBarLabelWeekly[j]);	    	   
		    	   ((ProgressBar)targetBarObject[j]).setPercent(targetBarPercentWeekly[j]);
		    	   double procentInBar = ((ProgressBar)targetBarObject[j]).getPercent();
		    	   if(procentInBar <= 20){
		    		   ((ProgressBar)targetBarObject[j]).setType(ProgressBarType.DANGER);
		    		   ((Anchor)targetBarTextObject[j]).setIcon(IconType.WARNING);
		    	   } else if(procentInBar > 20 & procentInBar <= 60){
		    		   ((ProgressBar)targetBarObject[j]).setType(ProgressBarType.WARNING);
		    		   ((Anchor)targetBarTextObject[j]).setIcon(null);
		    	   } else if (procentInBar > 60 && procentInBar < 100){
		    		   ((ProgressBar)targetBarObject[j]).setType(ProgressBarType.SUCCESS);
		    		   ((Anchor)targetBarTextObject[j]).setIcon(null);
		    	   } else if (procentInBar == 100){
		    		   ((ProgressBar)targetBarObject[j]).setType(ProgressBarType.SUCCESS);
		    		   ((Anchor)targetBarTextObject[j]).setIcon(IconType.CHECK);
		    	   }
		    	   ((Anchor)targetBarTextObject[j]).setIconPosition(IconPosition.RIGHT);
			    }
	    	   
	           WeeklyTarget.setActive(true);
	           MonthlyTarget.setActive(false);
	           AnnuallyTarget.setActive(false);
	       	  }
		    });

        // SETS THE TARGET BARS TO THEIR MONTHLY TARGET AND VALUES (WOULD LATER COME FROM THE SERVER)
        MonthlyTarget.addClickHandler(new ClickHandler() {
	       @Override
	       public void onClick(ClickEvent event) {
	    	   for(int j = 0; j < targetBarPercentMonthly.length;j++){
		    	   ((Anchor)targetBarTextObject[j]).setText(targetBarLabelMonthly[j]);	    	   
		    	   ((ProgressBar)targetBarObject[j]).setPercent(targetBarPercentMonthly[j]);
		    	   double procentInBar = ((ProgressBar)targetBarObject[j]).getPercent();
		    	   if(procentInBar <= 20){
		    		   ((ProgressBar)targetBarObject[j]).setType(ProgressBarType.DANGER);
		    		   ((Anchor)targetBarTextObject[j]).setIcon(IconType.WARNING);
		    	   } else if(procentInBar > 20 & procentInBar <= 60){
		    		   ((ProgressBar)targetBarObject[j]).setType(ProgressBarType.WARNING);
		    		   ((Anchor)targetBarTextObject[j]).setIcon(null);
		    	   } else if (procentInBar > 60 && procentInBar < 100){
		    		   ((ProgressBar)targetBarObject[j]).setType(ProgressBarType.SUCCESS);
		    		   ((Anchor)targetBarTextObject[j]).setIcon(null);
		    	   } else if (procentInBar == 100){
		    		   ((ProgressBar)targetBarObject[j]).setType(ProgressBarType.SUCCESS);
		    		   ((Anchor)targetBarTextObject[j]).setIcon(IconType.CHECK);
		    	   }
			    }
	           WeeklyTarget.setActive(false);
	           MonthlyTarget.setActive(true);
	           AnnuallyTarget.setActive(false);
	       	  }
		    });
        
        // SETS THE TARGET BARS TO THEIR ANNUALLY TARGET AND VALUES (WOULD LATER COME FROM THE SERVER)
        AnnuallyTarget.addClickHandler(new ClickHandler() {
	       @Override
	       public void onClick(ClickEvent event) {
	    	   for(int j = 0; j < targetBarPercentAnnually.length;j++){
		    	   ((Anchor)targetBarTextObject[j]).setText(targetBarLabelAnnually[j]);	    	   
		    	   ((ProgressBar)targetBarObject[j]).setPercent(targetBarPercentAnnually[j]);
		    	   double procentInBar = ((ProgressBar)targetBarObject[j]).getPercent();
		    	   if(procentInBar <= 20){
		    		   ((ProgressBar)targetBarObject[j]).setType(ProgressBarType.DANGER);
		    		   ((Anchor)targetBarTextObject[j]).setIcon(IconType.WARNING);
		    	   } else if(procentInBar > 20 & procentInBar <= 60){
		    		   ((ProgressBar)targetBarObject[j]).setType(ProgressBarType.WARNING);
		    		   ((Anchor)targetBarTextObject[j]).setIcon(null);
		    	   } else if (procentInBar > 60 && procentInBar < 100){
		    		   ((ProgressBar)targetBarObject[j]).setType(ProgressBarType.SUCCESS);
		    		   ((Anchor)targetBarTextObject[j]).setIcon(null);
		    	   } else if (procentInBar == 100){
		    		   ((ProgressBar)targetBarObject[j]).setType(ProgressBarType.SUCCESS);
		    		   ((Anchor)targetBarTextObject[j]).setIcon(IconType.CHECK);
		    	   }
			    }
	           WeeklyTarget.setActive(false);
	           MonthlyTarget.setActive(false);
	           AnnuallyTarget.setActive(true);	    	   
	       	  }
		    });
		
	}

	
	
	
}