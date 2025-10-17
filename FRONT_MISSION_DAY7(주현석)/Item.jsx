export default function Item({ data, plusStock, minusStock }) {
  return (
    <>
      <tr>
        <td>{data.name}</td>
        <td>{data.price}</td>
        <td>{data.desc}</td>
        <td>{data.stock}</td>
        <td>
          <button
            onClick={() => {
              minusStock(data.pid);
            }}
          >
            -
          </button>
        </td>
        <td>
          <button
            onClick={() => {
              plusStock(data.pid);
            }}
          >
            +
          </button>
        </td>
        <td>{data.stock > 0 ? <button>구매하기</button> : "구매불가"}</td>
      </tr>
    </>
  );
}
