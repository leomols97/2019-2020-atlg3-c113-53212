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
    //private int id = 0;
    private Model game;
    private MenuView menuView;
    ObservableList<Tour> list;
    
    /**
     * Constructs an object "Historic"
     *
     * @param game the game belonging which the historic has to be updated
     * @param menuView
     */
    public Historic (Model game, MenuView menuView)
    {
        this.menuView = menuView;
        this.game = game;
        initHistoric();
    }
    
    /**
     * Initializes the historic
     */
    public void initHistoric ()
    {
        
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
        // Get value from property of Tour. .
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        action.setCellValueFactory(new PropertyValueFactory<>("action"));
        row.setCellValueFactory(new PropertyValueFactory<>("row"));
        column.setCellValueFactory(new PropertyValueFactory<>("column"));
        nbPrises.setCellValueFactory(new PropertyValueFactory<>("nbPrises"));
        
        // Align every cell infos on the center of the cell
        id.setStyle( "-fx-alignment: CENTER;");
        name.setStyle( "-fx-alignment: CENTER;");
        action.setStyle( "-fx-alignment: CENTER;");
        row.setStyle( "-fx-alignment: CENTER;");
        column.setStyle( "-fx-alignment: CENTER;");
        nbPrises.setStyle( "-fx-alignment: CENTER;");
        
        // Set Sort type for userName column
        id.setSortType(TableColumn.SortType.DESCENDING);
        
        getColumns().addAll(id, name, action, positions, nbPrises);
    }
    
    /*private ObservableList<Tour> getUserList()
    {
        list = getUserList();
        Tour tourX = new Tour(1, "sdfgh", Action.NOUVELLE_PARTIE, 5, 3, 1);
        if (game.getCurrent().getColor() == Color.WHITE)
        {
            tourX.setName(menuView.getMenu().getTfdPlayer1());
        }
        else
        {
            tourX.setName(menuView.getMenu().getTfdPlayer1());
        }
        tourX.setId(id);
        tourX.setAction(Action.PLACE_PIECE);
        tourX.setRow(7);
        tourX.setColumn(4);
        Tour tour2 = new Tour(2, "Jean", Action.NOUVELLE_PARTIE, 5, 3, 1);
        Tour tour3 = new Tour(3, "Auguste", Action.NOUVELLE_PARTIE, 5, 3, 1);
        
        game.notifyObservers();
        
        list = FXCollections.observableArrayList(tourX, tour2, tour3);
        
        //this.setItems(list);
        
        return list;
    }*/
    
    public void updateTable ()
    {
        game.placePiecRowTable();
        game.passRowTable();
        for (int i = 0; i < game.getTours().size(); i++)
        {
            Tour tour = game.getTours().get(i);
            this.getItems().add(tour);
        }
    }
    
    /**
     *
     */
    @Override
    public void update()
    {
        updateTable();
        ///increase();
        //updateHistoric();
        //getUserList();
    }
}