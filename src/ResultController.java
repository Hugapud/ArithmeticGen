

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class ResultController {
	//获取从计算过程页面的答案数组，并且进行判断评分
	//public comproController calController = new comproController();
	public carculate calaulate = new carculate("my code");
	//analyst analystSample = new analyst(comproController.inputList, comproController.inputList.length);
	
	public double scoreSum = 0;
	
	@FXML
    private TextField score;

    @FXML
    private VBox vbox;

    @FXML
    private TextField grade;

    @FXML
    private Label lbl1;

    @FXML
    private Text text;

    @FXML
    private Label lbl4;

    @FXML
    private Label lbl2;

    @FXML
    private Label lbl3;
    
    @FXML
    private void initialize() {     
   		for(int i=0;i<comproController.inputList.length;i++) {
    			System.out.println("输入数组长度"+comproController.inputList.length);
    			System.out.print(comproController.inputList[i]+"");
    		} 
   		for(int i =0;i<comproController.anaList.length;i++) {
   			System.out.println("分析数组长度"+comproController.anaList.length);
			System.out.print(comproController.anaList[i]+"");
   		}
    	double score1 = compare();
    	score.setText(String.valueOf(score1));
    	if(score1<60) {
    		grade.setText("不及格");
    	}else if(score1<75) {
    		grade.setText("C");
    	}else if(score1<90) {
    		grade.setText("B");
		}else {
			if(score1<99){
				grade.setText("A");
			}else {
				grade.setText("A+");
				text.setText("Congratulations,you got 100!");
				text.setFill(Color.ALICEBLUE);
				text.setFont(Font.font(20));
			}
				
		}	
    }
    
    public double compare() {
    	int[] counter ;
    	counter=new int[comproController.anaList.length];
    	for(int i =0;i<comproController.inputList.length;i++) 
    	{
    		if(comproController.inputList[i]==comproController.anaList[i]) 
    		{
    			System.out.println("输入数："+comproController.inputList[i]);
    			counter[i]=1;
    		}
    		else counter[i]=0;
    	}
    	int score = 0;
		for(int i=0;i<=(counter.length-1);i++)
		{
			score+=counter[i];
		}
		scoreSum=score/counter.length*100.0;
    	return scoreSum;
    	
    }
    
    
}
