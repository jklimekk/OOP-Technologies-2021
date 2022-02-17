package presenter;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.converter.LocalDateStringConverter;
import model.Category;
import model.Transaction;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.time.format.DateTimeFormatter;

public class TransactionEditDialogPresenter {

	private Transaction transaction;

	@FXML
	private TextField dateTextField;

	@FXML
	private TextField payeeTextField;

	@FXML
	private TextField categoryTextField;

	@FXML
	private TextField inflowTextField;
	
	private Stage dialogStage;
	
	private boolean approved;
	
	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}
	
	public void setData(Transaction transaction) {
		this.transaction = transaction;
		updateControls();
	}
	
	public boolean isApproved() {
		return approved;
	}
	
	@FXML
	private void handleOkAction(ActionEvent event) {
		// TODO: implement
		updateModel();
		isApproved();
		dialogStage.close();
	}
	
	@FXML
	private void handleCancelAction(ActionEvent event) {
		// TODO: implement
		dialogStage.close();
	}
	
	private void updateModel() {
		// TODO: implement

		String pattern = "yyyy-MM-dd";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
		LocalDateStringConverter converter = new LocalDateStringConverter(formatter, formatter);

		DecimalFormat decimalFormatter = new DecimalFormat();
		decimalFormatter.setParseBigDecimal(true);

		transaction.setDate(converter.fromString(dateTextField.getText()));
		transaction.setCategory(new Category(categoryTextField.getText()));

		try {
			transaction.setInflow((BigDecimal) decimalFormatter.parse(inflowTextField.getText()));
		} catch (ParseException e) {
			e.printStackTrace();
		}

		transaction.setPayee(payeeTextField.getText());


	}
	
	private void updateControls() {
		// TODO: implement

		String pattern = "yyyy-MM-dd";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
		LocalDateStringConverter converter = new LocalDateStringConverter(formatter, formatter);

		dateTextField.textProperty().setValue(converter.toString(transaction.getDate()));
		payeeTextField.textProperty().setValue(transaction.getPayee());
		categoryTextField.textProperty().setValue(transaction.getCategory().getName());
		inflowTextField.textProperty().setValue(transaction.getInflow().toString());

	}
}
