import {NotificationType} from "./notification.type";

export interface Notification {
  type: NotificationType,
  message: string
}
