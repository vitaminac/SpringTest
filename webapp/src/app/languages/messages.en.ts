import {Messages} from "./messages";

// TODO: pattern singleton
export const English: Messages = {
  get Welcome(): string {
    return "Welcome";
  }
};
