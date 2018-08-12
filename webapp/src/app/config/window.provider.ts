import {FactoryProvider, ValueProvider} from "@angular/core";
import {WINDOW} from "./inject.token";

export const windowProvider: ValueProvider = {
  provide: WINDOW,
  useValue: window
};
