import "./App.css";
import Cart from "./components/Cart";
import ConfirmCart from "./components/ConfirmCart";
import Products from "./components/Products";
import products from "./components/ProductList";
import { useState } from "react";

//App
function App() {
  const [product, setProduct] = useState(products);
  const [cart, setCart] = useState([]);

  //재고 관리 함수
  function handleStock(pid, num) {
    const productItem = product.find((data) => data.pid === pid);

    //빼려는데 재고가 0이라면?
    if (productItem.stock === 0 && num < 0) {
      return;
    }
    const newProduct = product.map((data) => {
      return data.pid === pid ? { ...data, stock: data.stock + num } : data;
    });

    setProduct(newProduct);
  }

  //카트에 물건 추가
  function addCart(object) {
    const exists = cart.find((data) => data.pid === object.pid);
    const productItem = product.find((data) => data.pid === object.pid);
    let newCart;

    //상품 재고가 부족하면 return
    if (productItem.stock < 1) {
      alert("재고가 부족합니다!");
      return;
    }
    //이미 장바구니에 존재하면 +1
    if (exists) {
      newCart = cart.map((data) => {
        return data.pid === object.pid
          ? { ...data, count: data.count + 1 }
          : data;
      });
    } else {
      //아니면 새로 추가
      newCart = [
        ...cart,
        {
          pid: object.pid,
          name: object.name,
          price: object.price,
          count: 1,
        },
      ];
    }

    setCart(newCart);
  }

  //카트에 물건 빼기
  function minusCart(pid) {
    const cartItem = cart.find((item) => item.pid === pid);

    if (!cartItem) return;

    //카트 수량이 1개 남은 상태면 삭제
    if (cartItem.count === 1) {
      removeCart(pid);
      return;
    }

    setCart(
      cart.map((data) => {
        return data.pid === pid ? { ...data, count: data.count - 1 } : data;
      })
    );
  }

  //카트에서 물건 삭제
  function removeCart(pid) {
    setCart(cart.filter((data) => data.pid !== pid));
  }

  return (
    <>
      <Products handleStock={handleStock} product={product} addCart={addCart} />
      <Cart
        cart={cart}
        handleStock={handleStock}
        addCart={addCart}
        minusCart={minusCart}
        removeCart={removeCart}
      />
      <ConfirmCart cart={cart} />
    </>
  );
}

export default App;
