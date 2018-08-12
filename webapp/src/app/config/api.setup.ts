import {AppConfig} from "./app.config";
import {ApiService} from "../service/api.service";

export function apiSetup(api: ApiService) {
  return () => api.load();
}
