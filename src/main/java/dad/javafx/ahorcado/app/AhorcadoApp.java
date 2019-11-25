package dad.javafx.ahorcado.app;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

import dad.javafx.ahorcado.controller.RootController;
import dad.javafx.ahorcado.model.Puntuacion;
import javafx.application.Application;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AhorcadoApp extends Application {


	//controller	
	private RootController rootController;
	
	
	public void start(Stage primaryStage) throws Exception {
		Scene scene = new Scene(rootController.getView(),600,400);
		System.out.println("start");
		primaryStage.setTitle("Ahorcado");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public void init() throws Exception {
		super.init();
		
		rootController = new RootController();
		FileReader fr = new FileReader("palabras.txt");
		BufferedReader br = new BufferedReader(fr);
		String linea;
		while((linea = br.readLine())!= null){	
			rootController.getRootmodel().palabrasProperty().add(linea);
		}
		br.close();
		fr.close();
		FileReader fr2 = new FileReader("puntuaciones.txt");
		BufferedReader br2 = new BufferedReader(fr2);
		String linea2;
		String [] lineaSplit;
		while((linea2 = br2.readLine())!= null){	
			lineaSplit = linea2.split(",");
			rootController.getRootmodel().puntuacionesProperty().add(new Puntuacion(lineaSplit[0],Integer.parseInt(lineaSplit[1])));
		}
		br2.close();
		fr2.close();
		rootController.iniciarJuego();
	}
	
	public void stop() throws Exception {
		super.stop();
		FileWriter fw = new FileWriter("palabras.txt");
		BufferedWriter bw = new BufferedWriter(fw);
		ObservableList<String> aux =  rootController.getRootmodel().getPalabras();
		for(int i = 0;i < aux.size();i++) {
			bw.write(aux.get(i)+"\n");
		}
		bw.close();
		fw.close();
		FileWriter fw2 = new FileWriter("puntuaciones.txt");
		BufferedWriter bw2 = new BufferedWriter(fw2);
		ObservableList<Puntuacion> aux2 =  rootController.getRootmodel().getPuntuaciones();
		for(int i = 0;i < aux2.size();i++) {
			bw2.write(aux2.get(i).getNombre()+","+aux2.get(i).getNumero()+"\n");
		}
		bw2.close();
		fw2.close();
	}
	public static void main(String[] args) {
		launch(args);
	}
}
