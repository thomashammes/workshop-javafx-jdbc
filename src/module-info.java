module javafx1 {
	requires javafx.controls;
	requires javafx.fxml;
	exports gui;
	
	
	opens application to javafx.graphics, javafx.fxml;
	opens gui;
	opens model.entities;
}
