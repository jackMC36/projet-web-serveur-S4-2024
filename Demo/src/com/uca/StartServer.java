package src.com.uca;

import src.com.uca.dao._Initializer;
import src.com.uca.gui.*;

import static spark.Spark.*;

public class StartServer {

    public static void main(String[] args) {
        //Configure Spark
        staticFiles.location("main/static/");
        port(8081);


        _Initializer.Init();

        //Defining our routes
        get("/immeubles", (req, res) -> {
            return ImmeubleGUI.getAllImmeubles();
        });
    }
}