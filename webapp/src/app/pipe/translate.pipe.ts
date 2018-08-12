import {Pipe, PipeTransform} from '@angular/core';
import {TranslationService} from "../service/translation.service";

@Pipe({
  name: 'translate',
  pure: false
})
export class TranslatePipe implements PipeTransform {
  constructor(private translate: TranslationService) {
  }

  transform(key: any): any {
    return this.translate.translate(key);
  }
}
