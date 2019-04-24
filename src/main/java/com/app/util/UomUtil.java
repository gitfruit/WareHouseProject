package com.app.util;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.springframework.stereotype.Component;

import com.mysql.jdbc.Util;

@Component
public class UomUtil {

	public void generatePie(String path,List<Object[]> data) {
		//data should be Converted to DataSet
		DefaultPieDataset dataset=new DefaultPieDataset();
		for(Object[] ob:data){
				dataset.setValue(ob[0].toString(), new Double(ob[1].toString()));
				}
		//Convert dataSet to JfreeCharts
		JFreeChart chart=ChartFactory.createPieChart3D("Uom Type Model", dataset, true, true, false);
		
		//Convert JfreeChart to Image
		try {
			ChartUtils.saveChartAsJPEG(new File(path+"/resources/images/UomA.jpg"), chart, 400, 400);
		}
		catch(IOException e){
			e.printStackTrace();
			
		}
	}
	
	public void generateBar(String path,List<Object[]> data) {
		//data should be Converted to Dataset
		DefaultCategoryDataset dataset=new DefaultCategoryDataset();
		for(Object[] ob:data) {
			dataset.setValue(new Double(ob[1].toString()), ob[0].toString()," ");
		}
         //Convert Dataset to JfreeCharts
		JFreeChart chart=ChartFactory.createBarChart("Uom Type Report", "Type", "count"	, dataset,PlotOrientation.HORIZONTAL,true,true,false);
		
	//Converting Chart to Image using utils
		try {
			ChartUtils.saveChartAsJPEG(new File(path+"/resources/images/UomB.jpg"), chart, 400, 400);
		}
 
		catch(IOException e) {
			e.printStackTrace();
		}
				
	}
}
