module chessproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires transitive javafx.graphics;

    opens chessproject.viewModel to javafx.fxml;
    opens chessproject to javafx.fxml;
    exports chessproject.viewModel;
    exports chessproject;
}
