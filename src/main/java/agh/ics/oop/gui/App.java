package agh.ics.oop.gui;

import agh.ics.oop.*;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.FileNotFoundException;


public class App extends javafx.application.Application implements IGUIObserver{
    private final double cell_size = 40;
    //move delay zawiera sie w GUI simulation engine

    private final AbstractWorldMap map = new GrassField(3);
    private final GridPane grid = new GridPane();

    Button startButton = new Button("Start");
    private final int width = 600;
    private final int height = 600;

    @Override
    public void start(Stage primaryStage){
        TextField inputField = new TextField();

        String[] args = getParameters().getRaw().toArray(new String[0]);
        MoveDirection[] direction = new OptionsParser().parse(args);
        Vector2d[] position = {new Vector2d(1, -1), new Vector2d(2, 4)};

        // UI SCENE
        Scene uiScene = new Scene(new VBox(startButton,new HBox(new Label("Enter Arguments f ,b ,l ,r :"),inputField)));
        Stage secondStage = new Stage();
        secondStage.setTitle("controls");
        secondStage.setHeight(100);
        secondStage.setWidth(300);
        secondStage.setX(100);
        secondStage.setAlwaysOnTop(true);
        secondStage.setScene(uiScene);
        secondStage.show();
        //
        Scene scene = new Scene(grid, width, height);
        primaryStage.setScene(scene);
        primaryStage.show();

        SimulationEngineGUI engine = new SimulationEngineGUI(map, position);
        engine.addObserver(this);

        startButton.setOnAction(e -> {
            if (inputField.getText().isEmpty())
                return;
            String[] newMoves = inputField.getCharacters().toString().split(" ");
            MoveDirection[] newDirection = new OptionsParser().parse(newMoves);
            engine.directionSetter(newDirection);
            new Thread(engine).start();
        });
    }

    public void draw() throws FileNotFoundException {
        System.out.println(map.getLowerBound().toString() + " " + map.getUpperBound().toString());
        grid.setGridLinesVisible(true);
        grid.setPadding(new Insets(10, 10, 10, 10));
        drawHeader(map, grid);
        drawObjects(map, grid);

    }
    @Override
    public void render() {
        Platform.runLater(() -> {
            grid.getChildren().clear();
            
            try {
                draw();
                grid.setGridLinesVisible(false);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        });
    }

    void drawHeader(AbstractWorldMap map, GridPane grid) {
        Label label = new Label("y\\x");
        grid.add(label, 0, 0);
        grid.getColumnConstraints().add(new ColumnConstraints(this.cell_size));
        grid.getRowConstraints().add(new RowConstraints(this.cell_size));
        GridPane.setHalignment(label, HPos.CENTER);
        for (int i = map.getLowerBound().x; i <= map.getUpperBound().x ; i++) {
            addToGrid(String.format("%d", i),i - map.getLowerBound().x + 1,0);
            grid.getColumnConstraints().add(new ColumnConstraints(this.cell_size));
        }
        for (int i = map.getUpperBound().y; i >= map.getLowerBound().y; i--) {
            addToGrid(String.format("%d", i),0,map.getUpperBound().y-i+1);
            grid.getRowConstraints().add(new RowConstraints(this.cell_size));
        }
    }
    private void addToGrid(String text, int col, int row) {
        Label label = new Label(text);
        grid.add(label, col, row);
        GridPane.setHalignment(label, HPos.CENTER);
    }

    void drawObjects(AbstractWorldMap map, GridPane grid) throws FileNotFoundException {
        for (int i = map.getLowerBound().x; i <= map.getUpperBound().x; i++) {
            for (int j = map.getUpperBound().y; j >= map.getLowerBound().y; j--) {
                Object toAdd = map.objectAt(new Vector2d(i , j));
                if (toAdd == null) {
                    continue;
                }
                IElementMap toAddElement = (IElementMap) toAdd;

                GuiElementBox box = new GuiElementBox(toAddElement);
                Label label = new Label(toAdd.toString());
                if (toAdd instanceof Grass){
                    grid.add(box.vbox, i - map.getLowerBound().x + 1, map.getUpperBound().y - j + 1);
                }
                if (toAdd instanceof Animal){
                    grid.add(box.vbox, i - map.getLowerBound().x + 1, map.getUpperBound().y - j + 1);
                }
                GridPane.setHalignment(label, HPos.CENTER);
            }
        }
    }
}
