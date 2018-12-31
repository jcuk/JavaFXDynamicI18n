package com.randomactsofdev;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;

public class Controller {

	@FXML
	private Button uk;
	
	@FXML
	private Button fr;
	
	@FXML
	private Button se;
	
	@FXML
	public void initialize() {
		uk.onActionProperty().set((ActionEvent event)->{
			DynamicI18n.setLocale("en");
		});
		
		fr.onActionProperty().set((ActionEvent event)->{
			DynamicI18n.setLocale("fr");
		});
		
		se.onActionProperty().set((ActionEvent event)->{
			DynamicI18n.setLocale("se");
		});
	}
	
}
