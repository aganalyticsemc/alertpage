package com.tmpPage.client;

import java.util.Arrays;
import java.util.List;



import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.RowStyles;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.ListDataProvider;




public class simpleTable extends Composite {
	
	CellTableResources resources = GWT.create(CellTableResources.class);
	
	
	  @UiField(provided = true)
	  CellTable<CellTableDataInput> table = new CellTable<CellTableDataInput>(Integer.MAX_VALUE, resources);

	private static simpleTableUiBinder uiBinder = GWT.create(simpleTableUiBinder.class);

	interface simpleTableUiBinder extends UiBinder<Widget, simpleTable> {
	}
	
	private static class CellTableDataInput {
		private final String companyName;
		private final String recommendedAction;
		private final String CLV;
		private final String churnRisk;
		private final String attentionLevel;
		private final String alertStatus;
		private final String alertDate;
		private final String dateOfHandling;
		private final String handler;

		public CellTableDataInput(String companyName, String recommendedAction,String CLV, String churnRisk, String attentionLevel, String alertStatus, String alertDate, String dateOfHandling, String handler) {
			this.companyName = companyName;
			this.recommendedAction = recommendedAction;
			this.CLV = CLV;
			this.churnRisk = churnRisk;
			this.attentionLevel = attentionLevel;
			this.alertStatus = alertStatus;
			this.alertDate = alertDate;
			this.dateOfHandling = dateOfHandling;
			this.handler = handler;
		}
		
	    public String getcompanyName() {
	        return companyName;
	    }
	    public String getRecommendedAction() {
	        return recommendedAction;
	    }
	    public String getCLV() {
	        return CLV;
	    }
	    public String getChurnRisk() {
	        return churnRisk;
	    }
	    public String getAttentionelLevel() {
	        return attentionLevel;
	    }
	    public String getAlertStatus() {
	        return alertStatus;
	    }
	    public String getAlertDate(){
	    	return alertDate;
	    }
	    public String getDateOfHandling(){
	    	return dateOfHandling;
	    }
	    public String getHandler(){
	    	return handler;
	    }
	    
	}
	
	private static String today = "31-08-2017";
	private static String lastWeek = "24-07-2017";
	private static String twoWeeksAgo = "17-07-2017";
	private static String dateHandled = "26-07-2017";
	private static String dateHandledNoResponse = "21-06-2017";
	private static String dateNotHandled = "-";
	private static String handler     = "EMC";
	private static String notHandled   = "-";


	private static List<CellTableDataInput> CELLTABLEDATA = Arrays.asList(
			new CellTableDataInput("Sundbyoster Skolefritidshjem","Call Customer","476,736 DKK","97 %","Urgent","Unhandled",lastWeek,dateNotHandled,notHandled),
			new CellTableDataInput("JNF Momentum. Koge A/S","Call Customer","390,072 DKK","88 %","Urgent","Unhandled",today,dateNotHandled,notHandled),
			new CellTableDataInput("Master International","Call Customer","167,328 DKK","99 %","Urgent","Unhandled",twoWeeksAgo,dateNotHandled,notHandled),
			new CellTableDataInput("Sydkystens Kranservice ApS","Call Customer","83,880 DKK","94 %","Urgent","Unhandled",lastWeek,dateNotHandled,notHandled),
			new CellTableDataInput("Bg Anlaegsteknik ApS","Call Customer","42,888 DKK","100 %","Urgent","Handled",lastWeek,dateHandled,handler),
			new CellTableDataInput("Kosan Gascenter, Kobenhavn","Call Customer","41,664 DKK","98 %","Urgent","Handled",twoWeeksAgo,dateHandled,handler),
			new CellTableDataInput("CF ApS","Send Personal Email","30,000 DKK","88 %","High","Unhandled",today,dateNotHandled,notHandled),
			new CellTableDataInput("Gilleleje Malerentreprise ApS","Send Personal Email","20,676 DKK","100 %","Urgent","No Response",lastWeek,dateHandledNoResponse,handler),
			new CellTableDataInput("Tomrer John A. Laursen","Send Personal Email","15,912 DKK","100 %","High","Handled",twoWeeksAgo,dateHandled,handler),
			new CellTableDataInput("Lunde Maskincenter A/S","Send Personal Email","10,128 DKK","88 %","High","Unhandled",lastWeek,dateNotHandled,notHandled),
			new CellTableDataInput("Knud Ravn-Christensen","Send Automatic Email","9,732 DKK","99 %","High","Unhandled",today,dateNotHandled,notHandled),
			new CellTableDataInput("KAB Ejendomskontoret Rosenlunden","Send Automatic Email","5,100 DKK","92 %","Low","Unhandled",twoWeeksAgo,dateNotHandled,notHandled),
			new CellTableDataInput("Sonderskov Museum","Send Automatic Email","4,560 DKK","92 %","Low","Unhandled",lastWeek,dateNotHandled,notHandled),
			new CellTableDataInput("Elfa-Lumi A/S","Send Automatic Email","4,404 DKK","100 %","Low","Unhandled",lastWeek,dateNotHandled,notHandled),
			new CellTableDataInput("Revitax A/S","Send Automatic Email};","2,088 DKK","100 %","Low","Unhandled",twoWeeksAgo,dateNotHandled,notHandled)

			);
	
//	Customized CellTable CSS is added to the default CSS from CellTable.Resources. 
	
	public interface CellTableResources extends CellTable.Resources {
	    public interface NormalStyle extends CellTable.Style {}

	    @Source({ CellTable.Style.DEFAULT_CSS, "CellTable.css" })
	    public NormalStyle cellTableStyle();
	}
	

	public simpleTable() {

		
		ListDataProvider<CellTableDataInput> dataProvider = new ListDataProvider<CellTableDataInput>();
		dataProvider.addDataDisplay(table);

		
		  TextColumn<CellTableDataInput> Col1 = new TextColumn<CellTableDataInput>() {
		      @Override
		      public String getValue(CellTableDataInput object) {
		        return object.getcompanyName();
		      }
		    };
		    	    
		  TextColumn<CellTableDataInput> Col2 = new TextColumn<CellTableDataInput>() {
		      @Override
		      public String getValue(CellTableDataInput object) {
		        return object.getRecommendedAction();
		      }
		    };	    

		  TextColumn<CellTableDataInput> Col3 = new TextColumn<CellTableDataInput>() {
		      @Override
		      public String getValue(CellTableDataInput object) {
		        return object.getCLV();
		      }
		    };
		    
		  TextColumn<CellTableDataInput> Col4 = new TextColumn<CellTableDataInput>() {
		      @Override
		      public String getValue(CellTableDataInput object) {
		        return object.getChurnRisk();
		      }
		    };		    		    
	    
		  TextColumn<CellTableDataInput> Col5 = new TextColumn<CellTableDataInput>() {
		      @Override
		      public String getValue(CellTableDataInput object) {
		        return object.getAttentionelLevel();
		      }
		    };	
		    
		  TextColumn<CellTableDataInput> Col6 = new TextColumn<CellTableDataInput>() {
		      @Override
		      public String getValue(CellTableDataInput object) {
		        return object.getAlertStatus();
		      }
		    };			    
		    
		  TextColumn<CellTableDataInput> Col7 = new TextColumn<CellTableDataInput>() {
		      @Override
		      public String getValue(CellTableDataInput object) {
		        return object.getAlertDate();
		      }
		    };
		    
		  TextColumn<CellTableDataInput> Col8 = new TextColumn<CellTableDataInput>() {
		      @Override
		      public String getValue(CellTableDataInput object) {
		        return object.getDateOfHandling();
		      }
		    };	
			    
		  TextColumn<CellTableDataInput> Col9 = new TextColumn<CellTableDataInput>() {
		      @Override
		      public String getValue(CellTableDataInput object) {
		        return object.getHandler();
		      }
		    };	
		    
		    // adds the columns to the tables
			table.addColumn(Col1, "Company Name");
			table.addColumn(Col2, "Recommended Action");	    
			table.addColumn(Col3, "Customer Lifetime Value");  
			table.addColumn(Col4, "Churn Risk");
			table.addColumn(Col5, "Attention Level");
			table.addColumn(Col6, "Alert Status");
			table.addColumn(Col7, "Alert Date");			
			table.addColumn(Col8, "Date of handling");
			table.addColumn(Col9, "Handled by");
			
			// Creates conditional formatting based on alert status. Attached every row with specific CSS-classed based on the their alert status
		    table.setRowStyles(new RowStyles<CellTableDataInput>() {
		        @Override
		        public String getStyleNames(CellTableDataInput rowObject, int rowIndex) {
		        	
		        	if(rowObject.getAlertStatus()=="Unhandled"){
		                return "alert-text-unhandled";     
		        	} else if (rowObject.getAlertStatus()=="Handled"){
		        		return "alert-text-handled";        		
		        	} else if (rowObject.getAlertStatus()=="No Response"){
		        		return "alert-text-no-reponse";        		
		        	}	        		
		        	else {
		        		return "text-info";
		        	}
		        }});
			
		    // Adds column specific CSS-classes. This allows to have normal in rows with css-class of alert status of Unhandled, handled, etc.
		    for (int i = 0; i < table.getColumnCount(); i++){
		    	table.getColumn(i).setCellStyleNames("cell-Table-col-non-alert");
		    	if (i == 5){ // alert status is in column 5
		    	table.getColumn(i).setCellStyleNames("cell-Table-col-alert");
		    	}
		    }
		    
			// ENSURES THAT THE TABLE USE ALL THE WIDTH OF THE PANEL (SET TO FALSE TO UNDUE THIS)
			table.setWidth("100%", true);
			    
			List<CellTableDataInput> list = dataProvider.getList();
			for (CellTableDataInput CellTableDataInput : CELLTABLEDATA) {
				list.add(CellTableDataInput);
			}		
		
		
		
		initWidget(uiBinder.createAndBindUi(this));
	}

}
