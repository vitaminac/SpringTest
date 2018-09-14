export class AppConfig {
  public static REDIRECT_DELAY: number = 3000;
  // TODO: replace with HATEOA
  public static API_ENDPOINT = "http://localhost:80"; // cannot end with /
  public static LOGIN: string = "login";
  public static LOGOUT: string = "logout";
  public static USERS: string = "users";
  public static REGISTER: string = "register";
  public static VIDEOS: string = "videos";
  public static IMAGES: string = "images";

  // Http Error Code
  public static UNAUTHORIZED: number = 401;
  public static NOT_FOUND: number = 404;

  // Http Headers
  public static CONTENT_TYPE: string = "Content-Type";
  public static FORM_DATA: string = "application/form-data";
  public static JSON: string = "application/json";

  public static NOTIFICATION_DISPLAY_SPAN_MILLISECOND = 5000;
  public static TIME_SPAN_BETWEEN_NOTIFICATION_MILLISECOND = 3000;

  // File Type
  public static JPEG = "image/jpeg";
  public static MP4 = "video/mp4";
}
