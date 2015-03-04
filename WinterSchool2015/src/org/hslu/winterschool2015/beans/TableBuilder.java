package org.hslu.winterschool2015.beans;



import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.LinkedList;


public class TableBuilder {
	
	
	
	
	
	public String buildTable (ResultSet dbRes){
		StringBuffer htmltable = new StringBuffer();
		try {
			int columCount = dbRes.getMetaData().getColumnCount();
			int actColum =1;
			
			
			
			htmltable.append("<table border=\"1\">\n");
			
			//spalten Namen mit anzeigen
			htmltable.append("<tr class=\"list\">\n");
			while(actColum <= columCount){
				htmltable.append("<th class=\"list\">");
				htmltable.append(dbRes.getMetaData().getColumnName(actColum).replaceAll("_", ""));
				htmltable.append("</th>\n");
				
				actColum++;
			}
			actColum=1;
			htmltable.append("</tr>\n");
			
			
			
			while(dbRes.next()){
				
				htmltable.append("<tr class=\"list\">\n");
				
				while(actColum <= columCount){
					htmltable.append("<td class=\"list\">");
					htmltable.append(dbRes.getObject(actColum));
					htmltable.append("</td>\n");
					
					actColum++;
					
					
				}
				htmltable.append("</tr>\n");
				actColum=1;
				
			}
			htmltable.append("</table>\n");
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			htmltable = null;
			htmltable.append("TABLE BUILDER ERROR");
			
		}

		return htmltable.toString();
	}
	
	
	
	

}
