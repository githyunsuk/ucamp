import Item from "./Item";

export default function Products({ product, handleStock, addCart }) {
  return (
    <>
      <h1>상품 목록</h1>
      <table border={1}>
        <thead>
          <tr>
            <th>이름</th>
            <th>가격</th>
            <th>설명</th>
            <th>재고</th>
            <th>재고-</th>
            <th>재고+</th>
            <th>구매</th>
          </tr>
        </thead>
        <tbody>
          {product.map((data) => (
            <Item
              data={data}
              key={data.pid}
              handleStock={handleStock}
              addCart={addCart}
            />
          ))}
        </tbody>
      </table>
    </>
  );
}
