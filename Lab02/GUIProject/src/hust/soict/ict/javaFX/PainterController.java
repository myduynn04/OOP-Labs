package hust.soict.ict.javaFX;

import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;

public class PainterController {
    @FXML
    private Pane drawingAreaPane;

    @FXML
    private RadioButton penRadioButton;

    @FXML
    private RadioButton eraseRadioButton;

    private boolean isEraserMode = false;
    private double lastX, lastY;

    @FXML
    private ToggleGroup toolToggleGroup;

    @FXML
    public void initialize() {

        penRadioButton.setSelected(true);
        toolToggleGroup = new ToggleGroup();
        penRadioButton.setToggleGroup(toolToggleGroup);
        eraseRadioButton.setToggleGroup(toolToggleGroup);


        Rectangle clip = new Rectangle(drawingAreaPane.getWidth(), drawingAreaPane.getHeight());
        clip.widthProperty().bind(drawingAreaPane.widthProperty());
        clip.heightProperty().bind(drawingAreaPane.heightProperty());
        drawingAreaPane.setClip(clip);
    }

    @FXML
    public void clearButtonPressed() {
        drawingAreaPane.getChildren().clear();
    }

    @FXML
    public void penButtonPressed() {
        isEraserMode = false;
    }

    @FXML
    public void eraseButtonPressed() {
        isEraserMode = true;
    }

    @FXML
    public void handleMouse(MouseEvent event) {
        if (event.getEventType() == MouseEvent.MOUSE_PRESSED) {
            lastX = event.getX();
            lastY = event.getY();
            drawLine(event.getX(), event.getY());
        } else if (event.getEventType() == MouseEvent.MOUSE_DRAGGED) {
            drawLine(event.getX(), event.getY());
        }
    }

    private void drawLine(double x, double y) {
        Line line = new Line(lastX, lastY, x, y);
        if (isEraserMode) {
            line.setStroke(Color.WHITE);
            line.setStrokeWidth(8);
        } else {
            line.setStroke(Color.BLACK);
            line.setStrokeWidth(4);
        }
        drawingAreaPane.getChildren().add(line);
        lastX = x;
        lastY = y;
    }
}
