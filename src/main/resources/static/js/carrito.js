let cart = [
    { product: 'Producto 1', price: 15, quantity: 1 },
    { product: 'Producto 2', price: 25, quantity: 1 },
]; // Ejemplo de productos en el carrito
let total = 0;

function renderCart() {
    const cartItems = document.getElementById("cart-items");
    cartItems.innerHTML = '';

    cart.forEach((item, index) => {
        const subtotal = item.price * item.quantity;
        total += subtotal;

        const row = document.createElement("tr");

        row.innerHTML = `
            <td>${item.product}</td>
            <td>$${item.price} USD</td>
            <td>
                <input type="number" value="${item.quantity}" min="1" onchange="updateQuantity(${index}, this.value)">
            </td>
            <td>$${subtotal} USD</td>
            <td><button class="delete-btn" onclick="removeFromCart(${index})">🗑️</button></td>
        `;

        cartItems.appendChild(row);
    });

    document.getElementById("total-price").textContent = `$${total} USD`;
}

function updateQuantity(index, newQuantity) {
    cart[index].quantity = parseInt(newQuantity);
    total = 0; // Reiniciar el total antes de recalcular
    renderCart();
}

function removeFromCart(index) {
    cart.splice(index, 1);
    total = 0; // Reiniciar el total antes de recalcular
    renderCart();
}

function clearCart() {
    cart = [];
    total = 0;
    renderCart();
}

// Inicializa el carrito al cargar la página
renderCart();
