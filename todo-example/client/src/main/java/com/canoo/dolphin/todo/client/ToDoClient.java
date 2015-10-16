package com.canoo.dolphin.todo.client;

import com.canoo.dolphin.client.javafx.JavaFXConfiguration;
import com.canoo.dolphin.client.ClientContext;
import com.canoo.dolphin.client.ClientContextFactory;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.concurrent.CompletableFuture;

public class ToDoClient extends Application {

    private ClientContext clientContext;

    private ToDoViewBinder viewController;

    @Override
    public void start(Stage primaryStage) throws Exception {
        CompletableFuture<ClientContext> connectionPromise = ClientContextFactory.connect(new JavaFXConfiguration("http://localhost:8080/todo-app/dolphin"));
        connectionPromise.thenAccept(context -> {
            clientContext = clientContext;
            viewController = new ToDoViewBinder(context);
            primaryStage.setScene(new Scene(viewController.getRoot()));
            primaryStage.show();
        });
    }

    @Override
    public void stop() throws Exception {
        super.stop();
        if(viewController != null) {
            viewController.destroy().get();
        }
        if(clientContext != null) {
            clientContext.disconnect().get();
        }
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
