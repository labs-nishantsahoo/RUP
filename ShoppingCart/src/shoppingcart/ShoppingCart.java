/*
Created by Nishant Sahoo
*/
package shoppingcart;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.*;

/**
 *
 * @author DELL
 */

class CartDetails // defintion of the class CartDetails
{
    String[] items = {"Motorola 5", "One Plus 5", "Iphone 7"};
    int[] cost = {15000, 38000, 56000};
    int[] cartItem = {0,0,0};
    int[] cartQuantity = {0,0,0};
    int totalCost;
    String[] username = {"nishant", "kanishk", "manish"};
    String[] password = {"sahoo", "kanny", "ambicorp"};
    boolean discount = false;
    
    void showProducts() // definition of the function showProducts
    {
        for(int i=0;i<3;i++)
        {
            System.out.println((i+1) + " - " + items[i] + " : " + cost[i]);
        }
    } // end of the function showProducts
    
    public void login() // definition of the function login
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter username: ");
        String uName = sc.nextLine();
        System.out.print("Enter password: ");
        String passKey = sc.nextLine();
        for(int i=0;i<3;i++)
        {
            if(uName.equals(username[i]) && passKey.equals(password[i]))
            {
                System.out.println("Login successful");
                return;
            }
        }
        System.out.println("Wrong username or password");
    } // end of the function definition 
    
    public int calcTotalCost()
    {
        int totalcost = 0;
            for(int i=0;i<3;i++)
            {
                if(cartItem[i]==1)
                {
                    totalcost += (cost[i]*cartQuantity[i]);
                }
            }
        if(this.discount)
        {
            return (totalcost-1000);
        }
        return totalcost;
    }
    
    public void payment() // definition of the function payment
    {
        System.out.println("Payment Gateway");
        Scanner sc = new Scanner(System.in);
        int opt;
        String addr;
        System.out.print("Enter your address: ");
        addr = sc.nextLine();
        System.out.println("1: Cash on delivery");
        System.out.println("2: Credit/Debit Card");
        System.out.print("Enter the desired choice: ");
        opt = sc.nextInt();
        sc.nextLine(); // clear buffer
        switch(opt)
        {
            case 1: System.out.println("Your order is placed and will be delivered at " + addr);
                    System.out.println("Total amount is: " + calcTotalCost());
                    break;
                    
            case 2: double cardNum;
                    int cvv;
                    System.out.print("Enter your card number: ");
                    cardNum = sc.nextDouble();
                    sc.nextLine();
                    cvv = sc.nextInt();
        }
    } // end of the function definition
    
    public void addToCart(int opt, int quantity) // definition of the function addToCart
    {
        if(this.cartItem[opt-1]==0)
        {
            this.cartItem[opt-1] = 1;
            this.cartQuantity[opt-1] = quantity; 
        }
        else
        {
            this.cartQuantity[opt-1] += quantity;
        }
    } // end of the function addToCart
    
    public int isEmpty() // definition of the function isEmpty
    {
        int size = 0;
        for(int i=0;i<3;i++)
        {
            size += cartItem[i];
        }
        return size;
    } // end of the function definition
    
    public void showCart() // definition of the function showCart
    {
        if(isEmpty()!=0)
        {
            System.out.println("Cart Details");
            for(int i=0;i<3;i++)
            {
                if(cartItem[i]==1)
                {
                    System.out.println((i+1) +  " - Product: " + items[i] + " ; Cost:  " + (cost[i]*cartQuantity[i]) + " ; Quantity: " + cartQuantity[i]);
                }
            }
            System.out.println("Total cost: " + calcTotalCost());
        }
        else
        {
            System.out.println("Cart is empty");
        }
    } // end of the function definition
    
    public void updateCart(int edNo, int edQuan) // definition of the function updateCart
    {
        if(cartItem[edNo-1]!=0)
        {
            if(edQuan>0)
            {
                cartQuantity[edNo-1] = edQuan;
                System.out.println("Cart updated");
                showCart(); // call of the function showCart
            }
            else
            {
                System.out.println("Invalid quantity");
            }
        }
        else
        {
            System.out.println("Wrong option");
        }
    } // end of the function definition
    
    public void removeItem(int opt) // definition of the function removeItem
    {
        if(cartItem[opt-1]!=0)
        {
            cartItem[opt-1] = 0;
            cartQuantity[opt-1] = 0;
            System.out.println("Updated cart");
            showCart(); // call of the function showCart
        }
        else
        {
            System.out.println("Wrong option");
        }
    } // end of the function definition
    
    public void discount() // definition of the function checkout
    {
        String couponCode;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the coupon code: ");
        couponCode = sc.nextLine();
        if(couponCode.equals("minus1000"))
        {
            System.out.println("Discount applied");
            this.discount = true;
        }
        else
        {
            System.out.println("Coupon code invalid");
            this.discount = false;
        }
    } // end of the function definition
    
    public void clearCart() // definition of the function clearCart
    {
        for(int i=0;i<3;i++)
        {
            cartItem[i] = 0;
            cartQuantity[i] = 0;
        }
        System.out.println("Cart cleared");
    } // end of the function definition
    
} // end of the class definition 

public class ShoppingCart {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) // definition of the main function
    {
        int choice;
        Scanner sc = new Scanner(System.in);
        CartDetails cd = new CartDetails();
        System.out.println("ShoppingCart");
        do
        {
            System.out.println("1: Add to cart");
            System.out.println("2: Display cart");
            System.out.println("3: Remove from cart");
            System.out.println("4: Edit");
            System.out.println("5: Clear Cart");
            System.out.println("6: Coupon Code for Discounts");
            System.out.println("7: Login");
            System.out.println("8: Payment");
            System.out.println("9: Logout");
            System.out.print("Enter the desired choice: ");
            choice = sc.nextInt();
            sc.nextLine();
            switch(choice)
            {       
                case 1: cd.showProducts();
                        int opt, quantity;
                        System.out.print("Enter the desired option: ");
                        opt = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Enter quantity: ");
                        quantity = sc.nextInt();
                        cd.addToCart(opt, quantity); // add to cart
                        break;
                
                case 2: cd.showCart(); // call of the function showCart
                        break;
                
                case 3: cd.showCart(); // call of the function
                        if(cd.isEmpty()!=0)
                        {
                            int delOpt;
                            System.out.print("Enter the product number that you want to remove: ");
                            delOpt = sc.nextInt();
                            cd.removeItem(delOpt); // removeItem
                        }
                        break;
                    
                case 4: cd.showCart(); // call of the function showCart
                        if(cd.isEmpty()!=0)
                        {
                            int editOpt, editQuant;
                            System.out.print("Enter the product number that you want to edit: ");
                            editOpt = sc.nextInt();
                            sc.nextLine();
                            System.out.print("Enter the new quanitity: ");
                            editQuant = sc.nextInt();
                            cd.updateCart(editOpt, editQuant); // call of the function updateCart
                        }
                        break;
                
                case 5: cd.clearCart(); // call of the function clearCart
                        break;
                    
                case 6: cd.discount(); // call of the function checkout
                        break;
                
                case 7: cd.login(); // call of the function login
                        break;
                
                case 8: cd.payment(); // call of the function payment
                        break;
                    
                case 9: choice = 9;
                        break;
                    
                default: System.out.println("Wrong choice");
            }
        }while(choice!=9); // end of do while
    } // end of the main function 
} // end of the class definition
