import Item from "./Item";
import products from "./ProductList";
import { useState } from "react";

export default function Products() {
  const [product, setProduct] = useState(products);

  function plusStock(pid) {
    const newProduct = product.map((data) => {
      return data.pid === pid ? { ...data, stock: data.stock + 1 } : data;
    });

    setProduct(newProduct);
  }

  function minusStock(pid) {
    const newProduct = product.map((data) => {
      return data.pid === pid ? { ...data, stock: data.stock - 1 } : data;
    });
    
    setProduct(newProduct);
  }

  return (
    <>
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
              plusStock={plusStock}
              minusStock={minusStock}
            />
          ))}
        </tbody>
      </table>
    </>
  );
}
