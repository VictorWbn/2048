/**
 * Ce logiciel est distribué à des fins éducatives.
 *
 * Il est fourni "tel quel", sans garantie d’aucune sorte, explicite
 * ou implicite, notamment sans garantie de qualité marchande, d’adéquation
 * à un usage particulier et d’absence de contrefaçon.
 * En aucun cas, les auteurs ou titulaires du droit d’auteur ne seront
 * responsables de tout dommage, réclamation ou autre responsabilité, que ce
 * soit dans le cadre d’un contrat, d’un délit ou autre, en provenance de,
 * consécutif à ou en relation avec le logiciel ou son utilisation, ou avec
 * d’autres éléments du logiciel.
 *
 * (c) 2022-2023 Romain Wallon - Université d'Artois.
 * Tous droits réservés.
 */

package fr.univartois.butinfo.ihm;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {

    /**
     * Cette méthode permet d'initialiser l'affichage de la fenêtre de l'application.
     *
     * @param stage La fenêtre (initialement vide) de l'application.
     */
    @Override
    public void start(Stage stage) throws IOException {
        // Il faut d'abord récupérer la description de la vue (au format FXML).
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
        Parent viewContent = fxmlLoader.load();
		Scene scene = new Scene(viewContent, 400, 500);
        stage.setScene(scene);
        stage.setTitle("2048");
        stage.show();
    }

    /**
     * Cette méthode exécute l'application JavaFX.
     * Pour le cours d'IHM, la méthode {@code main} d'une application JavaFX sera
     * toujours la même : un simple appel à la méthode {@link #launch(String...)}
     * définie dans la classe {@link Application}.
     *
     * @param args Les arguments de la ligne de commande (dont on ne tient pas compte).
     *
     * @see #launch(String...)
     */
    public static void main(String[] args) {
        launch();
    }

}
