import { del, get, patch } from "Utils/api";

interface IPatchReview {
  reviewId: number;
  userId: number;
  reviewTitle: string;
  reviewBody: string;
  tasteStar: number;
  facilityStar: number;
  priceStar: number;
}

export const useReview = () => {
  const getReview = async ({ reviewId }: any) => {
    const res = await get(`/review/${reviewId}`).then((r: any) => {
      console.log(r);
      return r;
    });
    return res;
  };

  const patchReview = async ({
    reviewId,
    userId,
    reviewTitle,
    reviewBody,
    tasteStar,
    facilityStar,
    priceStar,
  }: IPatchReview) => {
    const res = await patch(`/review/edit`, {
      reviewId,
      userId,
      reviewTitle,
      reviewBody,
      tasteStar,
      facilityStar,
      priceStar,
    }).then((r: any) => {
      console.log(r);
      return r;
    });
    return res;
  };
  const delReview = async ({ reviewId }: any) => {
    const res = await del(`review/delete/${reviewId}`).then((r: any) => {
      console.log(r);
      return r;
    });
    return res;
  };

  return { getReview, patchReview, delReview };
};
