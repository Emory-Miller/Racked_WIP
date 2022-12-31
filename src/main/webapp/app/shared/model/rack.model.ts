import { IReview } from 'app/shared/model/review.model';

export interface IRack {
  id?: number;
  name?: string | null;
  longitude?: number | null;
  latitude?: number | null;
  imageContentType?: string | null;
  image?: string | null;
  reviews?: IReview[] | null;
}

export const defaultValue: Readonly<IRack> = {};
