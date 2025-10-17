export default function ConfirmCart({ cart }) {
  let totalCount = 0;
  let totalPrice = 0;

  cart.forEach((element) => {
    totalCount += element.count;
    totalPrice += element.count * element.price;
  });

  return (
    <>
      <h3>
        {totalCount}개 상품 / 합계 금액: {totalPrice}원
      </h3>
    </>
  );
}
