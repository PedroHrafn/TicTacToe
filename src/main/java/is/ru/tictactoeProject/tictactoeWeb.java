package is.ru.tictactoeProject;

import static spark.Spark.*;

public class tictactoeWeb {
    public static void main(String[] args) {
        port(getHerokuPort());
        get("/", (req, res) -> {
            return "No route specified. Try /add/1,2";
        });
        get(
            "/play/:input",
            (req, res) -> play(req.params(":input"))
        );
    }

    static int getHerokuPort() {
        ProcessBuilder psb = new ProcessBuilder();
	if (psb.environment().get("PORT") != null) {
	    return Integer.parseInt(psb.environment().get("PORT"));
	}
	return 4567;
    }

    private static int play(String input) {
        tictactoe game = new tictactoe();
        return 1;
    }
}