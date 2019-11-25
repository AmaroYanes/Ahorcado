package dad.javafx.ahorcado.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ListProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.image.Image;

public class RootModel {
	
	
	ListProperty<Puntuacion> puntuaciones;
	private ListProperty<String> palabras;
	//palabra elegida aleatoriamente
	private StringProperty palabra;
	//palabra mostrada
	private StringProperty oculta;
	private IntegerProperty puntuacion;
	private IntegerProperty vidas;
	private ObjectProperty<Image> imagen;
	private StringProperty letras;
	
	//
	
	public RootModel() {
		
		puntuaciones = new SimpleListProperty<Puntuacion>(FXCollections.observableArrayList());
		palabras = new SimpleListProperty<String>(FXCollections.observableArrayList());
		palabra = new SimpleStringProperty();
		oculta = new SimpleStringProperty();
		puntuacion = new SimpleIntegerProperty();
		puntuacion.set(0);
		vidas = new SimpleIntegerProperty();
		vidas.set(8);
		letras = new SimpleStringProperty();
		imagen = new SimpleObjectProperty<Image>();
		imagen.set(new Image("/images/1.png"));
	}

	public final ListProperty<Puntuacion> puntuacionesProperty() {
		return this.puntuaciones;
	}
	

	public final ObservableList<Puntuacion> getPuntuaciones() {
		return this.puntuacionesProperty().get();
	}
	

	public final void setPuntuaciones(final ObservableList<Puntuacion> puntuaciones) {
		this.puntuacionesProperty().set(puntuaciones);
	}
	

	public final ListProperty<String> palabrasProperty() {
		return this.palabras;
	}
	

	public final ObservableList<String> getPalabras() {
		return this.palabrasProperty().get();
	}
	

	public final void setPalabras(final ObservableList<String> palabras) {
		this.palabrasProperty().set(palabras);
	}
	

	public final StringProperty palabraProperty() {
		return this.palabra;
	}
	

	public final String getPalabra() {
		return this.palabraProperty().get();
	}
	

	public final void setPalabra(final String palabra) {
		this.palabraProperty().set(palabra);
	}
	

	public final StringProperty ocultaProperty() {
		return this.oculta;
	}
	

	public final String getOculta() {
		return this.ocultaProperty().get();
	}
	

	public final void setOculta(final String oculta) {
		this.ocultaProperty().set(oculta);
	}

	public final IntegerProperty puntuacionProperty() {
		return this.puntuacion;
	}
	

	public final int getPuntuacion() {
		return this.puntuacionProperty().get();
	}
	

	public final void setPuntuacion(final int puntuacion) {
		this.puntuacionProperty().set(puntuacion);
	}
	

	public final IntegerProperty vidasProperty() {
		return this.vidas;
	}
	

	public final int getVidas() {
		return this.vidasProperty().get();
	}
	

	public final void setVidas(final int vidas) {
		this.vidasProperty().set(vidas);
	}

	public final ObjectProperty<Image> imagenProperty() {
		return this.imagen;
	}
	

	public final Image getImagen() {
		return this.imagenProperty().get();
	}
	

	public final void setImagen(final Image imagen) {
		this.imagenProperty().set(imagen);
	}

	public final StringProperty letrasProperty() {
		return this.letras;
	}
	

	public final String getLetras() {
		return this.letrasProperty().get();
	}
	

	public final void setLetras(final String letras) {
		this.letrasProperty().set(letras);
	}
}
