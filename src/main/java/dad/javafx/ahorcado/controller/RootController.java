package dad.javafx.ahorcado.controller;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import dad.javafx.ahorcado.model.Puntuacion;
import dad.javafx.ahorcado.model.RootModel;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.util.StringConverter;
import javafx.util.converter.NumberStringConverter;

public class RootController implements Initializable{
	
	//model
	
	private RootModel rootmodel = new RootModel();
	
	//view
	@FXML
    private TabPane root;

    @FXML
    private Tab partidaTab;

    @FXML
    private VBox partidaVBox;

    @FXML
    private BorderPane imagenPuntuacionBorderPane;

    @FXML
    private VBox puntuacionVBox;

    @FXML
    private HBox puntosHBox;

    @FXML
    private Label staticpuntosLabel;

    @FXML
    private Label puntosLabel;

    @FXML
    private HBox vidaHBox;

    @FXML
    private Label vidaLabel;

    @FXML
    private ImageView imagenImagenView;

    @FXML
    private HBox palabraHBox;

    @FXML
    private Label palabraLabel;

    @FXML
    private HBox letrasHBox;

    @FXML
    private Label letrasLabel;

    @FXML
    private HBox introducirHBox;

    @FXML
    private TextField introducirTextField;

    @FXML
    private Button letraButton;

    @FXML
    private Button resolverButton;

    @FXML
    private Tab palabrasTab;

    @FXML
    private HBox palabrasHBox;

    @FXML
    private VBox palabrasVBox;

   
	@FXML
    private ListView<String> palabrasListView;

    @FXML
    private VBox BotonesVBox;

    @FXML
    private Button anyadirButton;

    @FXML
    private Button quitarButton;

    @FXML
    private Tab puntuacionesTab;

    @FXML
    private HBox puntuacionHBox;

    @FXML
    private ListView<Puntuacion> puntuacionesListView;
	
	
	public RootController() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/RootView.fxml"));
		loader.setController(this);
		loader.load();
	}
	public void initialize(URL location, ResourceBundle resources) {
		// bindeos
	System.out.println("initia");
	palabrasListView.itemsProperty().bind(rootmodel.palabrasProperty());
	puntuacionesListView.itemsProperty().bind(rootmodel.puntuacionesProperty());
	palabraLabel.textProperty().bind(rootmodel.ocultaProperty());
	puntosLabel.textProperty().bind(rootmodel.puntuacionProperty().asString());
	vidaLabel.textProperty().bind(rootmodel.vidasProperty().asString());
	imagenImagenView.imageProperty().bind(rootmodel.imagenProperty());
	letrasLabel.textProperty().bind(rootmodel.letrasProperty());
	
	anyadirButton.setOnAction(e -> onAnyadirButton());
	quitarButton.setOnAction(e -> onQuitarButton());
	letraButton.setOnAction(e -> onLetraButton());
	resolverButton.setOnAction(e -> onResolverButton());
	
		
		
	}
	private void onResolverButton() {
		if(introducirTextField.getText().trim().equals(rootmodel.getPalabra())) {
			rootmodel.setPuntuacion(rootmodel.getPalabra().length());
			ganar();
		}
		
	}
	private void onLetraButton() {
		String nuevo = AhorcadoFunciones.cambiarString(rootmodel.getPalabra(),rootmodel.getOculta(),introducirTextField.getText().trim().charAt(0));
		//acertar
		if(!nuevo.equals(rootmodel.getOculta())) {
			rootmodel.setPuntuacion((int) rootmodel.puntuacionProperty().add(1.0).doubleValue());
			rootmodel.setOculta(nuevo);
			if(nuevo.equals(rootmodel.getPalabra())) {
				ganar();	
				
			}
			//fallar
		}else{
			rootmodel.setVidas((int) rootmodel.vidasProperty().subtract(1.0).doubleValue());
			rootmodel.setImagen(new Image("/images/"+(9-rootmodel.getVidas())+".png"));
			rootmodel.setLetras(rootmodel.getLetras().concat(introducirTextField.getText().charAt(0)+" "));
			if(rootmodel.getVidas()==0) {
				perder();
			}
		}
		
		introducirTextField.clear();
		}
	
	public void perder() {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle(":(");
		alert.setHeaderText("Game Over");
		alert.setContentText("Perdiste intentalo de nuevo");
		alert.showAndWait();
		iniciarJuego();
		
	}
	
	
	public void ganar() {
		TextInputDialog dialog = new TextInputDialog();
		dialog.setTitle("Ahorcado");
		dialog.setHeaderText("¡Has ganado!");
		dialog.setContentText("introduce tu nombre para poder guardar tu puntuación");
		Optional<String> result = dialog.showAndWait();
		if (result.isPresent()){
		    rootmodel.puntuacionesProperty().add(new Puntuacion(result.get(),rootmodel.getPuntuacion()));
		}
		iniciarJuego();
	}	
	
	public void iniciarJuego() {
		rootmodel.setPalabra((AhorcadoFunciones.cogerPalabra(rootmodel.getPalabras())));
		rootmodel.setOculta(AhorcadoFunciones.generarOculta(rootmodel.getPalabra()));
		rootmodel.imagenProperty().set(new Image("/images/1.png"));
		rootmodel.setPuntuacion(0);
		rootmodel.setVidas(8);
		rootmodel.setLetras("");
		
	}
	 private void onQuitarButton() {
		 int index;
		if((index = palabrasListView.getSelectionModel().getSelectedIndex())!=-1) {
		rootmodel.palabrasProperty().remove(index);
		}
	
	}
	private void onAnyadirButton() {
		 TextInputDialog dialog = new TextInputDialog();
		 dialog.setTitle("Nueva palabra");
		 dialog.setHeaderText("Introduce una nueva palabra");
		 Optional<String> result = dialog.showAndWait();
		 String palabra;
		 if((palabra = result.get().trim())!=null)
		 rootmodel.palabrasProperty().add(palabra);
	}	 
	 
	public RootModel getRootmodel() {
			return rootmodel;
		}
	public TabPane getView() {
		return root;
	}
}