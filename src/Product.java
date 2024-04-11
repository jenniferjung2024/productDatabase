public class Product {
   
   private String name;
   private String productID;
   private double price;
   private String manufacturer;
   private Department department;
   
   private enum Department {
      HOME, FOOD, CLOTHING, ELECTRONICS, TOYS, BOOKS, SPORTING_GOODS, ACCESSORIES, FOOTWEAR, HEALTHandBEAUTY, AUTOMOTIVE, STATIONARY
   }

   public Product() {
      name = "null";
      productID = "null";
      price = 0.00;
      manufacturer = "null";      
   }
     
   public Product(String name, double price) {
      this.name = name;
      this.price = price;
   }
     
   public String getProductName() {
      return name;
   }
     
   public void setProductName(String name) {
      this.name = name;
   }
     
   public String getProductID() {
      return productID;
   }
     
   public void setProductID(String productID) {
      this.productID = productID;
      // In a real situation, I would probably want this to be automatic, but because of time-constraints, I did not go futher with this idea
   }
     
   public double getPrice() {
      return price;
   }
     
   public void setPrice(double price) {
      this.price = price;
   }
     
   public String getManufacturer() {
      return manufacturer;
   }
     
   public void setManufacturer(String manufacturer) {
      this.manufacturer = manufacturer;
   } 
     
   public String getDepartment() {
      return department.toString();
   }
     
   public void setDepartment(String inputDepartment) {
                
      if (inputDepartment.equals("HOME")) {
         department = Department.HOME;
      }
           
      else if (inputDepartment.equals("FOOD")) {
         department = Department.FOOD;
      }
           
      else if (inputDepartment.equals("CLOTHING")) {
         department = Department.CLOTHING;
      }
           
      else if (inputDepartment.equals("ELECTRONICS")) {
         department = Department.ELECTRONICS;
      }
           
      else if (inputDepartment.equals("TOYS")) {
         department = Department.TOYS;
      }
           
      else if (inputDepartment.equals("BOOKS")) {
         department = Department.BOOKS;
      }
         
      else if (inputDepartment.equals("SPORTING_GOODS")) {
         department = Department.SPORTING_GOODS;
      }
           
      else if (inputDepartment.equals("ACCESSORIES")) {
         department = Department.ACCESSORIES;
      }
           
      else if (inputDepartment.equals("FOOTWEAR")) {
         department = Department.FOOTWEAR;
      }
           
      else if (inputDepartment.equals("HEALTHandBEAUTY")) {
         department = Department.HEALTHandBEAUTY;
      }
           
      else if (inputDepartment.equals("AUTOMOTIVE")) {
         department = Department.AUTOMOTIVE;
      }

      else if (inputDepartment.equals("STATIONARY")) {
         department = Department.STATIONARY;
      }
           
      else {
         System.out.println("Department not found.  To set a different department, please enter valid department (HOME, FOOD, CLOTHING, ELECTRONICS, TOYS, BOOKS, SPORTING_GOODS, ACCESSORIES, FOOTWEAR, HEALTHandBEAUTY, AUTOMOTIVE, STATIONARY)");
         // Probably could have done some kind of try/catch or exception handling for this, but did not learn how to do it yet...
      }
                           
   }
     
     
   public String toString() {
      return "Product name: " + name +
      "\nProduct ID: " + productID +
      "\nPrice: $" + String.format("%,.2f", price) +
      "\nManufacturer: " + manufacturer +
      "\nDepartment: " + department + "\n";
   }


   public void makeEmpty() {
      name = "empty";
      productID = "empty";
      price = 0.00;
      manufacturer = "empty";
      department = null;
   }
    
      // Method to check if Product line is empty
      public boolean isEmpty() {
         return name.equals("empty");
      }



}
   
   
   