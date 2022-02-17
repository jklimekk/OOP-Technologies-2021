package command;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class CommandRegistry {

	private ObservableList<Command> commandStack = FXCollections
			.observableArrayList();

	private ObservableList<Command> commandUndoStack = FXCollections
			.observableArrayList();

	public void executeCommand(Command command) {
		command.execute();
		commandStack.add(command);
	}

	public void redo() {
		
	}

	public void undo() {
		if(! commandStack.isEmpty()) {
			Command command = commandStack.get(commandStack.size() - 1);
			command.undo();
			commandStack.remove(commandStack.size() - 1);
			commandUndoStack.add(command);
		}
		
	}

	public ObservableList<Command> getCommandStack() {
		return commandStack;
	}
}
