package chessproject.viewModel;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;

public class BoardViewModel {
  private final Label[] percentageLabels = new Label[26];
  @FXML
  private final TextField[] newValueTFs = new TextField[26];
  private final String[] replacement = new String[26];
  private final String[] alphabet =
      {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r",
          "s", "t", "u", "v", "w", "x", "y", "z"};
  @FXML
  private TextArea inputTA;
  @FXML
  private TextArea outputTA;
  @FXML
  private TextField aIn, bIn, cIn, dIn, eIn, fIn, gIn, hIn, iIn, jIn, kIn, lIn, mIn, nIn, oIn, pIn,
      qIn, rIn, sIn, tIn, uIn, vIn, wIn, xIn, yIn, zIn;
  @FXML
  private Label aL, bL, cL, dL, eL, fL, gL, hL, iL, jL, kL, lL, mL, nL, oL, pL, qL, rL, sL, tL, uL,
      vL, wL, xL, yL, zL;

  @FXML
  protected void initialize() {
    newValueTFs[0] = aIn;
    newValueTFs[1] = bIn;
    newValueTFs[2] = cIn;
    newValueTFs[3] = dIn;
    newValueTFs[4] = eIn;
    newValueTFs[5] = fIn;
    newValueTFs[6] = gIn;
    newValueTFs[7] = hIn;
    newValueTFs[8] = iIn;
    newValueTFs[9] = jIn;
    newValueTFs[10] = kIn;
    newValueTFs[11] = lIn;
    newValueTFs[12] = mIn;
    newValueTFs[13] = nIn;
    newValueTFs[14] = oIn;
    newValueTFs[15] = pIn;
    newValueTFs[16] = qIn;
    newValueTFs[17] = rIn;
    newValueTFs[18] = sIn;
    newValueTFs[19] = tIn;
    newValueTFs[20] = uIn;
    newValueTFs[21] = vIn;
    newValueTFs[22] = wIn;
    newValueTFs[23] = xIn;
    newValueTFs[24] = yIn;
    newValueTFs[25] = zIn;

    percentageLabels[0] = aL;
    percentageLabels[1] = bL;
    percentageLabels[2] = cL;
    percentageLabels[3] = dL;
    percentageLabels[4] = eL;
    percentageLabels[5] = fL;
    percentageLabels[6] = gL;
    percentageLabels[7] = hL;
    percentageLabels[8] = iL;
    percentageLabels[9] = jL;
    percentageLabels[10] = kL;
    percentageLabels[11] = lL;
    percentageLabels[12] = mL;
    percentageLabels[13] = nL;
    percentageLabels[14] = oL;
    percentageLabels[15] = pL;
    percentageLabels[16] = qL;
    percentageLabels[17] = rL;
    percentageLabels[18] = sL;
    percentageLabels[19] = tL;
    percentageLabels[20] = uL;
    percentageLabels[21] = vL;
    percentageLabels[22] = wL;
    percentageLabels[23] = xL;
    percentageLabels[24] = yL;
    percentageLabels[25] = zL;

    for (TextField textField : newValueTFs) {
      int maxLength = 1;
      String pattern = ".{0," + maxLength + "}";
      TextFormatter<String> textFormatter = new TextFormatter<>(change ->
                                                                    change.getControlNewText()
                                                                        .matches(pattern) ? change :
                                                                        null);
      textField.setTextFormatter(textFormatter);
    }
    updatePercentages();
    readNewValues();
  }

  @FXML
  protected void readInputTA() {
    outputTA.setText(replaceWithNew());
    updatePercentages();
  }

  @FXML
  protected void readNewValues() {
    for (int i = 0; i < newValueTFs.length; i++) {
      replacement[i] = newValueTFs[i].getText().trim().toLowerCase();
    }
    outputTA.setText(replaceWithNew());
  }

  private String replaceWithNew() {
    String input = inputTA.getText();
    StringBuilder newText = new StringBuilder();
    for (int i = 0; i < input.length(); i++) {
      for (int j = 0; j < alphabet.length; j++) {
        if (input.substring(i, i + 1).toLowerCase().equals(alphabet[j])) {
          if (Character.isUpperCase(input.substring(i, i + 1).charAt(0))) {
            newText.append(replacement[j].toUpperCase());
          } else {
            newText.append(replacement[j]);
          }
          break;
        }
      }
      if (newText.length() == i) {
        newText.append(input.charAt(i));
      }
    }
    return newText.toString();
  }

  private void updatePercentages() {
    String input = inputTA.getText();
    int letterCount = input.replaceAll("[ ,.?!]", "").length();
    int[] count = new int[26];
    for (int i = 0; i < input.length(); i++) {
      switch (input.toLowerCase().charAt(i)) {
        case 'a' -> ++count[0];
        case 'b' -> ++count[1];
        case 'c' -> ++count[2];
        case 'd' -> ++count[3];
        case 'e' -> ++count[4];
        case 'f' -> ++count[5];
        case 'g' -> ++count[6];
        case 'h' -> ++count[7];
        case 'i' -> ++count[8];
        case 'j' -> ++count[9];
        case 'k' -> ++count[10];
        case 'l' -> ++count[11];
        case 'm' -> ++count[12];
        case 'n' -> ++count[13];
        case 'o' -> ++count[14];
        case 'p' -> ++count[15];
        case 'q' -> ++count[16];
        case 'r' -> ++count[17];
        case 's' -> ++count[18];
        case 't' -> ++count[19];
        case 'u' -> ++count[20];
        case 'v' -> ++count[21];
        case 'w' -> ++count[22];
        case 'x' -> ++count[23];
        case 'y' -> ++count[24];
        case 'z' -> ++count[25];
      }
    }
    for (int i = 0; i < alphabet.length; i++) {
      double percentage = (double) count[i] / letterCount * 100;
      String s;
      if (letterCount == 0) {
        s = String.format("%8.2f %%", 0.0f);
      } else if (percentage == 100) {
        s = String.format("%.2f %%", percentage);
      } else if (percentage >= 10.0f) {
        s = String.format("%7.2f %%", percentage);
      } else {
        s = String.format("%8.2f %%", percentage);
      }
      percentageLabels[i].setText(s);
    }
  }
}
