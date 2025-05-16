package Inventory;

public class Registry {

	private Stamps stamps;
	Label[] labels;

//	Default Constructor
	public Registry() {
		stamps = null;
		labels = new Label[0];

	}

//	Constructor with two parameters
	public Registry(Stamps stamps, Label[] Labels) {
		this.stamps = new Stamps(stamps);
		if (Labels != null) {
		this.labels = new Label[Labels.length];
		for (int i = 0; i < Labels.length; i++) {
			this.labels[i] = new Label(Labels[i]);
		}
		}
		else 
			this.labels = new Label[0];
			
	}

//	Method total $ value of stamps are equal
	public boolean equalsTotalValue(Registry other) {

		if (other == null || other.stamps == null || this.stamps == null) {
			return false;
		}
		return this.stamps.StampsTotal() == other.stamps.StampsTotal();
	}

//	Method number of stamps are equal
	public boolean equalStampCategories(Registry other) {
		return this.stamps.equals(other.stamps);
	}

//		Method total $ amount of shipment stamps
	public int getTotalStamps() {
		return stamps.StampsTotal();
	}

//		Method for number of labels in a Registry
	public int labelNumber() {
		return labels.length;
	}

//		Method to add a new Label to the Registry
	public int addLabel(Label newLabel) {
		if (newLabel == null) {
			return labels == null ? 0 : labels.length; // No label to add
		} else if (labels == null || labels.length == 0) {

			// Initialize array with one element
			labels = new Label[1];
			labels[0] = new Label(newLabel);
			return 1;
		}

		// Create a new array with one more element
		Label[] newLabels = new Label[labels.length + 1];
		for (int i = 0; i < labels.length; i++) {
			newLabels[i] = labels[i];
		}

		newLabels[labels.length] = new Label(newLabel); // Add the new label
		labels = newLabels; // Update the labels array
		return labels.length; // Return the new number of labels
	}

//		Method to remove a Label from Registry
	public boolean removeLabel(Label toRemove) {
		if (labels == null || labels.length == 0 || toRemove == null) {
			return false; // No labels to remove or invalid input
		}

		int indexToRemove = -1;

		// Find the index of the label to remove
		for (int i = 0; i < labels.length; i++) {
			if (labels[i].equals(toRemove)) {
				indexToRemove = i;
				break;
			}
		}
		if (indexToRemove == -1) {
			return false; // Label not found
		}

		// Create a new array with one less element
		Label[] newLabels = new Label[labels.length - 1];
		int j = 0;
		for (int i = 0; i < labels.length; i++) {
			if (i != indexToRemove) {
				newLabels[j] = labels[i];
				j++;
			}
		}
		labels = newLabels; // Update the labels array
		return true;
	}

//	Method to update the expiry day and month
	public boolean updateLabel(int index, int day, int month) {
		if (labels == null || index < 0 || index >= labels.length) {
			return false;
		}

		labels[index].setDay(day);
		labels[index].setMonth(month);
		return true;
	}

//	Method to update the expiry day and month
	public int changeStampsValue(int cat_A, int cat_B, int cat_C, int cat_D, int cat_E) {
		stamps.addStamps(cat_A, cat_B, cat_C, cat_D, cat_E);
		return stamps.StampsTotal();

	}

//	Method to update the expiry day and month
	public boolean equals(Registry otherRegistry) {
		if (otherRegistry == null) {
			return false;
		} else if (this.stamps.StampsTotal() != otherRegistry.stamps.StampsTotal()) {
			return false;
		}
		return this.labels.length == otherRegistry.labels.length;
	}

//	Method to update the expiry day and month
	public String toString() {
		String returnString = this.stamps.toString()+"\n";
		if (this.labels.length == 0 ) {
			return returnString + "No prepaid labels";
		}

		for (Label l : labels) {
			returnString += l.toString() + "\n";
		}

		return returnString;
	}

//	Method to update the expiry day and month
	public String stampsToString() {
		return this.stamps.toString();

	}

}

