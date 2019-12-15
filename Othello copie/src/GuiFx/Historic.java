package GuiFx;

import Models.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;


/**
 *
 * @author leopoldmols
 */

public class Historic extends TableView<Tour> implements Observer
{
    private Model game;
    
    public Historic (Model game)
    {
        this.game = game;
        initHistoric();
    }
    
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
        
        updateHistoric();
    }
    
    private ObservableList<Tour> getUserList()
    {
        Tour tour1 = new Tour(1, "Arnaud", Action.NOUVELLE_PARTIE, 5, 3, 1);
        Tour tour2 = new Tour(2, "Jean", Action.NOUVELLE_PARTIE, 5, 3, 1);
        Tour tour3 = new Tour(3, "Auguste", Action.NOUVELLE_PARTIE, 5, 3, 1);
        
        ObservableList<Tour> list = FXCollections.observableArrayList(tour1, tour2, tour3);
        return list;
    }
    
    void updateHistoric()
    {
        // Display row data
        ObservableList<Tour> list = getUserList();
        setItems(list);
    }
    
    @Override
    public void update()
    {
        updateHistoric();
    }
}