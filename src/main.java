

import java.io.IOException;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class main extends Application {
	
	private static Stage primaryStage;
	private static Parent root;

	@Override
	public void start(Stage primaryStage) throws Exception {
		this.primaryStage = primaryStage;
		// TODO Auto-generated method stub
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(main.class.getResource("calculate.fxml"));
		Parent root =loader.load();
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	public void showProScene() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(main.class.getResource("compuProScene.fxml"));
		Parent root =loader.load();
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public void showResultScene() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(main.class.getResource("resultScene.fxml"));
		Parent root =loader.load();
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public void showWarnStage() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(main.class.getResource("warnScene.fxml"));
		AnchorPane warnStage = loader.load();

		Stage showTextStage = new Stage();
		showTextStage.setTitle("设置错误");
		//showTextStage.initModality(Modality.WINDOW_MODAL);//WINDOW_MODAL��ʾһ��ֻ�ܴ�һ�����ڽ��в���
		showTextStage.initOwner(primaryStage);
		Scene scene = new Scene(warnStage);
		showTextStage.setScene(scene);
		showTextStage.showAndWait();
	}
	
	public void showWarnStage1() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(main.class.getResource("warnScene2.fxml"));
		AnchorPane warnStage = loader.load();

		Stage showTextStage = new Stage();
		showTextStage.setTitle("设置错误");
		//showTextStage.initModality(Modality.WINDOW_MODAL);//WINDOW_MODAL��ʾһ��ֻ�ܴ�һ�����ڽ��в���
		showTextStage.initOwner(primaryStage);
		Scene scene = new Scene(warnStage);
		showTextStage.setScene(scene);
		showTextStage.showAndWait();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

}
