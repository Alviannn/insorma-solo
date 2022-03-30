package com.github.alviannn.insorma.shared;

import androidx.annotation.Nullable;

import com.github.alviannn.insorma.R;
import com.github.alviannn.insorma.models.Product;
import com.github.alviannn.insorma.models.User;

import java.util.ArrayList;
import java.util.List;

public class SharedData {

    public final static String PRODUCT_POSITION_KEY = "PRODUCT_POSITION";
    public final static String CURRENT_USERNAME_KEY = "CURRENT_USERNAME";

    public final static int USER_CHANGE_CODE = 1;

    public final static List<User> USER_LIST = new ArrayList<>();
    public final static List<Product> PRODUCT_LIST = new ArrayList<>();

    // data seeding
    static {
        USER_LIST.add(new User("alviandq@example.com", "alviandq", "081234567890", "alvian123"));

        PRODUCT_LIST.add(new Product(R.mipmap.light_grey_chair, "Light Grey Chair", 100, 4.9));
        PRODUCT_LIST.add(new Product(R.mipmap.white_classy_chair, "White Classy Chair", 90, 4.4));
        PRODUCT_LIST.add(new Product(R.mipmap.baggebo, "BAGGEBO", 59, 4.5));
        PRODUCT_LIST.add(new Product(R.mipmap.sundvik, "SUNDVIK", 249, 4.0));
    }

    /**
     * Checks if a user exists, like... do they registered?
     *
     * @return a null if not exists, otherwise will be the user if they are registered
     */
    @Nullable
    public static User findUser(String username, String email) {
        for (User user : USER_LIST) {
            boolean sameUsername = user.getUsername().equals(username);
            boolean sameEmail = user.getEmail().equals(email);

            if (sameUsername || sameEmail) {
                return user;
            }
        }

        return null;
    }

}
