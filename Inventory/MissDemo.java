package Inventory;

import java.util.Scanner;

public class MissDemo {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		System.out.println("Welcome to Montreal Intercampus Shipping Service (MISS) Registry System\n");

//      Create sample Registries
//      These registries include various stamps and prepaid labels

		Registry reg1 = new Registry(new Stamps(2, 3, 1, 0, 5), new Label[] {
				new Label("Standard", 98000001, 5, 6),
				new Label("Express", 98000002, 15, 9)
		});

		Registry reg2 = new Registry(new Stamps(2, 3, 1, 0, 5), new Label[] {
				new Label("Standard", 98000003, 12, 12)
		});

		Registry reg3 = new Registry(new Stamps(1, 4, 2, 1, 3), new Label[] {
				new Label("Fragile", 98000004, 22, 8),
				new Label("Confidential", 98000005, 3, 5),
				new Label("Oversize", 98000006, 18, 11)

		});

//      Registries without prepaid labels
		Registry reg4 = new Registry(new Stamps(5, 0, 3, 2, 1), null);
		Registry reg5 = new Registry(new Stamps(5, 0, 3, 2, 1), null);
		
//      Store all registries in an array
		Registry[] registries = { reg1, reg2, reg3, reg4, reg5 };

		int choice;  // User's menu choice
		// Display menu and process user input until the user chooses to quit
		do {

			displayMenu();
			choice = input.nextInt();
			switch (choice) {
			// Display the contents of all registries
			case 1:
				System.out.println("Content of each Registry:");
				System.out.println("------------------------");
				for (int i = 0; i < registries.length; i++) {
					System.out.println("Registry " + (i + 1) + ":\n" + registries[i].toString() + "\n");
				}
				break;
				
            // Allow user to view the content of a specific registry
			case 2:
				int regNum;
				do {
					System.out.print("Enter the registry number to see its content (Enter number 1 to 5): ");
					regNum = input.nextInt();
					if (regNum < 1 || regNum > registries.length) {
						System.out.println("Sorry but there is no registry number " + regNum);
						System.out.println("--> Try again: (Enter number 1 to 5)");
					}
				} while (regNum < 1 || regNum > registries.length); // Loop until a valid number is provided

				// If a valid number is entered, display the registry content
				System.out.println(registries[regNum - 1].toString());
				break;
				
            // Compare registries by the total value of their stamps
			case 3:
				compareRegistriesByTotalValue(registries);
				break;

            // Compare registries by stamp distribution
			case 4:
				compareRegistriesByStampDistribution(registries);
				break;
				
	        // Compare registries that are considered equal based on predefined criteria
			case 5:
				compareEqualRegistries(registries);
				break;

		    // Add a prepaid label to a specific registry
			case 6:
				System.out.print("Enter the registry number to add a label to (Enter number 1 to 5): ");
			    regNum = input.nextInt();
			    if (regNum >= 1 && regNum <= registries.length) {
			        System.out.print("Enter label type (Standard, Small, Oversize, Express, Fragile, Confidential): ");
			        String type = input.next();
			        System.out.print("Enter ID of prepaid label possessor: ");
			        int iD = input.nextInt();
			        System.out.print("Enter label day: ");
			        int day = input.nextInt();
			        System.out.print("Enter label month: ");
			        int month = input.nextInt();

			        // Create and add the new label
			        Label newLabel = new Label(type, iD, day, month);
			        int updatedLabelCount = registries[regNum - 1].addLabel(newLabel);

			        // Display the updated number of labels
			        System.out.println("Label added successfully.");
			        System.out.println("Total number of labels in Registry " + regNum + " are : " + updatedLabelCount);
			    } else {
			        System.out.println("Invalid registry number.");
			    }
			    break;

			// Remove a prepaid label from a specific registry
			case 7:
				System.out.print("Enter the registry number to remove a label from (Enter number 1 to 5): ");
				regNum = input.nextInt();

				if (regNum >= 1 && regNum <= registries.length) {
				    if (registries[regNum - 1].labels == null || registries[regNum - 1].labels.length == 0) {
				        System.out.println("This registry has no labels to remove.");
				    } else {
				        System.out.print("Enter the label index to remove: ");
				        int labelIndex = input.nextInt();

				        if (labelIndex >= 0 && labelIndex < registries[regNum - 1].labelNumber()) {
				            registries[regNum - 1].removeLabel(registries[regNum - 1].labels[labelIndex]);
				            System.out.println("Label removed successfully.");
				        } else {
				            System.out.println("Invalid label index.");
				        }
				    }
				} else {
				    System.out.println("Invalid registry number.");
				}

				break;

            // Update the expiry date of a specific prepaid label
			case 8:
				System.out.print("Enter the registry number to update a label (Enter number 1 to 5):");
				regNum = input.nextInt();
				if (regNum >= 1 && regNum <= registries.length) {
					System.out.print("Enter the label index to update: ");
					int labelIndex = input.nextInt();
					System.out.print("Enter new expiry day: ");
					int expDay = input.nextInt();
					System.out.print("Enter new expiry month: ");
					int expMonth = input.nextInt();
					registries[regNum - 1].updateLabel(labelIndex, expDay, expMonth);
					
			            System.out.println("Expiry date updated");
				} else {
					System.out.println("Invalid registry number.");
				}
				break;

            // Add shipment stamps to a specific registry
			case 9:
				System.out.print("Enter the registry number to add stamps to: ");
			    regNum = input.nextInt();
			    if (regNum >= 1 && regNum <= registries.length) {
			        System.out.print("Enter number of category A stamps to add: ");
			        int catA = input.nextInt();
			        System.out.print("Enter number of category B stamps to add: ");
			        int catB = input.nextInt();
			        System.out.print("Enter number of category C stamps to add: ");
			        int catC = input.nextInt();
			        System.out.print("Enter number of category D stamps to add: ");
			        int catD = input.nextInt();
			        System.out.print("Enter number of category E stamps to add: ");
			        int catE = input.nextInt();

			        // Update stamps and get the total value
			        int updatedTotalValue = registries[regNum - 1].changeStampsValue(catA, catB, catC, catD, catE);

			        // Display the updated total value of stamps
			        System.out.println("Stamps added successfully.");
			        System.out.println("Total value of stamps in Registry " + regNum + ": $" + updatedTotalValue);
			    } else {
			        System.out.println("Invalid registry number.");
			    }
			    break;

			// Exit the program
			case 0:
				System.out.println("Thank you for using the MISS Registry System. Goodbye!");
				break;

			// Handle invalid menu choices
			default:
				System.out.println("Invalid choice. Please try again.");
				break;
			}

		} while (choice != 0);

		input.close();

	}

	// Display the menu options for the user
	public static void displayMenu() {

		System.out.println("\nWhat would you like to do?");
		System.out.println("1. See the content of all Registries");
		System.out.println("2. See the content of one Registry");
		System.out.println("3. List Registries with same $ amount of shipment stamps");
		System.out.println("4. List Registries with same number of shipment Stamps types");
		System.out.println("5. List Registries with same $ amount of Stamps and same number of prepaid Labels");
		System.out.println("6. Add a prepaid label to an existing Registry");
		System.out.println("7. Remove an existing prepaid label from a Registry");
		System.out.println("8. Update the expiry date of an existing prepaid Label");
		System.out.println("9. Add Stamps to a Registry");
		System.out.println("0. To quit");
		System.out.print("\nPlease enter your choice and press <Enter>: ");
	}

    // Compare registries by total stamp value and print matches
	public static void compareRegistriesByTotalValue(Registry[] registries) {
		System.out.println("");
		for (int i = 0; i < registries.length; i++) {
			for (int j = i + 1; j < registries.length; j++) {
				if (registries[i].equalsTotalValue(registries[j])) {
					System.out.println("Registries " + (i + 1) + " and " + (j + 1) + " have the same total value: "
							+ registries[i].getTotalStamps() + "$");
				}
			}
		}
	}

    // Compare registries by stamp distribution and print matches
	public static void compareRegistriesByStampDistribution(Registry[] registries) {
		System.out.println("");
		for (int i = 0; i < registries.length; i++) {
			for (int j = i + 1; j < registries.length; j++) {
				if (registries[i].equalStampCategories(registries[j])) {
					System.out.println(
							"Registries " + (i + 1) + " and " + (j + 1) + " have the same stamp distribution");
				}
			}
		}
	}
	
    // Compare registries for equality based on custom criteria and print matches
	public static void compareEqualRegistries(Registry[] registries) {
		System.out.println("");
		for (int i = 0; i < registries.length; i++) {
			for (int j = i + 1; j < registries.length; j++) {
				if (registries[i].equals(registries[j])) {
					System.out.println("Registries " + (i + 1) + " and " + (j + 1) + " are equal");
				}
			}
		}
	}
}