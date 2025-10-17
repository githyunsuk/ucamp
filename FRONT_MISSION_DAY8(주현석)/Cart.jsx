import CartList from "./CartList";

export default function Cart(props) {
  const { cart, handleStock, addCart, minusCart, removeCart } = props;

  return (
    <>
      <h2>장바구니 목록</h2>
      <table border={2}>
        <thead>
          <tr>
            <th>상품명</th>
            <th>수량</th>
            <th>총가격</th>
            <th>상품빼기</th>
            <th>상품추가</th>
            <th>상품삭제</th>
          </tr>
        </thead>
        <tbody>
          {cart.map((data) => (
            <CartList
              data={data}
              key={data.pid}
              handleStock={handleStock}
              addCart={addCart}
              minusCart={minusCart}
              removeCart={removeCart}
            />
          ))}
        </tbody>
      </table>
    </>
  );
}
