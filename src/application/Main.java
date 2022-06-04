package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import model.entities.Department;
import model.entities.DepartmentCollection;
import model.entities.HuffmanTree;

public class Main extends Application {
	
	private static Scene mainScene;
	
	String testCase = "passarinho que anda com morcego acaba dormindo de ponta cabeca";
	
	HuffmanTree tree = new HuffmanTree();

	@Override
	public void start(Stage primaryStage) {
		try {
			DepartmentCollection.register(new Department(1, "Itens de Batalha"));
			DepartmentCollection.register(new Department(2, "Poções"));
			DepartmentCollection.register(new Department(3, "Comidas"));
			
			System.out.println(testCase);
			
			tree.listFrequency(testCase);
			
			tree.sortList();
			
			tree.printList(tree.getList());
			
			tree.listToTree();
			
			tree.printTree(tree.getRoot());
		
			
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/MainView.fxml"));
			ScrollPane scrollPane = loader.load();
			
			scrollPane.setFitToHeight(true);
			scrollPane.setFitToWidth(true);
			
			mainScene = new Scene(scrollPane);
			primaryStage.setScene(mainScene);
			primaryStage.setTitle("POOkéShop");
			primaryStage.getIcons().add(new Image("C:\\Program Files\\eclipse\\workspace\\javafx-workshop\\src\\img\\icons8-pokemon-go-64.png"));
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static Scene getMainScene() {
		return mainScene;
	}

	public static void main(String[] args) {
		launch(args);
	}
}
