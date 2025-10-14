export default function Item({ items }) {
  return (
    <div>
      <table border={1}>
        <thead>
          <tr>
            <th>아이디</th>
            <th>이름</th>
            <th>나이</th>
            <th>주소</th>
          </tr>
        </thead>
        <tbody>{items.map((item, index) => drawTable(item, index))}</tbody>
      </table>
    </div>
  );
}

function drawTable(item, index) {
  return (
    <tr key={index}>
      <td>{item.id}</td>
      <td>{item.name}</td>
      <td>{item.age}</td>
      <td>{item.address}</td>
    </tr>
  );
}
