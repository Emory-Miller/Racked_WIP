import { IUser } from 'app/shared/model/user.model';
import { IRack } from 'app/shared/model/rack.model';
import { StarRating } from 'app/shared/model/enumerations/star-rating.model';
import { RackSize } from 'app/shared/model/enumerations/rack-size.model';

export interface IReview {
  id?: number;
  starRating?: StarRating | null;
  rackSize?: RackSize | null;
  amenities?: string | null;
  comments?: string | null;
  user?: IUser | null;
  rack?: IRack | null;
}

export const defaultValue: Readonly<IReview> = {};
