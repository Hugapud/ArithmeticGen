
import java.io.IOException;

import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class calculateController {
	
	public static int numOfQuestion = 0;
	public static int ge = 0;
	public static int wei = 0;
	public static int[] fu = new int[4];
	public main main1 = new main();
	ObservableList<String> list1 =FXCollections.observableArrayList("30道题","50道题");
	ObservableList<String> list2 =FXCollections.observableArrayList("2位数以内","3位数以内");
	ObservableList<String> list3 =FXCollections.observableArrayList("2个","3个","4个");
	
	
	@FXML
    private VBox vbox;

    @FXML
    private BorderPane borderpane;

    @FXML
    private ComboBox<String>  combox1;

    @FXML
    private CheckBox checkBox4;

    @FXML
    private ComboBox<String>  combox3;

    @FXML
    private ComboBox<String>  combox2;

    @FXML
    private Button confirmBtn;

    @FXML
    private CheckBox checkBox3;

    @FXML
    private Label lbl1;

    @FXML
    private Label lbl5;

    @FXML
    private Label lbl2;

    @FXML
    private GridPane gridpane;

    @FXML
    private VBox vbox1;

    @FXML
    private CheckBox checkBox2;

    @FXML
    private CheckBox checkBox1;

    @FXML
    private Button generateBtn;

    @FXML
    private TextArea textArea;
	    
	    @FXML
	    private void initialize() {
	    	combox1.setValue("30道题");
	    	combox1.setItems(list1);
	    	combox2.setValue("2位数以内");
	    	combox2.setItems(list2);
	    	combox3.setValue("2个");
	    	combox3.setItems(list3);
	    	
	    }
	    
	    @FXML
	    private void affirmBtnAction() throws IOException {    	
	    /*	checkBox1.selectedProperty().addListener(
     	            (ObservableValue<? extends Boolean> ov,
     	                Boolean old_val, Boolean new_val) -> {
     	                	          
     	        });*/
	    	//String s = "";	    	
	    	
	    /*  	checkBox1.selectedProperty().addListener(
	    			(ObservableValue<? extends Boolean> ov,
	    				Boolean  old_val,Boolean new_val)->{
	    					String s ="ssss";	
	    					//textArea.setText(s);
	    	});
	      	checkBox2.selectedProperty().addListener(
	    			(ObservableValue<? extends Boolean> ov,
	    				Boolean  old_val,Boolean new_val)->{
	    					String s ="www";	
	    					textArea.setText(s);
	    	});*/
	    	if(combox1.getValue().toString().equals("30道题")) {
	    		numOfQuestion = 30;	    				
	    	}else {
				numOfQuestion = 50;
			}
	    	
	    	if(combox2.getValue().toString().equals("2位数以内")) {
	    		wei = 0;
	    	}else {
	    		wei = 1;
	    	}
	    	
	    	if(combox3.getValue().toString().equals("2个")) {
	    		ge = 2;
	    	}else if(combox3.getValue().equals("3个")){
	    		ge = 3;
	    	}else {
				ge= 4;
			}
	    	String s="已选择参与运算符号：";
	    	String s1 ="";
	    	s1 = "已选择题量： "+combox1.getValue().toString()+" \n";
	    	System.out.println("1111111111"+s);
	    	s1 = s1 +"已选择数值范围： "+ combox2.getValue().toString()+" \n"+"已选择参与运算个数："+combox3.getValue().toString()+"\n";
	    		    	
	      	if(checkBox1.isSelected()) {
	      		fu[0] = 1;
	      		//s="已选择参与运算符号：";
	      		s=s+ "+ ";
	      		System.out.println("checkBox1 clicked");
	      	}else {
				fu[0] = 0;
			}
	    	if(checkBox2.isSelected()) {
	    		fu[1] = 1;
	      		s=s+" - ";      		
	      	}else {
	      		fu[1] = 0;
	      	}
	    	if(checkBox3.isSelected()) {
	    		fu[2] =1;
	      		s=s+" * ";	      		
	      	}else {
	      		fu[2] = 0;
	      	}
	    	if(checkBox4.isSelected()) {
	    		fu[3] = 1;
	      		s=s+" / ";	      		
	      	}else {
	      		fu[3] = 0;
	      	}
	    	
	    	/*if(!combox1.getValue().toString().equals("") && !combox2.getValue().toString().equals("") 
	    			&& !combox3.getValue().toString().equals("") &&(checkBox1.isSelected()||
	    			checkBox2.isSelected()||checkBox3.isSelected()||checkBox4.isSelected())) {
	    		textArea.setText(s1+s);	  
	    	}else {
				main1.showWarnStage1();
			}*/
	    	
	    	//进行容错判断
	    	boolean judgeResult1 = judgeComboxNull(combox1)&&judgeComboxNull(combox2)&&judgeComboxNull(combox3);
	    	boolean judgeResult2 = judgeCheckBoxNull(checkBox1)||judgeCheckBoxNull(checkBox2)
	    							||judgeCheckBoxNull(checkBox3)||judgeCheckBoxNull(checkBox4);
	    	if(judgeResult1 && judgeResult2) {
	    		textArea.setText(s1+s);	
	    	}else {
				main1.showWarnStage1();
			}
	    	  		      	
	    }
	    
	    public boolean judgeComboxNull(ComboBox<String> i) {
	    	if(i.getValue().toString().equals("")) {
	    		return false;
	    	}else {
				return true;
			}
				
	    }
	    
	    public boolean judgeCheckBoxNull(CheckBox i) {
	    	if(!i.isSelected()) {
	    		return false;
	    	}else {
				return true;
			}
	    }
	    
	    @FXML
	    private void showProScene() throws IOException {
	    	if(!textArea.getText().equals("")) {
	    		main1.showProScene();
	    	}
	    }
	    
	    
}
