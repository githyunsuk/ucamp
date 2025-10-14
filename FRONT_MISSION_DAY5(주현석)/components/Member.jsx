import Item from "./Item";

export default function Member() {
  const members = [
    {
      id: 1,
      name: "홍길동",
      age: 25,
      address: "서울시 강남구",
    },
    {
      id: 2,
      name: "김길동",
      age: 30,
      address: "부산시 해운대구",
    },
    {
      id: 3,
      name: "이길동",
      age: 28,
      address: "대전시 유성구",
    },
    {
      id: 4,
      name: "주길동",
      age: 27,
      address: "서울시 강동구",
    },
    {
      id: 5,
      name: "민길동",
      age: 25,
      address: "서울시 노원구",
    },
  ];

  return (
    <div>
      <Item items={members}/>
    </div>
  );
}
