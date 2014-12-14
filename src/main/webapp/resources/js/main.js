function disableButtons() {
	updateButton.disable();
	deleteButton.disable();
}

function enableButtons() {
	updateButton.enable();
	deleteButton.enable();
}

function unselectRows() {
	disableButtons();
	dataTable.unselectAllRows();
}
