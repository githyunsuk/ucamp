export default function CartList(props) {
  const { data, handleStock, addCart, minusCart, removeCart } = props;
  function plusCart() {
    addCart(data);
    handleStock(data.pid, -1);
  }

  function decreseCart() {
    minusCart(data.pid);
    handleStock(data.pid, +1);
  }

  function deleteCart() {
    removeCart(data.pid);
    handleStock(data.pid, data.count);
  }
  return (
    <tr>
      <td>{data.name}</td>
      <td>{data.count}</td>
      <td>{data.price * data.count}</td>
      <td>
        <button onClick={decreseCart}>-</button>
      </td>
      <td>
        <button onClick={plusCart}>+</button>
      </td>
      <td>
        <button onClick={deleteCart}>삭제</button>
      </td>
    </tr>
  );
}
