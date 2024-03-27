package com.bookonline.sessions;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import com.bookonline.entities.CartItem;

@Stateless
public class CartItemManagement {

    @PersistenceContext
    private EntityManager entityManager;

    public void addCartItem(CartItem cartItem) {
        entityManager.persist(cartItem);
    }

    public void removeCartItem(Long cartItemId) {
        CartItem cartItem = entityManager.find(CartItem.class, cartItemId);
        if (cartItem != null) {
            entityManager.remove(cartItem);
        }
    }

    public void updateCartItemQuantity(Long cartItemId, int quantity) {
        CartItem cartItem = entityManager.find(CartItem.class, cartItemId);
        if (cartItem != null) {
            cartItem.setQuantity(quantity);
            entityManager.merge(cartItem);
        }
    }

    public List<CartItem> getAllCartItems() {
        return entityManager.createQuery("SELECT c FROM CartItem c", CartItem.class).getResultList();
    }
}
