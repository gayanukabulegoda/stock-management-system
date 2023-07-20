import java.util.Scanner;
class User{
	public static String username = "admin";
	public static String password = "1234";
}
class Supplier{
	String id;
	String name;
}
class Category{
	String name;
}
class Item{
	String supplierId;
	String itemCode;
	String desc;
	String unitPrice;
	String qtyOnHand;
	String category;
}
class StockManagementOOP {
	public static Scanner input = new Scanner(System.in);
	public static Supplier[] supplier = new Supplier[0];
	public static Category[] category = new Category[0];
	public static Item[] items = new Item[0];
	
	private final static void clearConsole() {
		final String os = System.getProperty("os.name");
		try {
			if (os.equals("Linux")) {
				System.out.print("\033\143");
			} else if (os.equals("Windows")) {
				new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			} else {
				System.out.print("\033[H\033[2J");
				System.out.flush();
			}
		} catch (final Exception e) {
			//handle the exception
			System.err.println(e.getMessage());
		}
	}
	public static void loginPage() {
		System.out.println("+-------------------------------------------------------------------+");
		System.out.printf("%-29s%-39s%s","|","LOGIN PAGE","|\n");
		System.out.println("+-------------------------------------------------------------------+\n");
		while(true){
			System.out.print("User Name : ");
			String userName = input.next();

	  L51:  while(User.username .equals(userName)){
				System.out.print("\nPassword  : ");
				String pw = input.next();
		
				if(User.password .equals(pw)) {
					clearConsole();
					homePage();
				}
				else System.out.println("password is incorrect. please try again!");
				continue L51;
			}
			System.out.println("user name is invalid. please try again!\n");
		}
	}
	public static void homePage() {
		byte[] home = {1, 2, 3, 4, 5};
		System.out.println("+-------------------------------------------------------------------+");
		System.out.printf("%-15s%-53s%s","|","WELCOME TO IJSE STOCK MANAGEMENT SYSTEM","|\n");
		System.out.println("+-------------------------------------------------------------------+\n");
		System.out.printf("%-42s%s","[1] Change the Credentials","[2] Supplier Manage\n");
		System.out.printf("%-42s%s","[3] Stock Manage","[4] Log out\n");
		System.out.println("[5] Exit the system");
		while(true){
			System.out.print("\nEnter an option to continue >  ");
			String option = input.next();
			if (option.equals(Byte.toString(home[0]))){	 //Here i've converted the byte values to Strings in-order to comprare
				clearConsole();							//So, here we're able to input any number,Symbol.. no run-time error occurs.
				changeCredientials();				   //And the loop contines until we input a valid option
			}
			if (option.equals(Byte.toString(home[1]))){
				clearConsole();
				supplierManage();
			}
			if (option.equals(Byte.toString(home[2]))){
				clearConsole();
				stockManage();
			}
			if (option.equals(Byte.toString(home[3]))){
				clearConsole();
				logOut();
			}
			if (option.equals(Byte.toString(home[4]))){
				clearConsole();
				exitSystem();
			}
			else {
				System.out.println("\nEnter a Valid option to continue!");
			}
		}
	}
	public static void changeCredientials() {
		System.out.println("+-------------------------------------------------------------------+");
		System.out.printf("%-26s%-42s%s","|","CREDENTIAL MANAGE","|\n");
		System.out.println("+-------------------------------------------------------------------+");
		while (true) {
			System.out.print("\nPlease enter the user name to verify it's you:  ");
			String userName = input.next();
			
			if (User.username .equals(userName)) {
				System.out.println("Hey "+ User.username);
				String pawrd = "";
				while (true) {
					System.out.print("Enter your current password  : ");
					String pw = input.next();
					pawrd = pw;
					if(User.password .equals(pw)) {
						break;
					}
					else System.out.println("incorrect password. try again!\n");
				}
				if (User.password .equals(pawrd)){
					System.out.print("Enter your new password: ");
					User.password = input.next();
					System.out.print("\nPassword changed successfully! ");
					System.out.print("Do you want to go home page (Y/N): ");
					char option = input.next().charAt(0);
					if(option == 'Y' || option == 'y') {
						clearConsole();
						homePage();
					}
					else {
						clearConsole();
						logOut();
					}
				}
			}
			else System.out.println("invalid user name. try again!");
		}
	}
	public static void logOut() {
		loginPage();
	}
	public static void exitSystem() {
		System.out.println("\n--------------------------------");
		System.out.printf("%27s%n","👋👋...Thank you...👋👋");
		System.out.println("--------------------------------");
		System.exit(0);
	}
	public static void supplierManage() {
		byte[] optionArray = {1, 2, 3, 4, 5, 6};
		System.out.println("+-------------------------------------------------------------------+");
		System.out.printf("%-26s%-42s%s","|","SUPPLIER MANAGE","|\n");
		System.out.println("+-------------------------------------------------------------------+\n");
		System.out.printf("%-42s%s","[1] Add Supplier","[2] Upadate Supplier\n");
		System.out.printf("%-42s%s","[3] Delete Supplier","[4] View Suppliers\n");
		System.out.printf("%-42s%s","[5] Search Supplier","[6] Home Page\n");
		while(true){
			System.out.print("\nEnter an option to continue >  ");
			String option = input.next();
			if (option.equals(Byte.toString(optionArray[0]))){
				clearConsole();
				addSupplier();
			}
			if (option.equals(Byte.toString(optionArray[1]))){
				clearConsole();
				updateSupplier();
			}
			if (option.equals(Byte.toString(optionArray[2]))){
				clearConsole();
				deleteSupplier();
			}
			if (option.equals(Byte.toString(optionArray[3]))){
				clearConsole();
				viewSuppliers();
			}
			if (option.equals(Byte.toString(optionArray[4]))){
				clearConsole();
				searchSupplier();
			}
			if (option.equals(Byte.toString(optionArray[5]))){
				clearConsole();
				homePage();
			}
			else{
				System.out.println("\nEnter a Valid option to continue!");
			}
		}
	}
	public static void addSupplier() {
		System.out.println("+-------------------------------------------------------------------+");
		System.out.printf("%-28s%-40s%s","|","ADD SUPPLIER","|\n");
		System.out.println("+-------------------------------------------------------------------+");
		supplier = growSupplier();
		//Supplier[] supplier = new Supplier[0];
  L195: while (true) {
			System.out.print("\nSupplier ID    : ");
			String iD = input.next();
			
			for (int i = 0; i < supplier.length; i++) {
				if (supplier[i] != null && iD.equals(supplier[i].id)) {
					System.out.println("already exists. try another supplier id!");
					continue L195;
				}
			}
			supplier[supplier.length-1] = new Supplier();
			supplier[supplier.length-1].id = iD;
			
			System.out.print("Supplier Name  : ");
			supplier[supplier.length-1].name = input.next();
			
			System.out.print("added Successfully! Do you want to add another supplier(Y/N)? ");
			char add = input.next().charAt(0);
			if (add == 'Y' || add == 'y') {
				clearConsole();
				addSupplier();
			}
			if (add == 'N' || add == 'n') {
				clearConsole();
				supplierManage();
			}
			else {
				clearConsole();
				logOut();
			}
		}
	}
	public static Supplier[] growSupplier() {
		Supplier[] temp = new Supplier[supplier.length + 1];
		for (int i = 0; i < supplier.length; i++){
				temp[i] = supplier[i];
			}
			return temp;
	}
	public static void updateSupplier() {
		System.out.println("+-------------------------------------------------------------------+");
		System.out.printf("%-27s%-41s%s","|","UPDATE SUPPLIER","|\n");
		System.out.println("+-------------------------------------------------------------------+");
		//In-order to avoid recurring can't find s.out if we cick updateSupplier without adding Suppliers
		if (supplier.length == 0 || null == supplier[0]) {
			System.out.println("\nOOPS! It seems that you don't have any Suppliers in the system.");
			System.out.print("Do you want to add a new Supplier?(Y/N) ");
			char yesOrNo = input.next().charAt(0);
			if (yesOrNo == 'Y' || yesOrNo == 'y') {
				clearConsole();
				addSupplier(); 
			}
			else {
				clearConsole();
				homePage();
			}
		}
  L252: while (true) {
			System.out.print("\nSupplier ID    : ");
			String iD = input.next();
			boolean flag = true;
			int ids = 0;
			for (int i = 0; i < supplier.length; i++) {
				if (iD.equals(supplier[i].id)) {
					ids = i;
					flag = false;
					break;
				}
			}
			if (flag){
				System.out.println("can't find supplier id. try again!");
				continue L252;
			}
			System.out.println("\nSupplier ID    : "+supplier[ids].id);
			System.out.println("Supplier Name  : "+supplier[ids].name +"\n");
			System.out.print("Enter the new supplier name : ");
			supplier[ids].name = input.next();
			System.out.print("Updated Successfully! Do you want to update another supplier(Y/N)? ");
			char add = input.next().charAt(0);
			if (add == 'Y' || add == 'y') {
				clearConsole();
				updateSupplier();
			}
			if (add == 'N' || add == 'n') {
				clearConsole();
				supplierManage();
			}
			else {
				clearConsole();
				logOut();
			}
		}
	}
	public static void deleteSupplier() {
		System.out.println("+-------------------------------------------------------------------+");
		System.out.printf("%-27s%-41s%s","|","DELETE SUPPLIER","|\n");
		System.out.println("+-------------------------------------------------------------------+");
		//In-order to avoid recurring can't find s.out if we cick deleteSupplier without adding Suppliers
		if (supplier.length == 0 || null == supplier[0]) {
			System.out.println("\nOOPS! It seems that you don't have any Suppliers in the system.");
			System.out.print("Do you want to add a new Supplier?(Y/N) ");
			char yesOrNo = input.next().charAt(0);
			if (yesOrNo == 'Y' || yesOrNo == 'y') {
				clearConsole();
				addSupplier();  
			}
			else {
				clearConsole();
				homePage();
			}
		}
  L306: while (true) {
			System.out.print("\nSupplier ID    : ");
			String id = input.next();
			boolean flag = true;
			int ids = 0;
			for (int i = 0; i < supplier.length; i++) {
				if (id.equals(supplier[i].id)) {
					ids = i;
					flag = false;
					break;
				}
			}
			if (flag){
				System.out.print("can't find supplier id. try again!\n");
				continue L306;
			}
			//In-order to avoid deleting the Supplier if items already available under the Supplier
			for (int i = 0; i < items.length; i++) {
				if (supplier[ids].id.equals(items[i].supplierId)) {
					System.out.println("\nSystem unable to delete this Supplier!");
					System.out.println("Item/Items already available under "+supplier[ids].id+"!");
					System.out.print("\nDo you want to delete another supplier?(Y/N) ");
					char delete = input.next().charAt(0);
					if (delete == 'Y' || delete == 'y') {
						clearConsole();
						deleteSupplier();
					}
					else {
						clearConsole();
						supplierManage();
					}
				}
			}
			supplier = removeSupplier(ids);
			
			System.out.print("deleted successfully! Do you want to delete another?(Y/N) ");
			char add = input.next().charAt(0);
			if (add == 'Y' || add == 'y') {
				clearConsole();
				deleteSupplier();
			}
			if (add == 'N' || add == 'n') {
				clearConsole();
				supplierManage();
			}
			else {
				clearConsole();
				logOut();
			}
		}
	}
	public static Supplier[] removeSupplier(int ids) {
		Supplier[] temp = new Supplier[supplier.length - 1];
		for (int i = 0,k = 0; i < supplier.length; i++) {
			if (i == ids){
				continue;
			}
			temp[k] = supplier[i];
			k++;
 		}
 		return temp;
	}
	public static void viewSuppliers() {
		System.out.println("+-------------------------------------------------------------------+");
		System.out.printf("%-27s%-41s%s","|","VIEW SUPPLIERS","|\n");
		System.out.println("+-------------------------------------------------------------------+");
		
		System.out.println("\n+-------------------+-------------------+");
		System.out.printf("%-5s%-15s%-5s%-15s%s","|","SUPPLIER ID","|","SUPPLIER NAME","|\n");
		System.out.println("+-------------------+-------------------+");
		for (int i = 0; i < supplier.length; i++) {
			System.out.printf("%-7s%-13s%-7s%-13s%s%n","|",supplier[i].id,"|",supplier[i].name,"|");
 		}
 		System.out.println("+-------------------+-------------------+");
 		System.out.print("Do you want to go supplier manage page(Y/N)? ");
 		char add = input.next().charAt(0);
		if (add == 'Y' || add == 'y') {
			clearConsole();
			supplierManage();
		}
		if (add == 'N' || add == 'n') {
			clearConsole();
			homePage();
		}
		else {
			clearConsole();
			logOut();
		}
	}
	public static void searchSupplier() {
		System.out.println("+-------------------------------------------------------------------+");
		System.out.printf("%-27s%-41s%s","|","SEARCH SUPPLIER","|\n");
		System.out.println("+-------------------------------------------------------------------+");
		//In-order to avoid recurring can't find s.out if we cick searchSupplier without adding Suppliers
		if (supplier.length == 0 || null == supplier[0]) {
			System.out.println("\nOOPS! It seems that you don't have any Suppliers in the system.");
			System.out.print("Do you want to add a new Supplier?(Y/N) ");
			char yesOrNo = input.next().charAt(0);
			if (yesOrNo == 'Y' || yesOrNo == 'y') {
				clearConsole();
				addSupplier(); 
			}
			else {
				clearConsole();
				homePage();
			}
		}
  L413: while (true) {
			System.out.print("\nSupplier ID   : ");
			String id = input.next();
			boolean flag = true;
			int ids = 0;
			for (int i = 0; i < supplier.length; i++) {
				if (id.equals(supplier[i].id)) {
					ids = i;
					flag = false;
					break;
				}
			}
			if (flag){
				System.out.print("can't find supplier id. try again!\n");
				continue L413;
			}
			System.out.println("Supplier Name : "+supplier[ids].name);
			System.out.print("searched successfully! Do you want to search another supplier? (Y/N) ");
			char add = input.next().charAt(0);
			if (add == 'Y' || add == 'y') {
				clearConsole();
				searchSupplier();
			}
			if (add == 'N' || add == 'n') {
				clearConsole();
				supplierManage();
			}
			else {
				clearConsole();
				logOut();
			}
		}
	}
	public static void stockManage() {
		byte[] optionArray = {1, 2, 3, 4, 5, 6};
		System.out.println("+-------------------------------------------------------------------+");
		System.out.printf("%-27s%-41s%s","|","STOCK MANAGEMENT","|\n");
		System.out.println("+-------------------------------------------------------------------+\n");
		System.out.printf("%-42s%s","[1] Manage Item Categories","[2] Add Item\n");
		System.out.printf("%-42s%s","[3] Get Items Supplier Wise","[4] View Items\n");
		System.out.printf("%-42s%s","[5] Rank Items Per Unit Price","[6] Home Page\n");
		while(true){
			System.out.print("\nEnter an option to continue >  ");
			String option = input.next();
			if (option.equals(Byte.toString(optionArray[0]))){
				clearConsole();
				manageItemCategories();
			}
			if (option.equals(Byte.toString(optionArray[1]))){
				clearConsole();
				addItem();
			}
			if (option.equals(Byte.toString(optionArray[2]))){
				clearConsole();
				getItemsSupplierWise();
			}
			if (option.equals(Byte.toString(optionArray[3]))){
				clearConsole();
				viewItems();
			}
			if (option.equals(Byte.toString(optionArray[4]))){
				clearConsole();
				rankItemsPerUnitPrice();
			}
			if (option.equals(Byte.toString(optionArray[5]))){
				clearConsole();
				homePage();
			}
			else{
				System.out.println("\nEnter a Valid option to continue!");
			}
		}
	}
	public static void manageItemCategories() {
		byte[] optionArray = {1, 2, 3, 4};
		System.out.println("+-------------------------------------------------------------------+");
		System.out.printf("%-25s%-43s%s","|","MANAGE ITEM CATEGORY","|\n");
		System.out.println("+-------------------------------------------------------------------+\n");
		System.out.printf("%-42s%s","[1] Add New Item Category","[2] Delete Item Category\n");
		System.out.printf("%-42s%s","[3] Update Item Category","[4] Stock Management\n");
		while(true){
			System.out.print("\nEnter an option to continue >  ");
			String option = input.next();
			if (option.equals(Byte.toString(optionArray[0]))){
				clearConsole();
				addNewItemCategory();
			}
			if (option.equals(Byte.toString(optionArray[1]))){
				clearConsole();
				deleteItemCategory();
			}
			if (option.equals(Byte.toString(optionArray[2]))){
				clearConsole();
				updateItemCategory();
			}
			if (option.equals(Byte.toString(optionArray[3]))){
				clearConsole();
				stockManage();
			}
			else{
				System.out.println("\nEnter a Valid option to continue!");
			}
		}
	}
	public static void addNewItemCategory() {
		System.out.println("+-------------------------------------------------------------------+");
		System.out.printf("%-26s%-42s%s","|","ADD ITEM CATEGORY","|\n");
		System.out.println("+-------------------------------------------------------------------+");
		category = growCategory();
		//Category[] category = new Category[0];
  L523: while (true) {
			System.out.print("\nEnter the new item Category: ");
			String ctgry = input.next();
			for (int i = 0; i < category.length; i++) {
				if (category[i] != null && ctgry.equals(category[i].name)) {
					System.out.println("already exists. try another category!");
					continue L523;
				}
			}
			category[category.length-1] = new Category();
			category[category.length-1].name = ctgry;
			System.out.print("added Successfully! Do you want to add another category(Y/N)? ");
			char add = input.next().charAt(0);
			if (add == 'Y' || add == 'y') {
				clearConsole();
				addNewItemCategory();
			}
			if (add == 'N' || add == 'n') {
				clearConsole();
				stockManage();
			}
			else {
				clearConsole();
				logOut();
			}
		}
	}
	public static Category[] growCategory() {
		Category[] temp = new Category[category.length + 1];
		for (int i = 0; i < category.length; i++){
			temp[i] = category[i];
		}
		return temp;
	}
	public static void deleteItemCategory() {
		System.out.println("+-------------------------------------------------------------------+");
		System.out.printf("%-25s%-43s%s","|","DELETE ITEM CATEGORY","|\n");
		System.out.println("+-------------------------------------------------------------------+");
		//In-order to avoid recurring can't find s.out if we cick deleteCategory without adding ItemCategories
		if (category.length == 0 || null == category[0]) {
			System.out.println("\nOOPS! It seems that you don't have any item categories in the system.");
			System.out.print("Do you want to add a new item category?(Y/N) ");
			char yesOrNo = input.next().charAt(0);
			if (yesOrNo == 'Y' || yesOrNo == 'y') {
				clearConsole();
				addNewItemCategory();  
			}
			else {
				clearConsole();
				stockManage();
			}
		}
  L575: while (true) {
			System.out.print("\nEnter the item Category: ");
			String ctgry = input.next();
			boolean flag = true;
			int ids = 0;
			for (int i = 0; i < category.length; i++) {
				if (ctgry.equals(category[i].name)) {
					ids = i;
					flag = false;
					break;
				}
			}
			if (flag){
				System.out.print("can't find item Category. try again!\n");
				continue L575;
			}
			//In-order to avoid deleting the Category if items already available under the Category
			for (int i = 0; i < items.length; i++) {
				if (category[ids].name.equals(items[i].category)) {
					System.out.println("\nSystem unable to delete this category!");
					System.out.println("Item/Items already available under "+category[ids].name +"!");
					System.out.print("\nDo you want to delete another category?(Y/N) ");
					char delete = input.next().charAt(0);
					if (delete == 'Y' || delete == 'y') {
						clearConsole();
						deleteItemCategory();
					}
					else {
						clearConsole();
						manageItemCategories();
					}
				}
			}
			category = removeCategory(ids);
			System.out.print("deleted successfully! Do you want to delete another?(Y/N) ");
			char add = input.next().charAt(0);
			if (add == 'Y' || add == 'y') {
				clearConsole();
				deleteItemCategory();
			}
			if (add == 'N' || add == 'n') {
				clearConsole();
				manageItemCategories();
			}
			else {
				clearConsole();
				logOut();
			}
		}
	}
	public static Category[] removeCategory(int ids) {
		Category[] temp = new Category[category.length - 1];
		for (int i = 0,j = 0; i < category.length; i++) {
			if (i == ids){
				continue;
			}
			temp[j]= category[i];
			j++;
		}
 		return temp;
	}
	public static void updateItemCategory() {
		System.out.println("+-------------------------------------------------------------------+");
		System.out.printf("%-24s%-44s%s","|"," UPDATE ITEM CATEGORY","|\n");
		System.out.println("+-------------------------------------------------------------------+");
		//In-order to avoid recurring can't find s.out if we cick deleteCategory without adding ItemCategories
		if (category.length == 0 || null == category[0]) {
			System.out.println("\nOOPS! It seems that you don't have any item categories in the system.");
			System.out.print("Do you want to add a new item category?(Y/N) ");
			char yesOrNo = input.next().charAt(0);
			if (yesOrNo == 'Y' || yesOrNo == 'y') {
				clearConsole();
				addNewItemCategory();  
			}
			else {
				clearConsole();
				stockManage();
			}
		}
  L654: while (true) {
			System.out.print("\nEnter the item Category: ");
			String ctgry = input.next();
			boolean flag = true;
			int ids = 0;
			for (int i = 0; i < category.length; i++) {
				if (ctgry.equals(category[i].name)) {
					ids = i;
					flag = false;
					break;
				}
			}
			if (flag){
				System.out.print("can't find item Category. try again!\n");
				continue L654;
			}
			System.out.print("Enter the new Category name : ");
			category[ids].name = input.next();
			System.out.print("Updated Successfully! Do you want to update another Category (Y/N)? ");
			char add = input.next().charAt(0);
			if (add == 'Y' || add == 'y') {
				clearConsole();
				updateItemCategory();
			}
			if (add == 'N' || add == 'n') {
				clearConsole();
				manageItemCategories();
			}
			else {
				clearConsole();
				logOut();
			}
		}
	}
	public static void addItem() {
		System.out.println("+-------------------------------------------------------------------+");
		System.out.printf("%-30s%-38s%s","|","ADD ITEM","|\n");
		System.out.println("+-------------------------------------------------------------------+");
		
		if (category.length == 0 || null == category[0]){
			System.out.println("\nOOPS! It seems that you don't have any item categories in the system.");
			System.out.print("Do you want to add a new item category?(Y/N) ");
			char addNewC = input.next().charAt(0);
			if (addNewC == 'Y' || addNewC == 'y') {
				clearConsole();
				addNewItemCategory();
			}
			if (addNewC == 'N' || addNewC == 'n') {
				clearConsole();
				stockManage();
			}
			else {
				clearConsole();
				logOut();
			}
		}
		if (supplier.length == 0 || null == supplier[0]){
			System.out.println("\nOOPS! It seems that you don't have any suppliers in the system.");
			System.out.print("Do you want to add a new supplier?(Y/N) ");
			char addNewS = input.next().charAt(0);
			if (addNewS == 'Y' || addNewS == 'y') {
				clearConsole();
				addSupplier();         
			}
			if (addNewS == 'N' || addNewS == 'n') {
				clearConsole();
				stockManage();
			}
			else {
				clearConsole();
				logOut();
			}
		}
		items = growItems();
		items[items.length-1] = new Item();
  L729: while(true) {
			System.out.print("\nItem Code  : ");
			String itemInput = input.next();
			for (int i = 0; i < items.length; i++) {
				if (items[i] != null && itemInput.equals(items[i].itemCode)) {
					System.out.println("already exists. try another Item Code!");
					continue L729;
				}
			}
			items[items.length-1].itemCode = itemInput;
			break L729;
		}	
		System.out.println("\nSuppliers list:");
		System.out.println("+-------------+-------------------+-------------------+");
		System.out.printf("%-7s%-7s%-5s%-15s%-4s%-16s%s","|","#","|","SUPPLIER ID","|","SUPPLIER NAME","|\n");
		System.out.println("+-------------+-------------------+-------------------+");
		for (int i = 0; i < supplier.length; i++) {
			System.out.printf("%-7s%-7d%-8s%-12s%-8s%-12s%s%n","|",(i+1),"|",supplier[i].id,"|",supplier[i].name,"|");
		}
		System.out.println("+-------------+-------------------+-------------------+");
  L749: while (true) {
			System.out.print("\nEnter the supplier number > ");
			int num = input.nextInt();
			boolean number = true;
			for (int i = 0; i < supplier.length; i++) {
				if ((num - 1) == i) {
					items[items.length-1].supplierId = supplier[i].id;
					number = false;
					break L749;
				}
			}
			if (number) {
				System.out.println("Inavid number. Try again!");
				continue L749;
			}
		}
		System.out.println("\nItem Categories:");
		System.out.println("+-----------+--------------------------+");
		System.out.printf("%-6s%-6s%-7s%-20s%s","|","#","|","CATEGORY NAME","|\n");
		System.out.println("+-----------+--------------------------+");
		for (int i = 0; i < category.length; i++){
			System.out.printf("%-6s%-6d%-9s%-18s%s","|",(i+1),"|",category[i].name,"|");
			System.out.println();
		}
		System.out.println("+-----------+--------------------------+");
  L774: while (true) {
			System.out.print("\nEnter the category number > ");
			int num1 = input.nextInt();
			boolean number = true;
			for (int i = 0; i < category.length; i++) {
				if ((num1 -1) == i) {
					items[items.length-1].category = category[i].name;
					number = false;
					break L774;
				}
			}
			if (number) {
				System.out.println("Inavid number. Try again!");
				continue L774;
			}
		}
		System.out.print("\nDescription  : ");
		items[items.length-1].desc = input.next();
		System.out.print("Unit price   : ");
		items[items.length-1].unitPrice = input.next();
		System.out.print("Qty on hand  : ");
		items[items.length-1].qtyOnHand = input.next();
		System.out.print("added successfully! Do you want to add another Item(Y/N)? ");
		char add = input.next().charAt(0);
		if (add == 'Y' || add == 'y') {
			clearConsole();
			addItem();
		}
		if (add == 'N' || add == 'n') {
			clearConsole();
			stockManage();
		}
		else {
			clearConsole();
			logOut();
		}
	}
	public static Item[] growItems() {
		Item[] temp = new Item[items.length + 1];
		for (int i = 0; i < items.length; i++){
				temp[i] = items[i];
		}
		return temp;
	}
	public static void getItemsSupplierWise() {
		System.out.println("+-------------------------------------------------------------------+");
		System.out.printf("%-27s%-41s%s","|","SEARCH SUPPLIER","|\n");
		System.out.println("+-------------------------------------------------------------------+");
		//In-order to avoid recurring can't find s.out if we cick getItemsSupplierWise without adding Items/Suppliers
		if (supplier.length == 0 || null == supplier[0]) {
			System.out.println("\nOOPS! It seems that you don't have any Items in the system.");
			System.out.print("Do you want to add a new Item?(Y/N) ");
			char yesOrNo = input.next().charAt(0);
			if (yesOrNo == 'Y' || yesOrNo == 'y') {
				clearConsole();
				addItem(); 
			}
			else {
				clearConsole();
				stockManage();
			}
		}
  L836: while(true) {
			System.out.print("\nEnter Supplier Id: ");
			String id = input.next();
			boolean flag = true;
			for (int i = 0; i < supplier.length; i++){
				if (id.equals(supplier[i].id)){
					flag = false;
					System.out.println("Supplier Name: "+supplier[i].name);
					break;
				}
			}
			if (flag) {
				System.out.println("Invalid Supplier Id. Try again!");
				continue L836;
			}
			System.out.println("\n+-------------+-------------+-------------+-------------+-------------+");
			System.out.printf("%-3s%-11s%-2s%-12s%-3s%-11s%-2s%-12s%-3s%-11s%s","|","ITEM CODE","|","DESCRIPTION","|","UNIT PRICE","|","QTY ON HAND","|","CATEGORY","|\n");
			System.out.println("+-------------+-------------+-------------+-------------+-------------+");
			for (int i = 0;i < items.length;i++) {
				if (id.equals(items[i].supplierId)) {
					System.out.printf("%s%9s%5s%9s%5s%9s%5s%9s%5s%9s%5s%n","|",items[i].itemCode,"|",items[i].desc,"|",items[i].unitPrice,"|",items[i].qtyOnHand,"|",items[i].category,"|");
				}
			}
			System.out.println("+-------------+-------------+-------------+-------------+-------------+");
			System.out.print("searched successfully! Do you want another search?(Y/N) ");
			char search = input.next().charAt(0);
			if (search == 'Y' || search == 'y') {
				clearConsole();
				getItemsSupplierWise();
			}
			if (search == 'N' || search == 'n') {
				clearConsole();
				stockManage();
			}
			else {
				clearConsole();
				logOut();
			}
		}	
	}
	public static void viewItems() {
		System.out.println("+-------------------------------------------------------------------+");
		System.out.printf("%-29s%-39s%s","|","VIEW ITEMS","|\n");
		System.out.println("+-------------------------------------------------------------------+\n");
		//In-order to avoid nullPointerException RunTime error if we cick viewItems without adding ItemCategories
		if (null == category[0]) {
			System.out.println("OOPS! It seems that you don't have any item categories in the system.");
			System.out.print("Do you want to add a new item category?(Y/N) ");
			char yesOrNo = input.next().charAt(0);
			if (yesOrNo == 'Y' || yesOrNo == 'y') {
				clearConsole();
				addNewItemCategory();
			}
			else {
				clearConsole();
				stockManage();
			}
		}
		for (int a = 0; a < category.length; a++) {
			System.out.println(category[a].name+":");
			System.out.println("+-------------+-------------+-------------+-------------+-------------+");
			System.out.printf("%-6s%-8s%-6s%-8s%-5s%-9s%-5s%-9s%-7s%-7s%s","|","SID","|","CODE","|","DESC","|","PRICE","|","QTY","|\n");
			System.out.println("+-------------+-------------+-------------+-------------+-------------+");
			for (int i = 0;i < items.length;i++) {
				if (category[a].name.equals(items[i].category)) {
					System.out.printf("%s%9s%5s%9s%5s%9s%5s%9s%5s%9s%5s%n","|",items[i].supplierId,"|",items[i].itemCode,"|",items[i].desc,"|",items[i].unitPrice,"|",items[i].qtyOnHand,"|");
				}
			}
			System.out.println("+-------------+-------------+-------------+-------------+-------------+\n");
		}
		System.out.print("Do you want to go stock manage page?(Y/N) ");
		char yesOrNo = input.next().charAt(0);
		if (yesOrNo == 'Y' || yesOrNo == 'y') {
			clearConsole();
			stockManage();     
		}
		if (yesOrNo == 'N' || yesOrNo == 'n') {
			clearConsole();
			homePage();
		}
		else {
			clearConsole();
			logOut();
		}
	}
	public static void rankItemsPerUnitPrice() {
		System.out.println("+-------------------------------------------------------------------+");
		System.out.printf("%-27s%-41s%s","|","RANKED UNIT PRICE","|\n");
		System.out.println("+-------------------------------------------------------------------+\n");
		
		for (int i = 0; i < items.length -1 ; i++) {
			if (Double.parseDouble(items[i].unitPrice) > Double.parseDouble(items[i+1].unitPrice)) {
				Item temp = items[i];
				items[i] = items[i+1];
				items[i+1] = temp;
			}
		}
		System.out.println("+-------------+-------------+-------------+-------------+-------------+-------------+");
		System.out.printf("%-6s%-8s%-6s%-8s%-5s%-9s%-5s%-9s%-7s%-7s%-5s%-9s%s","|","SID","|","CODE","|","DESC","|","PRICE","|","QTY","|","CAT","|\n");
		System.out.println("+-------------+-------------+-------------+-------------+-------------+-------------+");
		for (int i = 0;i < items.length;i++) {
			System.out.printf("%s%9s%5s%9s%5s%9s%5s%9s%5s%9s%5s%9s%5s%n","|",items[i].supplierId,"|",items[i].itemCode,"|",items[i].desc,"|",items[i].unitPrice,"|",items[i].qtyOnHand,"|",items[i].category,"|");
		}
		System.out.println("+-------------+-------------+-------------+-------------+-------------+-------------+");
		System.out.print("Do you want to go stock manage page?(Y/N) ");
		char yesOrNo = input.next().charAt(0);
		if (yesOrNo == 'Y' || yesOrNo == 'y') {
			clearConsole();
			stockManage();       
		}
		if (yesOrNo == 'N' || yesOrNo == 'n') {
			clearConsole();
			homePage();
		}
		else {
			clearConsole();
			logOut();
		}
	}
	public static void main(String args[]) {
		
		loginPage();	
	}
}
