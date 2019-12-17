package GuiFx;

import Models.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;


/**
 * This class makes all what concerns the historic of the game
 *
 * @author leopoldmols
 */
public class Historic extends TableView<Tour> implements Observer
{
    /*private final TableColumn id;
    private final TableColumn name;
    private final TableColumn action;
    private final TableColumn position;
    private final TableColumn row;
    private final TableColumn column;
    private final TableColumn nbPrises;*/
    private final Model game;
    private final ObservableList<Tour> list;

    /**
     * Constructs an object "Historic"
     *
     * @param game the game belonging which the historic has to be updated
     */
    public Historic(Model game)
    {
        this.game = game;
        this.list = FXCollections.observableArrayList();
        initHistoric();
        this.game.registerObserver(this);
    }

    /**
     * Initializes the historic
     */
    public void initHistoric()
    {
        //All the parameters needed for one tableView row
        TableColumn<Tour, String> id = new TableColumn<>("ID");
        TableColumn<Tour, String> name = new TableColumn<>("Name");
        TableColumn<Tour, String> action = new TableColumn<>("Action");
        TableColumn<Tour, String> positions = new TableColumn<>("Position");
        TableColumn<Tour, String> row = new TableColumn<>("Ligne");
        TableColumn<Tour, String> column = new TableColumn<>("Colonne");
        TableColumn<Tour, String> nbPrises = new TableColumn<>("Nombre de prises");

        // Adds sub columns to the FullName
        positions.getColumns().addAll(row, column);

        // Defines how to fill data for each cell.
        // Get value from property of Tour.
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        action.setCellValueFactory(new PropertyValueFactory<>("action"));
        row.setCellValueFactory(new PropertyValueFactory<>("row"));
        column.setCellValueFactory(new PropertyValueFactory<>("column"));
        nbPrises.setCellValueFactory(new PropertyValueFactory<>("nbPrises"));

        // Align every cell infos on the center of the cell
        id.setStyle("-fx-alignment: CENTER;");
        name.setStyle("-fx-alignment: CENTER;");
        action.setStyle("-fx-alignment: CENTER;");
        row.setStyle("-fx-alignment: CENTER;");
        column.setStyle("-fx-alignment: CENTER;");
        nbPrises.setStyle("-fx-alignment: CENTER;");
        
        for (int i = 0; i < game.getTours().size(); i++)
        {
            Tour tour;
            /*tour = new Tour(
                    Integer.parseInt(game.getTours().get(i).getId()),
                    game.getCurrent().getColor().toString(),
                    game.getTours().get(i).getAction(),
                    Integer.parseInt(game.getTours().get(i).getRow()),
                    Integer.parseInt(game.getTours().get(i).getColumn()),
                    Integer.parseInt(game.getTours().get(i).getNbPrises())
            );*/
            tour = game.getTours().get(i);
                
            this.getItems().add(tour);
        }

        this.setItems(list);
        //this.setItems(game.getTours());
        
        getColumns().addAll(id, name, action, positions, nbPrises);
    }

    /**
     * Overrides the update() method form the Observer interface
     */
    @Override
    public void update()
    {
        this.getItems().add(game.getTours().get(game.getTours().size() - 1));
    }
}
