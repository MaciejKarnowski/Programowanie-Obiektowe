package agh.ics.oop.gui;

import agh.ics.oop.*;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.*;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;


public class App extends javafx.application.Application{

    @Override
    public void start(Stage primaryStage) throws Exception {
        AbstractWorldMap map = new GrassField(10);
        String[] args = getParameters().getRaw().toArray(new String[0]);
        MoveDirection[] direction = new OptionsParser().parse(args);
        Vector2d[] position = {new Vector2d(4, 0), new Vector2d(2,0), new Vector2d(7,0), new Vector2d(3,0)};
        SimulationEngine engine = new SimulationEngine(direction, map, position);
        engine.run();

        GridPane grid = new GridPane();
        grid.setGridLinesVisible(true);
        grid.setPadding(new Insets(10, 10, 10, 10));

        drawHeader(map, grid);
        drawObjects(map, grid);

        System.out.println(map.toString());



        //GridPane.setHalignment(label, HPos.CENTER);

        Scene scene = new Scene(grid, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    void drawHeader(AbstractWorldMap map, GridPane grid) {
        Label label = new Label("y\\x");
        grid.add(label, 0, 0);
        grid.getColumnConstraints().add(new ColumnConstraints(20));
        grid.getRowConstraints().add(new RowConstraints(20));
        GridPane.setHalignment(label, HPos.CENTER);
        for (int i = map.getLowerBound().x; i <= map.getUpperBound().x; i++) {
            label = new Label(String.format("%d", i));
            grid.add(label, i - map.getLowerBound().x + 1, 0);
            grid.getColumnConstraints().add(new ColumnConstraints(20));
            GridPane.setHalignment(label, HPos.CENTER);

        }
        for (int i = map.getUpperBound().y; i >= map.getLowerBound().y; i--) {
            label = new Label(String.format("%d", map.getUpperBound().y - i));
            grid.add(label, 0, i - map.getLowerBound().y + 1);
            grid.getRowConstraints().add(new RowConstraints(20));
            GridPane.setHalignment(label, HPos.CENTER);
        }
    }

    void drawObjects(AbstractWorldMap map, GridPane grid) {
        for (int i = map.getLowerBound().x; i <= map.getUpperBound().x; i++) {
            for (int j = map.getUpperBound().y; j >= map.getLowerBound().y; j--) {
                Object toAdd = map.objectAt(new Vector2d(i, j));
                if (toAdd == null) {
                    continue;
                }
                Label label = new Label(toAdd.toString());
                grid.add(label, i + 1, map.getUpperBound().y - j + 1);
                GridPane.setHalignment(label, HPos.CENTER);
            }
        }
    }

}