package com.bookonline.managedbean;

import javax.inject.Inject;
import com.bookonline.entities.CartItem;
import com.bookonline.sessions.CartItemManagement;

public class CartItemManagementBean {

    @Inject
    private CartItemManagement cartItemManagement;

    private Long cartItemId;
    private int quantity;

    public Long getCartItemId() {
        return cartItemId;
    }

    public void setCartItemId(Long cartItemId) {
        this.cartItemId = cartItemId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void addCartItem() {
        CartItem cartItem = new CartItem();
        cartItem.setQuantity(quantity);
        cartItemManagement.addCartItem(cartItem);
    }

    public void removeCartItem() {
        cartItemManagement.removeCartItem(cartItemId);
    }

    public void updateCartItemQuantity() {
        cartItemManagement.updateCartItemQuantity(cartItemId, quantity);
    }
}
