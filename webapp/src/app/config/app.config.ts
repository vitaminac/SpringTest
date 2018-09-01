import {URL} from "url";

export class AppConfig {
  public static REDIRECT_DELAY: number = 3000;
  // TODO: replace with HATEOA
  public static API_ENDPOINT_HOST = "localhost";
  public static API_ENDPOINT_PROTOCOL = "http";
  public static API_ENDPOINT_PORT = 80;
  public static API = "api";
  public static LOGIN: string = "login";
  public static LOGOUT: string = "logout";
  public static USERS: string = "users";
  public static REGISTER: string = "register";


  public static UNAUTHORIZED: number = 401;
  public static NOT_FOUND: number = 404;

  public static NOTIFICATION_DISPLAY_SPAN_MILLISECOND = 5000;
  public static TIME_SPAN_BETWEEN_NOTIFICATION_MILLISECOND = 3000;
}
