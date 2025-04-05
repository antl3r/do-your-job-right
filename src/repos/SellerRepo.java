package repos;

import java.util.ArrayList;

import abstracts.UserRepository;
import classes.Seller;

public class SellerRepo extends UserRepository<Seller> {
    private static ArrayList<Seller> sellerList = new ArrayList<Seller>();

    public Seller getSellerbyName( String name){
        for (Seller seller : sellerList ){
            if (seller.getUsername().equalsIgnoreCase(name)){
                return seller;
            }
        }
        return null;
    }

    public static ArrayList<Seller> getSellerList(){
        return sellerList;
    }
}
