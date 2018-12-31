package com.randomactsofdev;

import java.util.ResourceBundle;

import javafx.beans.binding.StringBinding;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

/** Resource factory that can notify observers when the contents change (e.g. change of language) */
public class ObservableResourceFactory {

    private ObjectProperty<ResourceBundle> resources = new SimpleObjectProperty<>();
    
    public ObjectProperty<ResourceBundle> resourcesProperty() {
        return resources ;
    }
    
    public final ResourceBundle getResources() {
        return resourcesProperty().get();
    }
    
    public final void setResources(ResourceBundle resources) {
        resourcesProperty().set(resources);
    }

    public StringBinding getStringBinding(String key) {
        return new StringBinding() {
        	{bind(resourcesProperty()); }
            @Override
            public String computeValue() {
                return getResources().getString(key);
            }
        };
    }
}