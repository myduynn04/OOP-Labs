package hust.soict.ict.aims;

import hust.soict.ict.aims.cart.Cart;
import hust.soict.ict.aims.screen.customer.controller.ViewStoreController;
import hust.soict.ict.aims.store.Store;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Aims extends Application {
    private static Store store;
    private static Cart cart;

    @Override
    public void start(Stage primaryStage) throws Exception {
        store = new Store();
        cart = new Cart();

        store.initData(); // Initialize data in the store

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/hust/soict/ict/aims/screen/customer/view/Store.fxml"));

        loader.setController(new ViewStoreController(store, cart));

        Parent root = loader.load();

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("AIMS Store");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
