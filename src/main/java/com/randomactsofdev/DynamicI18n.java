package com.randomactsofdev;

import java.util.Locale;
import java.util.ResourceBundle;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Labeled;
import javafx.stage.Stage;

public class DynamicI18n extends Application {
	
	private static Logger LOG = LogManager.getLogger(DynamicI18n.class);
	
	private static final ObservableResourceFactory resourceFactory = new ObservableResourceFactory();

	public static void main(String[] args) {
		LOG.info("Application starting");
		
		launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		this.setLocale("en");
		
		final Parent root = I18nFXMLLoader.load(ClassLoader.getSystemResource("i18n.fxml"), resourceFactory, null, null);
		
		primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();
	}
	
    /** Change the language by re-loading the resources which triggers a refresh of internationalised labels */
    public static ResourceBundle setLocale(final String language) {
		LOG.info(String.format("Changing locale to %s", language));
    	final ResourceBundle resources = ResourceBundle.getBundle("strings", new Locale(language));
    	resourceFactory.setResources(resources);
    	return resources;
    }

}
