/**
 * Sample Skeleton for 'Borders.fxml' Controller Class
 */

package it.polito.tdp.borders;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.borders.model.Country;
import it.polito.tdp.borders.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class BordersController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="txtAnno"
    private TextField txtAnno; // Value injected by FXMLLoader

    @FXML // fx:id="comboStati"
    private ComboBox<Country> comboStati; // Value injected by FXMLLoader

    @FXML // fx:id="txtResult"
    private TextArea txtResult; // Value injected by FXMLLoader

    @FXML
    void doCalcolaConfini(ActionEvent event) {
    	try {
    	int anno=Integer.parseInt(txtAnno.getText());
    	txtResult.setText(model.creaGrafo(anno));
    	}
    	catch(NumberFormatException e) {
    		txtResult.setText("Inserire un anno valido");
    	}

    }

    @FXML
    void doVicini(ActionEvent event) {
    	Country c=comboStati.getValue();
    	List<Country> list=model.trovaViciniIterativo(c);
    	StringBuilder sb=new StringBuilder();
    	sb.append("Lista stati raggiungibili: \n");
    	for(Country cy:list)
    		sb.append(cy+"\n");
    	
    	txtResult.setText(sb.toString());
    	

    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert txtAnno != null : "fx:id=\"txtAnno\" was not injected: check your FXML file 'Borders.fxml'.";
        assert comboStati != null : "fx:id=\"comboStati\" was not injected: check your FXML file 'Borders.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Borders.fxml'.";

    }
    private Model model;

	public void setModel(Model model) {
		this.model=model;
		
	    comboStati.getItems().addAll(model.getCountries());
		
	}
}
