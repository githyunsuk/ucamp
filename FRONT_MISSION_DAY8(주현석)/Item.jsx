export default function Item({ data, handleStock, addCart }) {
  function plusStock() {
    handleStock(data.pid, +1);
  }

  function minusStock() {
    handleStock(data.pid, -1);
  }

  function orderProduct() {
    addCart(data);
    handleStock(data.pid, -1);
  }
  return (
    <>
      <tr>
        <td>{data.name}</td>
        <td>{data.price}</td>
        <td>{data.desc}</td>
        <td>{data.stock}</td>
        <td>
          <button onClick={minusStock}>-</button>
        </td>
        <td>
          <button onClick={plusStock}>+</button>
        </td>
        <td>
          {data.stock > 0 ? (
            <button onClick={orderProduct}>담기</button>
          ) : (
            "재고없음"
          )}
        </td>
      </tr>
    </>
  );
}
