import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
/** A class to hold Product/Item Detail */
class Product{
    Integer id;
    String name;
    Float price;
    Integer orderQuantity;   
    /** Create Product object using default constructor. */
    public Product() {
    }
    /** Create Product object for given product id. */
    public Product(Integer id) {
        this.id = id;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Float getPrice() {
        return price;
    }
    public void setPrice(Float price) {
        this.price = price;
    }
    public Integer getOrderQuantity() {
        return orderQuantity;
    }
    public void setOrderQuantity(Integer orderQuantity) {
        this.orderQuantity = orderQuantity;
    }    
    /** The products will be uniquely identified in JVM through product id. */
    @Override
    public int hashCode() {
        return id;
    }
    /** Define the equality of two products. */
    @Override
    public boolean equals(Object obj) {
        Product p=(Product) obj;
        return id==p.id;
    }    
}

/** A class contains features to manage product cart. */
class Cart{    
    /** All Cart items will be stored in the List. */
    private List<Product> items= new ArrayList();
    
    /** Add a Product in Cart.*/
    public void addToCart(Product p){
        items.add(p);
    }
    /** Remove a Product from Cart.*/
    public void removeFromCart(Product p){        
        items.remove(p);
    }   
    /** Remove all Products from Cart.*/
    public void emptyCart(){        
        items.clear();
    }
    /** Returns all cart items.*/
    public List<Product> getItems() {
        return items;
    }    
}

class CartExtension extends Cart{
    String output = "";
    /** Set of all possible options for PaymentStatus. */
    enum PaymentStatus{
        DONE, DUE, PARTIAL
    };

    /** Payment Status of current Cart. */
    private PaymentStatus status;

    /** Payment Mode used by user. */
    private String paymentMode;

    /**Amount Paid by user. */
    private Float paymentAmount=0F;

    /** Date of payment. */
    private Date paymentDate;

    /** Total amount of ordered items. */
    private Float totalAmount=0F;

    /** Due amount after payment. */
    private Float paymentDue=0F;

    /**
     Method handles the Checkout process using different sub-operations like
     * Payment,
     * Order Confirmation,
     * Print Payment Summary,
     * Empty cart after payment.
     */
    public void checkout(){
        handlePayment();
        confirmOrder();
        printPaymentSummary();
        emptyCart();//after confirmation of order empty the cart
    }
    /** A method to handle the payment. */
    public void handlePayment(){
        // paymentMode=JOptionPane.showInputDialog("Enter Payment Mode(Cash/Cheque): ");
       String[] mode= {"Cash", "Cheque"};
        int paymentModeIndex=JOptionPane.showOptionDialog(null,"Choose Payment Mode: ",
            "Mode",0,JOptionPane.QUESTION_MESSAGE,null,mode,0);
        paymentMode=mode[paymentModeIndex];
        paymentDate=new Date();//current date
        paymentAmount=new Float(JOptionPane.showInputDialog("Enter Amount, Total Due is: "+totalAmount));
        paymentDue=totalAmount-paymentAmount;
    }
    /** The method handles the order confirmation on the basic of payment made. */
    public void confirmOrder(){
        if(paymentDue==0.0){
            status=PaymentStatus.DONE;
        }else if(paymentDue>0.0 && paymentDue<totalAmount){
            status=PaymentStatus.PARTIAL;
        }else if(paymentAmount==0.0){
            status=PaymentStatus.DUE;
        }
        if(status==PaymentStatus.DONE || status==PaymentStatus.PARTIAL){
           System.out.println("SUCCESS: Your order is confirmed and will be processed soon.");
        }else if(status==PaymentStatus.DUE){
           System.out.println("FAILED: Your order is failed. No payment done.");
        }
    }
    /** The method Prints all the products from present Cart. */
    public void printCart(){
        output = "";
        output += "==================================\n";
        output += "CART ITEMS:\n";
        output += "==================================\n";
        for (Product p : getItems()) {
            output += "PRODUCT ID: "+p.getId() + "\n";
            output += "PRODUCT NAME: "+p.getName() + "\n";
            output += "PRODUCT PRICE: "+p.getPrice() + "\n";
            output += "PRODUCT ORDER QTY: "+p.getOrderQuantity() + "\n";
            Float total=p.getOrderQuantity()* p.getPrice();
            output += "TOTAL: "+total + "\n";
            totalAmount=totalAmount+total;
            output += "\n";
        }
        output += "==================================" + "\n";
        output += "Net Total : "+totalAmount + "\n";
        output += "==================================  \n";
        JOptionPane.showMessageDialog(null,output,"info", JOptionPane.INFORMATION_MESSAGE);
    }
    /** The method prints the payment summary. */
    void printPaymentSummary(){
        output = "";
        output += "\n";
        output += "PAYMENT SUMMARY: \n";
        output += "================================== \n";
        output += "TOTAL AMOUNT: "+totalAmount + "\n";
        output += "PAYMENT AMOUNT: "+paymentAmount + "\n";
        output += "PAYMENT DUE: "+paymentDue + "\n";
        output += "PAYMENT MODE: "+paymentMode + "\n";
        output += "PAYMENT DATE: "+paymentDate + "\n";
        output += "PAYMENT STATUS: "+status + "\n";
        JOptionPane.showMessageDialog(null,output,"info", JOptionPane.INFORMATION_MESSAGE);
    }
}

/** This is a main class to test the above Shopping Cart Scenario. */
public class TestCart {
    public static void main(String[] args) {

        CartExtension cart=new CartExtension();

        //Add First product to Cart
        Product p1=new Product();
        p1.setId(1);
        p1.setName("Keyboard");
        p1.setPrice(1500.0F);
        p1.setOrderQuantity(2);
        cart.addToCart(p1);

        //Add Second product to Cart
        Product p2=new Product();
        p2.setId(2);
        p2.setName("Mouse");
        p2.setPrice(500.0F);
        p2.setOrderQuantity(4);
        cart.addToCart(p2);

        //Add Third product to Cart
        Product p3=new Product();
        p3.setId(3);
        p3.setName("Monitor");
        p3.setPrice(8000.0F);
        p3.setOrderQuantity(2);
        cart.addToCart(p3);

        //Remove Second Product from Cart
        Product p=new Product(2);
        cart.removeFromCart(p);

        //Print Present Cart
        cart.printCart();
        //Proceed for checkout
        cart.checkout();
    }
}
