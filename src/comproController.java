
import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class comproController {
	
	public main main1 = new main();
	public carculate calaulate = new carculate("my code");
	int clickNum = 0;
	double sumScore;
	//用来存取每次用户填写的答案结果，用数组进行存取；
	public static long[] inputList = new long[calculateController.numOfQuestion];
	public static long[] anaList = new long[calculateController.numOfQuestion];
    @FXML
    private TextField resultText;

    @FXML
    private VBox vbox;

    @FXML
    private HBox hbox;

    @FXML
    private Label lbl1;

    @FXML
    private Label lbl2;

    @FXML
    private Label lbl3;
    
    @FXML
    private Label lbl4;

    @FXML
    private TextField qaText;

    @FXML
    private Button frontBtn;
    
    @FXML
    private void initialize() {
    	int totalNumber = calculateController.numOfQuestion;
    	//for(int i = 0;i<calculateController.numOfQuestion;i++) {
    	//System.out.println(calaulate.queslist[0]);
    		//qaText.setText(qa);
    	//}
    	lbl4.setText("第"+(clickNum+1)+"题");
    	if(clickNum==0) {
    		showTimu();
    	}
    	//showTimu();
    	qaText.setText(calaulate.queslist[clickNum]); 
    }
    
    public void showTimu() {
    	//int[] fu = {1,1,0,0};
    	calaulate.setting(calculateController.ge, calculateController.wei, calculateController.fu, calculateController.numOfQuestion);
    	calaulate.create();//创建题目数量为numOfQuestion的题目数组
    	//将创建的string型题目数组放入界面中
    	//qaText.setText(calaulate.queslist[clickNum]); 
    	for(int i =0;i<calaulate.anslist.length;i++) {
    		anaList[i] = calaulate.anslist[i];
    	}
    	System.out.println("showtumu:"+clickNum);
    	System.out.println("fenxishuzu:"+calaulate.anslist[0]);
	}
    
    @FXML
    private void frontBtnAction() throws IOException {
    	clickNum++;
    	if(clickNum<calculateController.numOfQuestion) {
    	//if(clickNum<3) {
    		if( !resultText.getText().equals("")) {
    			initialize();
    			inputList[clickNum-1] = Long.parseLong(resultText.getText());
    			System.out.println(resultText.getText());
    			resultText.setText("");
    			System.out.println("清空后："+resultText.getText());
    		}else {
    			main1.showWarnStage();
    		}
    		
    	}else {
    		//显示最终结果页面
    		inputList[clickNum-1] = Long.parseLong(resultText.getText());
    		System.out.println(resultText.getText());
    		main1.showResultScene();
    	}       	     
    	
    }       
	
}
